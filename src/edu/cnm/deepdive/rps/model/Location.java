package edu.cnm.deepdive.rps.model;

public class Location {

  private final int row; //if its final, this mudt be assigned durin instintence initaliiation
  private final int column;


  public Location(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

}