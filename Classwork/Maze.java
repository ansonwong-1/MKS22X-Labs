import java.util.*;
import java.io.*;

public class Maze{
  public static void main (String[] args){
    try{
      String fileName = args[0];
      File file = new File(fileName);
      System.out.println(mazeToArr(file));
    }catch (FileNotFoundException e){
      System.out.println("No file found");
    }
  }

  public static char[][] mazeToArr(File file){
    Arraylist<String> rows = new Arraylist<String>();
    try{
      Scanner in = new Scanner(file);
      while(in.hasNext()){
        rows.add(in.next());
      }int c = (rows.get(0)).length;
      char[][]maze = new char[rows.size()][c];
      for (int i = 0; i < rows.size(); i++){
        maze[i] = (rows.get(i)).toCharArray();
      }return maze;
    }catch (FileNotFoundException e){
      return null;
    }
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
