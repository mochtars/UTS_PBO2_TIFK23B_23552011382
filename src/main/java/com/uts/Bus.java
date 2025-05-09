package com.uts;

public class Bus extends Kendaraan {
  private static final double TARIF_DASAR = 10000;
  private static final double TARIF_PER_KM = 3500;

  public Bus(String jenis) {
    super(jenis);
  }

  @Override
  public double hitungBiaya(double jarak) {
    return TARIF_DASAR + (jarak * TARIF_PER_KM);
  }
}
