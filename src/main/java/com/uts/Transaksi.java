package com.uts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaksi {
  private int id;
  private Kendaraan kendaraan;
  private Rute rute;
  private double total;

  public Transaksi(Kendaraan kendaraan, Rute rute) {
    this.kendaraan = kendaraan;
    this.rute = rute;
    this.total = kendaraan.hitungBiaya(rute.getJarak());
  }

  public void simpanKeDatabase() {
    String sql = "INSERT INTO transaksi (kendaraan_id, rute_id, total) VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnector.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

      pstmt.setInt(1, getKendaraanIdFromDatabase());
      pstmt.setInt(2, rute.getId());
      pstmt.setDouble(3, total);

      pstmt.executeUpdate();

      try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          this.id = generatedKeys.getInt(1);
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private int getKendaraanIdFromDatabase() throws SQLException {
    String sql = "SELECT id FROM kendaraan WHERE jenis = ?";

    try (Connection conn = DatabaseConnector.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql)) {

      pstmt.setString(1, kendaraan.getJenis());
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        return rs.getInt("id");
      } else {
        // Jika kendaraan belum ada di database, insert baru
        return insertKendaraanKeDatabase();
      }
    }
  }

  private int insertKendaraanKeDatabase() throws SQLException {
    String sql = "INSERT INTO kendaraan (jenis, kapasitas) VALUES (?, ?)";

    try (Connection conn = DatabaseConnector.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

      pstmt.setString(1, kendaraan.getJenis());
      pstmt.setInt(2, kendaraan.getKapasitas());
      pstmt.executeUpdate();

      try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          return generatedKeys.getInt(1);
        }
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    return "Transaksi #" + id + 
    "\nKendaraan: " + kendaraan.getInfo() +
    "\nRute: " + rute +
    "\nTotal Biaya: Rp" + String.format("%,.2f", total);
  }
}
