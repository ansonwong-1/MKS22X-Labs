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
    int[] direction = directions[rng.nextInt(4)];
    boolean safeToCarve = false;
    for (int i = 0 ; i < directions.length; i++){
      int r = startrow + directions[i][0];
      int c = startcol + directions[i][1];
      if (r > 0 && c > 0 && r < maze.length - 1 && c < maze[r].length - 1)
      {int neighbors = 0;
      if(maze[startrow][startcol] == '#'){
        for(int j = 0; j < directions.length; j++){
          int rj = startrow + directions[j][0];
          int cj = startcol + directions[j][1];
          if (rj > 0 && cj > 0 && rj < maze.length - 1 && cj < maze[r].length - 1){
            if (maze[r][c] == ' '){
              neighbors++;
            }
          }
        }if (neighbors < 2){
          safeToCarve = true;
        }
      }if (safeToCarve){
        maze[startrow + direction[0]][startcol + direction[1]] = ' ';
      }}
    }
    // int count1;
    // if (maze[row][col] == 'E'){
    //   return count;
    // }else if (maze[row][col] != ' ' && maze[row][col] != 'S'){
    //     return -1;
    // }
    //     int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //     for(int i = 0; i < directions.length; i++){
    //       maze[row][col] = '@';
    //       count1 = solve(row + directions[i][0], col + directions[i][1], count + 1);
    //       if(count1 > - 1){
    //         return count1;
    //       }else{
    //         maze[row][col] = '.';
    //       }
    //     }return -1;
    //   }
    // generate(maze, startrow + direction[0], startcol + direction[1]);
    // boolean safeToCarve = fewer than two open neighbors
  }

// Postconditions:
// The array '#' will be carved into ' ' forming a maze
// The array[startrow][startcol] is replaced with an 'S',
// The array has an 'E' placed in one of the carved out spots, preferably not too adjacent to the 'S'
}
