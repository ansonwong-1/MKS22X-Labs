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
    // boolean safeToCarve = fewer than two open neighbors
  }

// Postconditions:
// The array '#' will be carved into ' ' forming a maze
// The array[startrow][startcol] is replaced with an 'S',
// The array has an 'E' placed in one of the carved out spots, preferably not too adjacent to the 'S'
}
