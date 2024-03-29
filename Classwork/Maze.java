import java.util.*;
import java.io.*;

public class Maze{
  public static void main (String[] args){
    try{
      String fileName = args[0];
      File file = new File(fileName);
      System.out.println(Arrays.deepToString(mazeToArr(file)));
    }catch (FileNotFoundException e){
      System.out.println("No file found");
    }
  }

  public static char[][] mazeToArr(File file) throws FileNotFoundException{
    ArrayList<String> rows = new ArrayList<String>();
    Scanner in = new Scanner(file);
    while(in.hasNextLine()){
      rows.add(in.nextLine());
    }int c = (rows.get(0)).length();
    char[][]maze = new char[rows.size()][c];
    for (int i = 0; i < rows.size(); i++){
      maze[i] = (rows.get(i)).toCharArray();
    }return maze;
  }

}
