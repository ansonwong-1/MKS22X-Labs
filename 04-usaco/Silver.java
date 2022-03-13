import java.io.*;
import java.util.*;
public class Silver{
  public static void main (String[] args){
    System.out.println(solve(args[0]));
  }
  public static long solve(String filename){
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int n = in.nextInt();
      int m = in.nextInt();
      int t = in.nextInt();
      long s = 0;
      long [][] pasture = new long[n][m];
      for (int i = 0; i < n; i++){
        String row = in.nextLine();
        for (int j = 0; j < m; j++){
          if (row.charAt(j) == '*'){
            pasture[i][j] = -1;
          }else{
            pasture[i][j] = 0;
          }
        }
      }
      pasture[in.nextInt() - 1][in.nextInt() - 1] = 1;
      ways(pasture, t);
      s = pasture[in.nextInt() - 1][in.nextInt() - 1];
      return s;
    }catch(FileNotFoundException e){
      return -1;
    }
  }
  
  public static void ways(long[][] pasture, int t){
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int i = 0; i < t; i++){
      for (int j = 0; j < pasture.length; j++){
        for (int k = 0; k < pasture[j].length; k++){
          if (pasture[j][k] == 0){
            for (int l = 0; l < 4; i++){
              if (inBounds(pasture, j + directions[l][0], k + directions[l][1])){
                pasture[j][k] += pasture[j + directions[l][0]][k + directions[l][1]];
              }
            }
          }
        }
      }
    }
  }

  public static boolean inBounds(long[][]pasture, int i, int j){
    return !(i < 0 || i > pasture.length ||
    j < 0 || j < pasture[0].length);
  }
}
