package com.uts;

public class Mobil extends Kendaraan {
  private static final double TARIF_DASAR = 5000;
  private static final double TARIF_PER_KM = 2500;

  public Mobil(String jenis) {
    super(jenis);
  }

  @Override
  public double hitungBiaya(double jarak) {
    return TARIF_DASAR + (jarak * TARIF_PER_KM);
  }
}
