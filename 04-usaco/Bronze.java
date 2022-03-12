import java.util.*;
import java.io.*;
public class Bronze{

  public static long solve(String filename){
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int[][] pasture = new int[in.nextInt()][in.nextInt()];
      int te = in.nextInt();
      int ins = in.nextInt();
      for (int i = 0; i < pasture.length; i++){
        for (int j = 0; j < pasture[i].length; j++){
          pasture[i][j] = in.nextInt();
        }
      }
    }catch (FileNotFoundException e){
      return -1;
    }return vol;
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
