import os

# 1. Настройки фильтрации директорий
IGNORE_DIRS = {
    '.git',
    '.idea',
    '.gradle',
    'build',
    '.kotlin',
    '.venv',
    'venv',
    '__pycache__',
    'iosApp',
    '.cxx'
}

# 2. Игнорируемые файлы и секреты
IGNORE_FILES = {
    '.DS_Store',
    'local.properties',
    'google-services.json',
    'to_md.py',
    'project_codebase_dump.md',
}

# 3. Разрешенные расширения для архитектурного анализа
ALLOWED_EXTENSIONS = {
    '.kt',
    '.kts',
    '.py',
    '.xml',
    '.json',
    '.gradle',
    '.toml',        # Каталоги версий зависимостей (libs.versions.toml)
    '.properties',  # gradle.properties
}

# Лимит на размер одного файла (100 КБ), чтобы не забить контекст тяжелыми моками/схемами
MAX_FILE_SIZE_BYTES = 100 * 1024

OUTPUT_FILE = 'project_codebase_dump.md'


def get_lang_by_ext(ext: str) -> str:
    mapping = {
        '.kt': 'kotlin',
        '.kts': 'kotlin',
        '.py': 'python',
        '.xml': 'xml',
        '.json': 'json',
        '.gradle': 'groovy',
        '.toml': 'toml',
        '.properties': 'properties',
    }
    return mapping.get(ext.lower(), '')


def should_ignore_dir(dirname: str) -> bool:
    return dirname in IGNORE_DIRS or dirname.startswith('.')


def should_process_file(file_path: str, filename: str, output_abs: str) -> bool:
    if os.path.abspath(file_path) == output_abs:
        return False
    if filename in IGNORE_FILES or filename.startswith('.'):
        return False

    # Отсекаем файлы из вложенных папок ресурсов (например res/drawable-xxhdpi)
    path_parts = set(os.path.normpath(file_path).split(os.sep))
    if any(p.startswith('drawable') or p.startswith('mipmap') for p in path_parts):
        return False

    _, ext = os.path.splitext(filename)
    return ext.lower() in ALLOWED_EXTENSIONS


def build_tree_structure(root_dir: str, output_abs: str) -> str:
    """Формирует текстовое дерево проекта для ориентации нейросети в архитектуре."""
    tree_lines = []
    for root, dirs, files in os.walk(root_dir):
        dirs[:] = sorted([d for d in dirs if not should_ignore_dir(d)])

        rel_dir = os.path.relpath(root, root_dir)
        depth = 0 if rel_dir == '.' else rel_dir.count(os.sep) + 1
        indent = '  ' * depth

        if rel_dir != '.':
            tree_lines.append(f"{'  ' * (depth - 1)}📁 {os.path.basename(root)}/")

        for f in sorted(files):
            full_path = os.path.join(root, f)
            if should_process_file(full_path, f, output_abs):
                tree_lines.append(f"{indent}📄 {f}")

    return '\n'.join(tree_lines)


def dump_codebase(root_dir: str, output_path: str):
    output_abs = os.path.abspath(output_path)

    with open(output_path, 'w', encoding='utf-8') as out_f:
        out_f.write('# Project Voborot Codebase\n\n')

        # Блок структуры для ориентации LLM в модулях и пакетах
        out_f.write('## Project File Tree\n\n```text\n')
        out_f.write(build_tree_structure(root_dir, output_abs))
        out_f.write('\n```\n\n---\n\n## Source Code\n\n')

        # Обход файлов с сортировкой
        for root, dirs, files in os.walk(root_dir):
            dirs[:] = sorted([d for d in dirs if not should_ignore_dir(d)])

            for file in sorted(files):
                file_path = os.path.join(root, file)

                if should_process_file(file_path, file, output_abs):
                    relative_path = os.path.relpath(file_path, root_dir).replace(os.sep, '/')
                    _, ext = os.path.splitext(file)
                    lang = get_lang_by_ext(ext)

                    out_f.write(f'### File: `{relative_path}`\n\n')

                    # Защита от перегрузки контекста тяжелыми файлами
                    try:
                        file_size = os.path.getsize(file_path)
                        if file_size > MAX_FILE_SIZE_BYTES:
                            out_f.write(f'> *[Файл пропущен: размер {file_size // 1024} КБ превышает лимит {MAX_FILE_SIZE_BYTES // 1024} КБ]*\n\n---\n\n')
                            continue

                        # Использование 4 обратных кавычек исключает сбой разметки из-за блоков кода внутри файлов
                        out_f.write(f'````{lang}\n')
                        with open(file_path, 'r', encoding='utf-8', errors='ignore') as in_f:
                            out_f.write(in_f.read().strip())
                        out_f.write('\n````\n\n---\n\n')
                    except Exception as e:
                        out_f.write(f'[Error reading file: {e}]\n\n---\n\n')

    print(f'Готово! Дамп сохранен в: {output_path}')


if __name__ == '__main__':
    current_dir = os.getcwd()
    dump_codebase(current_dir, OUTPUT_FILE)