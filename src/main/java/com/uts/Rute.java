package com.uts;

public class Rute {
  private int id;
  private String asal;
  private String tujuan;
  private double jarak;

  public Rute(int id, String asal, String tujuan, double jarak) {
    this.id = id;
    this.asal = asal;
    this.tujuan = tujuan;
    this.jarak = jarak;
  }

  public int getId() { return id; }
  public String getAsal() { return asal; }
  public String getTujuan() { return tujuan; }
  public double getJarak() { return jarak; }

  @Override
  public String toString() {
    return asal + " -> " + tujuan + " (" + jarak + " km)";
  }
}
