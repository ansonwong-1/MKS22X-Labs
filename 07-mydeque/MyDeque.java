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
    start = -1;
    end = -1;
    size = 0;
  }
  private void resize(){
    if (size >= data.length){
      E[] d = (E[]) new Object[data.length * 2 + 1];
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
      end = size - 1;
    }
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = -1;
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
    }return ans + "]" + '\n' + "start: " + start + "   end: " + end + "    length: " + data.length;
  }



  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("null");
    }
    resize();
    if (start == 0){
      start = data.length - 1;
    }else{
      start--;
    }
    if (size <= 0){
      start = 0;
      end = 0;
    }
    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("null");
    }
    resize();
    if (end == data.length - 1){
      end = 0;
    }
    if (size == 0){
      end = 0;
      start = 0;
    }
    else{
      end++;
    }
    data[end] = element;
    size++;
  }

  public E removeFirst(){
    if (size > 0){
      E ans = data[start];
      data[start] = null;
      if (start != data.length - 1){
        start++;
      }else{
        start = 0;
      }
      size--;
      return ans;
    }else{
      throw new NoSuchElementException ("no elements in the deque");
    }
  }

  public E removeLast(){
    if (size > 0){
      E ans = data[end];
      data[end] = null;
      if (end != 0){
        end--;
      }else{
        end = data.length - 1;
      }
      size--;
      return ans;
    }else{
      throw new NoSuchElementException ("no elements in the deque");
    }
  }

  public E getFirst(){
    if (size > 0){
      return data[start];
    }else{
      throw new NoSuchElementException ("no elements in deque");
    }
  }

  public E getLast(){
    if (size > 0){
      return data[end];
    }else{
      throw new NoSuchElementException ("no elements in deque");
    }
  }
}
