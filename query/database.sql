DROP DATABASE sistem_transportasi;
CREATE DATABASE sistem_transportasi;
USE sistem_transportasi;

CREATE TABLE kendaraan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jenis VARCHAR(50) NOT NULL,
    kapasitas INT NOT NULL
);

CREATE TABLE rute (
    id INT AUTO_INCREMENT PRIMARY KEY,
    asal VARCHAR(100) NOT NULL,
    tujuan VARCHAR(100) NOT NULL,
    jarak DECIMAL(10,2) NOT NULL
);

CREATE TABLE transaksi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kendaraan_id INT NOT NULL,
    rute_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (kendaraan_id) REFERENCES kendaraan(id),
    FOREIGN KEY (rute_id) REFERENCES rute(id)
);
