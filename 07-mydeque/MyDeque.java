import java.util.*;


public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  private void resize(){

  }
  public MyDeque(){  }

  public MyDeque(int initialCapacity){  }

  // public int size(){ }
  //
  public String toString(){
    // toString format has comma space between values, examples: "[a, b, c, d]" "[]" "[VALUE, VALUE2, VALUE3]"
    String ans = "[";
    for (int i = 0 ; i < size; i++){
      ans += data[i];
      if (i != size - 1){
        ans += ", ";
      }
    }return ans + "]";
  }
  //
  // public void addFirst(E element){ }
  //
  // public void addLast(E element){ }
  //
  // public E removeFirst(){ }
  //
  // public E removeLast(){ }
  //
  // public E getFirst(){ }
  //
  // public E getLast(){ }
}
