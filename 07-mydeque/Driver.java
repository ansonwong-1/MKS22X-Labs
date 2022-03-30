import java.util.*;
import java.io.*;
public class Driver{
  public static void main (String[] args){
    MyDeque<Integer> st = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    int add = 1;
    for(int i = 0; i < 260; i++){
      st.addFirst(add);
      real.addFirst(add);
      add++;
      if(!(real.toString().equals(st.toString()))){
        System.out.println(st.toStringAll());
      }
    }
  }
}
