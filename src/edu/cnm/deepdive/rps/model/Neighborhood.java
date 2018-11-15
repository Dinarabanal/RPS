package edu.cnm.deepdive.rps.model;

import java.util.Random;

public interface Neighborhood { //interface access modifier is public

  Location[] neighbors();

  default Location randomNeighbor(Random rng) {

    Location[] neighbors = this.neighbors();
    return neighbors[rng.nextInt(neighbors.length)];
  }

}
