import java.util.*;
import java.io.*;
public class Bronze{
  public static void main(String[] args){
    System.out.println(solve(args[0]));
  }
  public static long solve(String filename){
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int r = in.nextInt();
      int c = in.nextInt();
      int[][] pasture = new int[r][c];
      int e = in.nextInt();
      int n = in.nextInt();
      int d = 0;
      for (int i = 0; i < pasture.length; i++){
        for (int j = 0; j < pasture[i].length; j++){
          pasture[i][j] = in.nextInt();
        }
      }
      for(int i = 0; i < n; i++){
        stomp(pasture, in.nextInt(), in.nextInt(), in.nextInt());
      }
      for(int i = 0; i < r; i++){
          for(int j = 0; j < c; j++){
              if(e > pasture[i][j]){
                d += e - pasture[i][j];
              }
          }
      }return d * 72 * 72;
    }catch (FileNotFoundException e){
      return -1;
    }
  }



  public static void stomp(int[][] pasture, int R_s, int C_s, int D_s){
    R_s -= 1;
    C_s -= 1;
    int greatest = pasture[R_s][C_s];
    for (int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        if (pasture[R_s + i][C_s + j] > greatest){
          greatest = pasture[R_s + i][C_s + j];
        }
      }
    }
    int f = greatest - D_s;
    for (int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        if (pasture[R_s + i][C_s + j] > f){
          pasture[R_s + i][C_s + j] = f;
        }
      }
    }
  }

}
