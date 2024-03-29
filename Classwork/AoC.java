import java.util.*;
import java.io.*;
public class AoC{
  public static void main (String[] args){
    try{
      String fileName = args[0];
      File file = new File(fileName);
      Scanner in = new Scanner(file);
      System.out.println(day2(file));
    }catch (FileNotFoundException e){
      System.out.println("ERROR: File not found");
    }
  }
  public static int day1b(File file){
    int count = 0;
    try{
      Scanner in = new Scanner(file);
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      while(in.hasNextInt()){
        int d = in.nextInt();
        if(a + b + c < b + c + d){
          count++;
        }
        a = b;
        b = c;
        c = d;
      }
    }catch(FileNotFoundException e){
      return -1;
    }return count;
  }
  public static int day1(File file){
    int total = 0;
    try{
      Scanner in = new Scanner(file);
      int a = in.nextInt();
      while(in.hasNextInt()){
        int b = in.nextInt();
        if (a < b){
          System.out.println( a + "   " + b);
          total++;
        }
        a = b;
        if (a < b){
          System.out.println( a + "   " + b);
          total++;
        }
      }
    }catch(FileNotFoundException e){
      return -1;
    }
    return total;
  }
}
