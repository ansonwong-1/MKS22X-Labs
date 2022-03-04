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
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Random rng = new Random();
    // int[] direction = directions[rng.nextInt(4)];
    boolean safeToCarve = true;
    if (startrow > maze.length - 1 || startrow <= 0
    || startcol > maze.length - 1 || startcol <= 0){
      safeToCarve = false;
    }else if (maze[startrow][startcol] == ' '){
      safeToCarve = false;
    }else{
      int neighbors = 0;
      for(int j = 0; j < directions.length; j++){
        int r = startrow + directions[j][0];
        int c = startcol + directions[j][1];
        if (r > 0 && c > 0 && r < maze.length - 1 && c < maze[r].length - 1){
          if (maze[r][c] == ' '){
            neighbors++;
          }
        }
      }if (neighbors > 2){
        safeToCarve = false;
      }
    }
    if (safeToCarve){
      for (int i = 0; i < directions.length; i++){
        maze[startrow][startcol] = ' ';
        int[] direction = directions[rng.nextInt(4)];
        generate(maze, startrow + direction[0], startcol + direction[1]);
      }
    }
  }
// Postconditions:
// The array '#' will be carved into ' ' forming a maze
// The array[startrow][startcol] is replaced with an 'S',
// The array has an 'E' placed in one of the carved out spots, preferably not too adjacent to the 'S'
}
