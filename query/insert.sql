-- Data untuk Bus
INSERT INTO kendaraan (jenis, kapasitas) VALUES 
('Bus Sekolah', 30),
('Bus Pariwisata', 45),
('Bus Kota', 50),
('Bus Antar Kota', 60),
('Bus Double Decker', 80);

-- Data untuk Mobil
INSERT INTO kendaraan (jenis, kapasitas) VALUES 
('Mobil Sedan', 4),
('Mobil SUV', 7),
('Mobil MPV', 8),
('Mobil Pickup', 2),
('Mobil Sport', 2), 
('Mobil City Car', 4),
('Mobil Station Wagon', 5),
('Mobil Off-road', 5);

-- Contoh data rute
INSERT INTO rute (asal, tujuan, jarak) VALUES
('Jakarta', 'Bandung', 150.5),
('Surabaya', 'Malang', 90.0),
('Medan', 'Binjai', 25.3),
('Yogyakarta', 'Solo', 65.7),
('Denpasar', 'Singaraja', 85.2);

-- Contoh data transaksi
INSERT INTO transaksi (kendaraan_id, rute_id, total) VALUES
(1, 1, 2500000),  -- Bus Sekolah Jakarta-Bandung
(3, 2, 1800000),  -- Bus Kota Surabaya-Malang
(6, 3, 450000),   -- Mobil Sedan Medan-Binjai
(8, 4, 750000),   -- Mobil MPV Yogyakarta-Solo
(2, 5, 3000000);  -- Bus Pariwisata Denpasar-Singaraja
