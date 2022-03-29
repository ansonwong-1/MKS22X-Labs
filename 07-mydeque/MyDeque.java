import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = -1;
    size = 0;
  }

  private void resize(){
    if (size == data.length - 1){
      E[] d = (E[]) new Object[size * 2 + 1];
      int s = start;
      for (int i = 0; i < size; i++){
        if (s == data.length){
          s = 0;
        }
        if (s < data.length){
          d[i] = data[s];
          s++;
        }
      }
      data = d;
      start = 0;
      end = data.length;
    }
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = -1;
    size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "[";
    int s = start;
    for (int i = 0; i < size; i++){
      if (s == data.length){
        s = 0;
      }
      ans += data[s];
      s++;
      if (i != size - 1){
        ans += ", ";
      }
    }
    return ans + "]";
  }
  public String toStringAll(){
    String ans = "[";
    for (int i = 0 ; i < data.length; i++){
      ans += data[i];
      if (i != data.length - 1){
        ans += ", ";
      }
    }return ans + "]" + '\n' + "start: " + start + "   end: " + end;
  }

  public void addFirst(E element){
    resize();
    if (start == 0){
      start = data.length - 1;
    }else{
      start--;
    }
    data[start] = element;
    size++;
  }

  // public void addLast(E element){ }

  // public E removeFirst(){
  //   if (size > 0){
  //     E ans = data[start];
  //     data[start] = null;
  //     start++;
  //     return ans;
  //   }else if(size == 0){
  //     throw new NoSuchElementException ("no elements in the deque");
  //   }else{
  //     return null;
  //   }
  // }
  //
  // public E removeLast(){
  //   if (size > 0){
  //     E ans = data[end];
  //     data[end] = null;
  //     end--;
  //     return ans;
  //   }else if (size == 0){
  //     throw new NoSuchElementException ("no elements in the deque");
  //   }
  // }

  // public E getFirst(){
  //
  // }
  //
  // public E getLast(){ }
}
