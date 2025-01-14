# GUI_JavaCRUD
Aplikasi CRUD Sederhana dengan GUI JAVA
## Prasyarat

### 1. NetBeans IDE
Aplikasi ini dikembangkan menggunakan **NetBeans IDE**. Anda harus menginstal NetBeans untuk dapat membuka dan menjalankan proyek ini.

- **Link Download NetBeans IDE**: [NetBeans Official Download](https://netbeans.apache.org/download/)
  
### 2. Java Development Kit (JDK) 23 (atau lebih tinggi)
Aplikasi ini memerlukan **Java JDK versi 23** atau lebih tinggi.

- **Java Version**:
    - Java(TM) SE Runtime Environment (build 23+37-2369)
    - Java HotSpot(TM) 64-Bit Server VM (build 23+37-2369, mixed mode, sharing)

**Catatan**: Versi Java yang lebih rendah dari versi 8 tidak kompatibel dengan aplikasi ini.

- **Link Download JDK**: [Download JDK 23](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html)

### 3. MySQL Database (menggunakan XAMPP)
Untuk pengelolaan basis data, aplikasi ini menggunakan **XAMPP** sebagai server lokal dan **MySQL** untuk database.

- **Link Download XAMPP**: [Download XAMPP](https://www.apachefriends.org/index.html)

Setelah menginstal XAMPP, pastikan Anda menjalankan **Apache** dan **MySQL** pada kontrol panel XAMPP.

### 4. MySQL Connector/J 9.1.0
Untuk menghubungkan aplikasi dengan MySQL database, aplikasi ini menggunakan **MySQL Connector/J** versi 9.1.0.

- **Link Download MySQL Connector/J**: [Download MySQL Connector/J 9.1.0](https://dev.mysql.com/downloads/connector/j/)

Setelah mengunduhnya, pastikan untuk menambahkannya sebagai library di dalam proyek NetBeans Anda.

## Instalasi dan Pengaturan

### 1. Instalasi NetBeans
1. Unduh dan instal NetBeans IDE dari tautan yang telah disediakan.
2. Buka NetBeans dan buat proyek baru atau buka proyek yang sudah ada.

### 2. Instalasi Java Development Kit (JDK)
1. Unduh dan instal **JDK 23** dari tautan yang telah disediakan.
2. Pastikan Anda mengonfigurasi JDK dengan benar di NetBeans IDE.

### 3. Instalasi XAMPP dan MySQL
1. Unduh dan instal XAMPP.
2. Setelah instalasi, buka XAMPP Control Panel dan jalankan **Apache** dan **MySQL**.
3. Buat database baru di phpMyAdmin (akses melalui `http://localhost/phpmyadmin`).

### 4. Konfigurasi MySQL Connector/J di NetBeans
1. Setelah mengunduh **MySQL Connector/J** versi 9.1.0, ekstrak file yang diunduh.
2. Di NetBeans, buka proyek Anda, kemudian klik kanan pada **Libraries** > **Add JAR/Folder**.
3. Arahkan ke file `mysql-connector-java-9.1.0.jar` dan tambahkan ke dalam proyek.

### 5. Koneksi ke Database MySQL
Pastikan aplikasi Anda sudah mengonfigurasi string koneksi dengan benar. Berikut adalah contoh koneksi dasar:

```java
String url = "jdbc:mysql://localhost:3306/nama_database";
String user = "root";
String password = "";

Connection conn = DriverManager.getConnection(url, user, password);
```


## Menjalankan Aplikasi
1. Pastikan **XAMPP** sedang berjalan dengan **Apache** dan **MySQL** aktif.
2. Jalankan aplikasi dari **NetBeans** dengan memilih proyek dan klik tombol **Run**.

## Troubleshooting
- **Error Koneksi Database**: Pastikan **MySQL server** di XAMPP sedang berjalan dan string koneksi Anda sudah benar.
- **Library Tidak Ditemukan**: Pastikan bahwa Anda sudah menambahkan `mysql-connector-java-9.1.0.jar` ke dalam libraries proyek di NetBeans.


# Struktur Proyek CRUD_App

Berikut adalah penjelasan mengenai struktur file dalam proyek `CRUD_App` Anda:

## [DIR] CRUD_App/

    - **[FILE] build.xml**: 
    - **[FILE] manifest.mf**: 
    - **[FILE] README.md**: 

### [DIR] nbproject/
    - **[FILE] build-impl.xml**: 
    - **[FILE] genfiles.properties**: 
    - **[FILE] project.properties**: 
    - **[FILE] project.xml**: 
    
    #### [DIR] private/
        - **[FILE] private.properties**: 

### [DIR] src/
    - **[DIR] com/: Berisi seluruh kode sumber dan aset untuk aplikasi.
    
    #### [DIR] image/
        - **[FILE] login (2).png**: Gambar yang digunakan dalam tampilan form login.
        
    #### [DIR] login/
        - **[FILE] icon.png**: Favicon yang digunakan di antarmuka pengguna GUI.
        - **[FILE] LoginFrame.form**: Desain antarmuka grafis (GUI) untuk tampilan login.
        - **[FILE] LoginFrame.java**: Kode untuk mengimplementasikan fungsionalitas tampilan login.
        - **[FILE] SignupFrame.form**: Desain antarmuka grafis (GUI) untuk tampilan signup.
        - **[FILE] SignupFrame.java**: Kode untuk mengimplementasikan fungsionalitas tampilan signup.

    #### [DIR] config/
        - **[FILE] DB_connection.java**: Kode yang menangani koneksi ke database.

    #### [DIR] crud_app/
        - **[FILE] CRUD_App.java**: Kode utama aplikasi yang berfungsi untuk menjalankan aplikasi CRUD.

    #### [DIR] dashboard/
        - **[FILE] HomeJFrame.form**: Desain antarmuka grafis (GUI) untuk tampilan beranda (home).
        - **[FILE] HomeJFrame.java**: Kode yang menangani logika fungsionalitas tampilan beranda (home).
