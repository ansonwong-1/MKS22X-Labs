import java.util.*;
import java.io.*;
public class Driver{
  public static void main (String[] args){
    MyDeque st = new MyDeque();
    char add = 'a';
    for(int i = 0; i < 26; i++){
      st.addFirst(add);
      add++;
      System.out.println(st.toStringAll());
    }
  }
}
