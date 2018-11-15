package edu.cnm.deepdive.rps.model;

import java.util.Comparator;

public enum RPSBreed {


  Rock,
  Paper,
  SISSORS;

  private static final int [][] DOMINANCE = {
      //ROCK, PAPER, SISSORS

      { 0, -1, 1}, //ROCK
      { 1, 0, -1}, //PAPER
      {-1, 1,  0}  //SISSORS
  };

  private static final Comparator<RPSBreed> REFEREE = new Comparator<RPSBreed>() {
    @Override
    public int compare(RPSBreed rps1, RPSBreed rps2) {
      return DOMINANCE[rps1.ordinal()][rps2.ordinal()];
    }
  };
}
