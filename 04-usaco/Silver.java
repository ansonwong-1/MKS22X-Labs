import java.io.*;
import java.util.*;
public class Silver{
  public static long solve(String filename){
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int n = in.nextInt();
      int m = in.nextInt();
      int t = in.nextInt();
      int s = 0;
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
      return s;
    }catch(FileNotFoundException e){
      return -1;
    }
  }

}
