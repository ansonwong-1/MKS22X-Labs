import java.io.*;
import java.util.*;
public class MazeGenerator{
//  Basic Method: public static void generate(char[][]maze, int startrow, int startcol) given a 2D rectangular array pre-filled with walls '#' in all rows/cols. Try to remove the maze[startrow][startcol] if possible, and continue to do this recursively as described above and in class. This method will modify the array and not return anything.
// Preconditions:
// The maze array is rectangular.
// The dimensions of the maze array will be greater than 3x3, e.g. 3x4 or 4x3 would be the smallest valid array.
// The maze array is pre-populated completely with '#'
// The startrow and startcol will be a valid index and will not in the first or last row/col


  public static void generate(char[][]maze, int startrow, int startcol){
    clearTerminal();
    generateHelper(maze, startrow, startcol);
    addSE(maze, startrow - 1, startcol - 1);
  }
  public static void clearTerminal(){
     //erase terminal
     System.out.println("\033[2J");
   }
  public static void addSE(char[][]maze, int startrow, int startcol){
    maze[startrow][startcol] = 'S';
    Random rr = new Random();
    Random cr = new Random();
    int r = rr.nextInt(maze.length - 2) + 1;
    int c = cr.nextInt(maze[r].length - 2) + 1;
    while (maze[r][c] != ' '){
      r = rr.nextInt(maze.length);
      c = cr.nextInt(maze[r].length);
    }
    maze[r][c] = 'E';
  }
  public static String toString(char[][] maze){
    String ans = "";
    for (int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[i].length; j++){
        ans += maze[i][j];
      }ans += '\n';
    }return ans;
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }
  private static void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }
  public static void generateHelper(char[][]maze, int startrow, int startcol){
      ArrayList<int[]> direction = new ArrayList<int[]>();
      direction.add(new int[]{0, 1});
      direction.add(new int[]{0, -1});
      direction.add(new int[]{1, 0});
      direction.add(new int[]{-1, 0});
      Collections.shuffle(direction);
      for(int i = 0; i < direction.size(); i++){
        if(openNeighbors(maze, startrow + direction.get(i)[0], startcol + direction.get(i)[1])){
            maze[startrow + direction.get(i)[0]][startcol + direction.get(i)[1]] = ' ';
            gotoTop();
            System.out.println(toString(maze));
            wait(50);
            generateHelper(maze, startrow + direction.get(i)[0], startcol + direction.get(i)[1]);
        }
      }
    }

    public static boolean openNeighbors(char[][]maze, int ro, int co){
      int neighbors = 0;
      //out of bounds check
      if (ro <= 0 || co <= 0 || ro >= maze.length - 1 || co >= maze[ro].length - 1 || maze[ro][co] != '#'){
        return false;
      }
      int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      for (int i = 0; i < 4; i++){
        int r = ro + directions[i][0];
        int c = co + directions[i][1];
        if (r > 0 && c > 0 && r < maze.length - 1 && c < maze[r].length - 1){
          if(maze[r][c] == ' '){
            neighbors++;
          }
        }
      }
      return neighbors < 2;
    }




}
