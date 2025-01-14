import os

def list_files(directory):
    # Daftar folder dan file yang ingin diabaikan
    ignore_folders = ['test', 'build', '.git']
    ignore_files = ['.gitignore']

    for root, dirs, files in os.walk(directory):
        # Memeriksa apakah folder saat ini ada dalam daftar folder yang harus diabaikan
        dirs[:] = [d for d in dirs if d not in ignore_folders]
        
        # Menampilkan folder
        level = root.replace(directory, '').count(os.sep)
        indent = ' ' * 4 * level
        folder_name = os.path.basename(root)
        if folder_name not in ignore_folders:
            print(f"{indent}[DIR] {folder_name}/")
        
        # Menampilkan file, pastikan file tidak ada dalam daftar yang harus diabaikan
        subindent = ' ' * 4 * (level + 1)
        for file in files:
            if file not in ignore_files:
                print(f"{subindent}[FILE] {file}")

# Ganti dengan path ke folder proyek Java Anda
project_directory = 'C:/Users/user/OneDrive/Documents/NetBeansProjects/CRUD_App'

list_files(project_directory)
