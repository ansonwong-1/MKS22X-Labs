import java.util.*;
import java.io.*;
public class QueenBoard{
  private int[][]board;
  private boolean animated;
  private int delay;
  public static void main (String[] args){
    QueenBoard boa = new QueenBoard(2);
    System.out.println(boa.countSolutions());
    QueenBoard aboa = new QueenBoard(4);
    System.out.println(aboa.countSolutions());
    QueenBoard asboa = new QueenBoard(6);
    System.out.println(asboa.countSolutions());
  }
  public QueenBoard(int size){
    board = new int[size][size];
    for(int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }animated = false;
    delay = 1000;
  }
  public void setAnimate(boolean newValue){
    animated = newValue;
  }

  public void setDelay(int newValue){
    if(newValue < 0){
      newValue = 0;
    }delay = newValue;
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        // ans += board[i][j] + "  ";
        if (board[i][j] == -1){
          ans += "Q ";
        }else{
          ans += "_ ";
        }
      }ans += '\n';
    }return ans;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }else{
      board[r][c] = -1;
      for(int i = r + 1; i < board.length; i++){
        board[i][c]++;
      }
      for(int i = r + 1; i < board.length && c + i - r < board.length; i++){
        board[i][c + i - r]++;
      }
      for(int i = r + 1; i < board.length && c - i + r >= 0; i++){
        board[i][c - i + r]++;
      }
    }return true;
  }


  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  private void removeQueen(int r, int c){
    board[r][c]++;
    for(int i = r + 1; i < board.length; i++){
      board[i][c]--;
    }
    for(int i = r + 1; i < board.length && c + i - r < board.length; i++){
      board[i][c + i - r]--;
    }
    for(int i = r + 1; i < board.length && c - i + r >= 0; i++){
      board[i][c - i + r]--;
    }
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  //solve & countSolutions are wrappers
  public boolean solve(){
    return solve(0);
  }
  public boolean solve(int row) throws IllegalStateException{
    if (row == 0){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board.length; j++){
          if (board[i][j] != 0){
            throw new IllegalStateException("board is not cleared");
          }
        }
      }
    }
    if(row == board.length){
      System.out.println(board.toString());
      return true;
    }
    else{
      for(int col = 0; col < board.length; col++){
        if(addQueen(row, col)){
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
          if(solve(row + 1)){
            return true;
          }removeQueen(row, col);
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
        }
      }
    }return false;
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions(){
    return countSolutions(0);
  }
  public int countSolutions(int row)throws IllegalStateException{
    if (row == 0){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board.length; j++){
          if (board[i][j] != 0){
            throw new IllegalStateException("board is not cleared");
          }
        }
      }
    }
    int count = 0;
    if(row == board.length){
      return 1;
    }else{
      for(int col = 0; col < board.length; col++){
        if(addQueen(row, col)){
          count += countSolutions(row + 1);
          removeQueen(row, col);
          }
        }
      }return count;
    }
}
