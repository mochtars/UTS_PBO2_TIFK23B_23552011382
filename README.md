# UTS Pemrograman Berorientasi Objek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Objek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Beni Mochtar Samiraharja</li>
  <li>NIM: 23552011382</li>
  <li>Studi Kasus: Kasir Transportasi</li>
</ul>

## Judul Studi Kasus
<p>
    Sistem Kasir Transportasi Umum.
</p>

## Penjelasan Studi Kasus
<p>
    Sistem kasir transportasi umum untuk menghitung biaya perjalanan berdasarkan rute.
    Ketika membuat transaksi baru pada pilihan menu, program akan menamplikan berbagai kendaraan yang tersedia.
    Lalu input berapa banyak jumlah penumpang yang akan menaiki mobil.
    Jika penumpang melebihi kapasitas kendaraan yang pilih, maka akan memberikan pesan gagal.
    Langkah selanjutnya memilih rute mana yang akan dipilih.
</p>
<p>
    Sebagai contoh:
    <ul>
        <li>Kendaraan: Bus Sekolah</li>
        <li>Tarif dasar: 10000</li>
        <li>Tarif per km: 3500</li>
        <li>Rute: Jakarta -> Bandung (150.5km),</li>
    </ul>
</p>
<p>Total: Tarif dasar + (jarak * tarif per km)</p>
<p>Lalu data transaksi seperti (kendaraan_id, rute_id, total) dimasukan kedalam tabel <code>transaksi</code> di dalam database.</p>
<br>
<p>
    Program ini berbasis Java yang terintegrasi dengan database MySQL untuk menghitung biaya perjalanan berdasarkan rute dan jenis kendaraan,
    menerapkan empat pilar OOP (Object-Oriented Programming):
</p>
<ul>
    <li>Inheritance melalui hierarki class Kendaraan-Mobil-Bus</li>
    <li>Polymorphism dengan implementasi method hitungBiaya() yang berbeda di setiap subclass</li>
    <li>Encapsulation dengan penyembunyian data atribut kendaraan dan pembatasan akses melalui method</li>
    <li>Interface melalui TransportasiUmum yang menjadi kontrak untuk class Kendaraan, dengan fitur utama meliputi manajemen data kendaraan dan rute, sistem transaksi multi-penumpang dengan validasi kapasitas, serta penyimpanan data transaksi ke database secara otomatis</li>
</ul>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<ul>
  <li>Kendaraan sebagai superclass/parent class.</li>
  <li>Mobil dan Bus sebagai subclass/child class yang mewarisi dari Kendaraan.</li>
  <li>Subclass mendapatkan semua atribut dan method dari superclass.</li>
  <li>Subclass dapat menambahkan atau mengoverride method dari superclass.</li>
</ul>

```java
// Superclass
public abstract class Kendaraan implements TransportasiUmum {
    // atribut dan method umum
}

// Subclass Mobil
public class Mobil extends Kendaraan {
    // implementasi Mobil
}

// Subclass Bus
public class Bus extends Kendaraan {
    // implementasi Bus
}
```

### 2. Polymorphism
<ul>
  <li>Method hitungBiaya() di-deklarasikan di superclass Kendaraan sebagai abstract method</li>
  <li>Masing-masing subclass mengimplementasikan method ini dengan cara berbeda</li>
  <li>Saat method dipanggil menggunakan referensi superclass, program akan menjalankan implementasi yang sesuai dengan tipe objek sebenarnya.</li>
</ul>

```java
// Dalam class Kendaraan (superclass)
public abstract double hitungBiaya(double jarak);

// Dalam class Mobil
@Override
public double hitungBiaya(double jarak) {
    return TARIF_DASAR + (jarak * TARIF_PER_KM);
}

// Dalam class Bus
@Override
public double hitungBiaya(double jarak) {
    return TARIF_DASAR + (jarak * TARIF_PER_KM);
}


Kendaraan kendaraan1 = new Mobil("Mobil Sedan");
Kendaraan kendaraan2 = new Bus("Bus Pariwisata");

double biaya1 = kendaraan1.hitungBiaya(100); // Contoh implementasi Mobil
double biaya2 = kendaraan2.hitungBiaya(100); // Contoh implementasi Bus

```

### 3. Encapsulation
<ul>
  <li>Atribut jenis dan kapasitas diatur sebagai private untuk mencegah akses langsung dari luar.</li>
  <li>Akses ke atribut hanya melalui public getter dan setter methods.</li>
  <li>Memungkinkan validasi atau logika tambahan ketika mengakses/mengubah nilai atribut.</li>
  <li>Melindungi integritas data objek</li>
</ul>

```java
public abstract class Kendaraan implements TransportasiUmum {
    private String jenis;
    private int kapasitas;

    public Kendaraan(String jenis) {
        this.jenis = jenis;
    }

    // Getter methods
    public String getJenis() {
        return jenis;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    // Setter method
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
}
```

### 4. Interface
<ul>
  <li>TransportasiUmum sebagai interface yang mendefinisikan kontrak.</li>
  <li>Class Kendaraan mengimplementasikan interface tersebut.</li>
  <li>Harus menyediakan implementasi untuk semua method yang dideklarasikan di interface.</li>
  <li>Memungkinkan polymorphism melalui interface.</li>
</ul>

```java
// Interface
public interface TransportasiUmum {
    double hitungBiaya(double jarak);
    String getInfo();
}

// Class yang mengimplementasikan interface
public abstract class Kendaraan implements TransportasiUmum {
    // harus mengimplementasikan semua method dari interface
    @Override
    public abstract double hitungBiaya(double jarak);
    
    @Override
    public String getInfo() {
        return "Jenis: " + jenis + ", Kapasitas: " + kapasitas;
    }
}
```

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
