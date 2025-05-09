package com.uts;

public abstract class Kendaraan implements TransportasiUmum {
  private String jenis;
  private int kapasitas;

  public Kendaraan(String jenis) {
    this.jenis = jenis;
  }

  public String getJenis() {
    return jenis;
  }

  public int getKapasitas() {
    return kapasitas;
  }

  public void setKapasitas(int kapasitas) {
    this.kapasitas = kapasitas;
  }

  @Override
  public String getInfo() {
    return "Jenis: " + jenis + ", Kapasitas: " + kapasitas;
  }

  @Override
  public abstract double hitungBiaya(double jarak);
}
