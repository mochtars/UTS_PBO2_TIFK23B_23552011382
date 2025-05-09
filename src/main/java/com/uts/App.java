package com.uts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nSISTEM KASIR TRANSPORTASI UMUM");
      System.out.println("==============================");
      System.out.println("1. Buat Transaksi Baru");
      System.out.println("2. Keluar");
      System.out.print("Pilihan: ");
      int menu = scanner.nextInt();

      if (menu == 2) {
        System.out.println("Terima kasih, program selesai.");
        break;
      } else if (menu != 1) {
        System.out.println("Pilihan tidak valid!");
        continue;
      }

      // Pilih kendaraan
      System.out.println("\nPilih jenis kendaraan:");
      List<Kendaraan> daftarKendaraan = getDaftarKendaraan();

      for (int i = 0; i < daftarKendaraan.size(); i++) {
        Kendaraan k = daftarKendaraan.get(i);
        System.out.println((i+1) + ". " + k.getJenis() + 
          " (Kapasitas: " + k.getKapasitas() + " orang)");
      }

      System.out.print("Pilihan: ");
      int pilihanKendaraan = scanner.nextInt();
      Kendaraan kendaraan = daftarKendaraan.get(pilihanKendaraan - 1);

      // Input jumlah penumpang
      System.out.print("\nMasukkan jumlah penumpang: ");
      int jumlahPenumpang = scanner.nextInt();

      // Validasi kapasitas
      if (jumlahPenumpang > kendaraan.getKapasitas()) {
        System.out.println("\nGAGAL: Jumlah penumpang melebihi kapasitas kendaraan!");
        System.out.println("Kapasitas " + kendaraan.getJenis() + ": " + kendaraan.getKapasitas());
        continue;
      }

      // Tampilkan daftar rute
      List<Rute> daftarRute = getDaftarRute();
      System.out.println("\nDaftar Rute:");
      for (int i = 0; i < daftarRute.size(); i++) {
        System.out.println((i+1) + ". " + daftarRute.get(i));
      }

      System.out.print("Pilih rute (nomor): ");
      int pilihanRute = scanner.nextInt() - 1;
      Rute rute = daftarRute.get(pilihanRute);

      // Buat transaksi untuk setiap penumpang
      for (int i = 1; i <= jumlahPenumpang; i++) {
        System.out.println("\nMembuat transaksi untuk penumpang #" + i);
        Transaksi transaksi = new Transaksi(kendaraan, rute);
        transaksi.simpanKeDatabase();

        System.out.println("\nTRANSAKSI BERHASIL:");
        System.out.println(transaksi);
      }
    }
    scanner.close();
  }

  private static List<Kendaraan> getDaftarKendaraan() {
    List<Kendaraan> kendaraanList = new ArrayList<>();
    String sql = "SELECT * FROM kendaraan";

    try (Connection conn = DatabaseConnector.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        Kendaraan kendaraan;
        String jenis = rs.getString("jenis");
        int kapasitas = rs.getInt("kapasitas");

        if (jenis.toLowerCase().contains("bus")) {
          kendaraan = new Bus(jenis);
        } else {
          kendaraan = new Mobil(jenis);
        }

        kendaraan.setKapasitas(kapasitas);
        kendaraanList.add(kendaraan);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return kendaraanList;
  }

  private static List<Rute> getDaftarRute() {
    List<Rute> ruteList = new ArrayList<>();
    String sql = "SELECT * FROM rute";

    try (Connection conn = DatabaseConnector.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        Rute rute = new Rute(
          rs.getInt("id"),
          rs.getString("asal"),
          rs.getString("tujuan"),
          rs.getDouble("jarak")
        );
        ruteList.add(rute);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return ruteList;
  }
}
