import java.util.*;
import java.io.*;
public class Bronze{

  public static long solve(String filename){
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int r = in.nextInt();
      int c = in.nextInt();
      int[][] pasture = new int[r][c];
      int te = in.nextInt();
      int ins = in.nextInt();
      int d = 0;
      for (int i = 0; i < pasture.length; i++){
        for (int j = 0; j < pasture[i].length; j++){
          pasture[i][j] = in.nextInt();
        }
      }
      for(int i = 0; i < ins; i++){
        stomp(pasture, in.nextInt(), in.nextInt(), in.nextInt());
      }
      for(int i = 0; i < r; i++){
          for(int j = 0; j < c; j++){
              if(te > pasture[i][j]){
                d += te - pasture[r][c];
              }
          }
      }
    }catch (FileNotFoundException e){
      return -1;
    }return d * 6 * 12 * 6 * 12;
  }



  public static void stomp(int[][] pasture, int R_s, int C_s, int D_s){
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
