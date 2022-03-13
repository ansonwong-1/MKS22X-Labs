import java.io.*;
import java.util.*;
public class Silver{
  public static long solve(String filename){
    try{
      File file = new File(filename);
      Scanner in = new Scanner(file);
      int r = in.nextInt();
      int c = in.nextInt();
      int s = 0;
      return s;
    }catch(FileNotFoundException e){
      return -1;
    }
  }

}
