import java.util.*;
import java.io.*;
public class Driver{
  public static void main (String[] args){
    MyDeque<Integer> st = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    int add = 1;
    Random random = new Random();
    for(int i = 0; i < 260; i++){
      add = random.nextInt();
      st.addLast(add);
      real.addLast(add);
      add++;
      if(!(real.toString().equals(st.toString()))){
        System.out.println(st.toStringAll());
      }
    }


  }
}
