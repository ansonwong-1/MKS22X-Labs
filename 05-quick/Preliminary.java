import java.util.*;
import java.io.*;
public class Preliminary{
  public static void main (String[] args){
    int[] data = {4, 3, 2, 1, 4, 8, 1, 9};
    System.out.println("Original: " + Arrays.toString(data));
    int pivot = partition( data , 0, data.length);
    System.out.println("Pivot value: "+ data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    System.out.println();
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
  public static void swap (int[] data, int swap, int swap1){
    int temp = arr[swap];
    arr[swap] = arr[swap1];
    arr[swap1] = temp;
  }
  public static int partition (int [] data, int start, int end){
    int pivot = (int)(Math.random() * (end - start + 1) + start);
    int pivotVal = data[pivot];
    data[pivot] = data[end];
    data[end] = pivotVal;
    int pivot = (int)(Math.random() * (end - start + 1) + start);
    // really big comment to remind you that this is 2-3 times slower than it should be.
    int[] temp = new in
    for (int i = start; i < end; i++){
      if (data[pivot] > data[i]){
        temp[less] = data[i];
        System.out.println("l" + Arrays.toString(temp));
        less++;
      }
      else if (data[pivot] < data[i]){
        temp[greater] = data[i];
        System.out.println("g" + Arrays.toString(temp));
        greater--;
      }else{
        same++;
        System.out.println("s");
      }
    }
    for (int i = 0; i < same; i++){
      temp[less] = data[pivot];
      less++;
    }
    System.out.println(Arrays.toString(temp));
    data = Arrays.copyOf(temp, temp.length);
    System.out.println("data" + Arrays.toString(data));
    return less + 1;
  }

}
