
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Specialist extends Piece {
  //Initilizes the Specialist
  public Specialist(boolean isWhite, String imageFile) {
    super(isWhite, imageFile);
  }

  //Overides toString to implement Specialist
  public String toString() {
    return "A " + super.toString() + " Specialist";
  }
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    
    //Pre condition: board and start are input, start can't be null
    //Post condition: Controlled Squares checks every sqaure around the piece selected to check if its possible to make a move 
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> controlled = new ArrayList<Square>(); 
      int r = start.getRow();
      int c = start.getCol();
      if (r - 1 > -1 && c - 1 > -1) {
        controlled.add(board[r - 1][c - 1]);
      }
      if (r - 1 > -1 && c + 1 < 8) {
        controlled.add(board[r - 1][c + 1]);
      }
      if (r + 1 < 8 && c - 1 < -1) {
        controlled.add(board[r + 1][c - 1]);
      }
      if (r + 1 < 8 && c + 1 < 8) {
        controlled.add(board[r + 1][c + 1]);
      }
      return controlled;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    

    //Name: Carlos Silva 
    //Name of Piece: The Specialist
    //The Specialist is a piece that acts like an advanced pawn
    //The Specialist is allowed to move one unit forward, backwards, left or right
    //The Spcialist is allowed to attack one unit to any of its four corners
    
    //Pre Condition: b and start and start cant be null
    //Post Condition: Legal Moves uses checkSquare and Occupying piece to show the moves that are legal for the player to make 
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      Square[][] board = b.getSquareArray(); 
    	ArrayList<Square> legal = new ArrayList<Square>();
      int r = start.getRow();
      int c = start.getCol();

      Square checkSquare;

      if (r - 1 > -1 && c - 1 > -1) {
        checkSquare = board[r - 1][c - 1];
        if (checkSquare.isOccupied()) {
          if (checkSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
            legal.add(checkSquare);
          }
        }
      }
      if (r - 1 > -1 && c + 1 < 8) {
        checkSquare = (board[r - 1][c + 1]);
        if (checkSquare.isOccupied()) {
          if (checkSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
            legal.add(checkSquare);
          }
        }
      }
      if (r + 1 < 8 && c - 1 > -1) {
        checkSquare = (board[r + 1][c - 1]);
        if (checkSquare.isOccupied()) {
          if (checkSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
            legal.add(checkSquare);
          }
        }
      }
      if (r + 1 < 8 && c + 1 < 8) {
        checkSquare = (board[r + 1][c + 1]);
        if (checkSquare.isOccupied()) {
          if (checkSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()) {
            legal.add(checkSquare);
          }
        }
      }

      if (r + 1 < 8) {
        checkSquare = (board[r + 1][c]);
        if (!checkSquare.isOccupied()) {
          legal.add(checkSquare);
        }
      }
      if (r - 1 > -1) {
        checkSquare = (board[r - 1][c]);
        if (!checkSquare.isOccupied()) {
          legal.add(checkSquare);
        }
      }if (c + 1 < 8) {
        checkSquare = (board[r][c + 1]);
        if (!checkSquare.isOccupied()) {
          legal.add(checkSquare);
        }
      }if (c - 1 > -1) {
        checkSquare = (board[r][c - 1]);
        if (!checkSquare.isOccupied()) {
          legal.add(checkSquare);
        }
      }

      return legal;
    }
}