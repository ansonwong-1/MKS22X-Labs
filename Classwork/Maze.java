import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static void main (String[] args){
    try{
      String fileName = args[0];
      File file = new File(fileName);
      System.out.println(mazeToArr());
    }catch (FileNotFoundException e){
      System.out.println("No file found");
    }
  }

  public static char[][] mazeToArr(File file){
    String ans = "";
    Scanner in = new Scanner(file);
    while(in.hasNext()){
      ans += in.next() + '\n';
    }return ans.toCharArray(ans);
  }

  public static String toString(char[][] arr){
    String ans = "";
    for(int i = 0; i < arr.length; i++){
      for (int j = 0; i < arr[i].length; j++){
        ans += arr[i][j];
      }ans += '\n';
    }return ans;
  }

}
