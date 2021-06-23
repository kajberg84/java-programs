package assignment1.programs;

import java.util.Random;

public class Ants {

  public static boolean hasWalkedAllTiles(Boolean array[][]){
    Boolean walkedTiles = true;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] == false) {
          walkedTiles = false;
        }
      } 
    }
    return walkedTiles;
  }

  public static int[] walkingAnt(int position[], int boardsize) {
    int positionX = position[0];
    int positionY = position[1];
    Random rndStep = new Random();
    int boardDirection;
    Boolean allowedToStep = false;

    // 0 = North, 1 = East, 2 = South, 3 = West.
    while (allowedToStep == false) {
      boardDirection = rndStep.nextInt(4);
      if (boardDirection == 0) {
        if (positionY < boardsize-1) {
          positionY += 1;
          allowedToStep = true;
        }
      } else if (boardDirection == 1) {
        if (positionX < boardsize-1) {
          positionX += 1;
          allowedToStep = true;
        }
      } else if (boardDirection == 2) {
        if (positionY > 0) {
          positionY -= 1;
          allowedToStep = true;
        }
      } else if (boardDirection == 3) {
        if (positionX > 0) {
          positionX -= 1;
          allowedToStep = true;
        }
      }
    }
    position[0] = positionX;
    position[1] = positionY;
    return position;
  }

  public static void main(String[] args) {
    Random rnd = new Random();
    int chessBoardSize = 8;
    Boolean[][] chessBoard = new Boolean[chessBoardSize][chessBoardSize];
    Boolean checkStep;
    int antPosition[] = new int[2];
    int numberOfSteps;
    int numberOfSimulations = 10;
    Double sumOfSteps = 0.0;

    System.out.println("Ants");
    System.out.println("====");
    System.out.println();

  for(int k = 0; k < numberOfSimulations; k++){
    numberOfSteps = 0;
    antPosition[0] = rnd.nextInt(chessBoardSize);
    antPosition[1] = rnd.nextInt(chessBoardSize); 
    checkStep = false;

    for (int i = 0; i < chessBoard.length; i++) {
      for (int j = 0; j < chessBoard[i].length; j++) {
        chessBoard[i][j] = false;
      }
    }

    chessBoard[antPosition[0]][antPosition[1]] = true;

    // One simulation.
    while (checkStep == false) {
      antPosition = walkingAnt(antPosition, chessBoardSize);
      chessBoard[antPosition[0]][antPosition[1]] = true;
      checkStep = hasWalkedAllTiles(chessBoard);
      numberOfSteps++;
    }
    sumOfSteps += numberOfSteps;
    System.out.println("Number of steps in simulation " + (k + 1) + ": " + numberOfSteps);
  }

  System.out.println("Average amount of steps: " + sumOfSteps/numberOfSimulations);
  }
}
