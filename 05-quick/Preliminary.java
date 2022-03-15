import java.util.*;
import java.io.*;
public class Preliminary{
  public static void main (String[] args){
    int[] arr = {999,999,999,4,3,2,1,0,999,999,999};
  }
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  public static int partition (int [] data, int start, int end){
    int pivot = (int)(Math.random() * (end - start + 1) + start);
    // really big comment to remind you that this is 2-3 times slower than it should be.
    int[] temp = new int[end - start];
    int less = 0;
    int greater = temp.length - 1;
    for (int i = start; i < end; i++){
      if (data[pivot] > data[i]){
        temp[less] = data[i];
        less++;
      }
      else if (data[pivot] < data[i]){
        temp[greater] = data[i];
      }
    }return less + 1;
  }

}
