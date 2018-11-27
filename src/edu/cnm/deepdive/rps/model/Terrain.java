package edu.cnm.deepdive.rps.model;

import java.util.Random;

public class Terrain {

  //grid is assumed to be square.
  private RPSBreed[][] grid;
  private Random rng;
  private Neighborhood neighborhood;
  private long iterations;



  public Terrain(int size, Random rng, Neighborhood neighborhood) {
    grid = new RPSBreed[size][size];
    this.rng = rng;
    this.neighborhood = neighborhood;
  }

  public void reset(){
    for (RPSBreed[] row : grid) {
      for (int col = 0; col < row.length; col++) {
        row[col] = RPSBreed.values()[rng.nextInt(RPSBreed.values().length)];
      }
    }


//    for (int row = 0; row<grid.length; row++){
//      RPSBreed[] rowContents = grid[row];
//      for (int col = 0; col < rowContents.length; col++) {
//        rowContents[col] = RPSBreed.values()[rng.nextInt (RPSBreed.values().length)];
//      }
//    }
    iterations = 0;
  }
  public void step() {
    Location attackerLocation = new Location(rng.nextInt(grid.length),
        rng.nextInt(grid.length));
    RPSBreed attacker = grid[attackerLocation.getRow()][attackerLocation.getColumn()];
    Location offset = neighborhood.randomNeighbor(rng);
    Location defenderLocation = normalize(attackerLocation, offset);
    RPSBreed defender = grid[defenderLocation.getRow()][defenderLocation.getColumn()];
    int result = RPSBreed.REFEREE.compare(attacker, defender);
    if (result < 0) {
      grid[attackerLocation.getRow()][attackerLocation.getColumn()] = defender;

    } else if (result > 0) {
      grid[defenderLocation.getRow()][defenderLocation.getColumn()] = attacker;
    }
    iterations++;
  }

  public void step(int numSteps) {
    for (int i = 0; i < numSteps; i++){
      step();
    }
  }
  /**
   * Returns a reference to the terrain contents. <strong>Important</strong>
   *THis is <strong> not</strong> a safe copy.
   *
   * @return
   */
  public RPSBreed[][] getGrid() {
    return grid;
  }

  private Location normalize(Location base, Location offset) {
    int row = (base.getRow() + offset.getRow() + grid.length) % grid.length;
    int col = (base.getColumn() + offset.getColumn() + grid.length) % grid.length;
    return new Location(row, col);

  }

  public long getIterations() {
    return iterations;
  }
}
