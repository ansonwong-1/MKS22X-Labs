import java.util.*;
import java.io.*;
public class Quick{
  public static void main (String[] args){
    int[] data = {4, 3, 2, 14, 42, 8, 1, 9};
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
  public static void swap (int[] arr, int swap, int swap1){
    int temp = arr[swap];
    arr[swap] = arr[swap1];
    arr[swap1] = temp;
  }
  public static int partition (int [] data, int start, int end){
    int pivot = (int)(Math.random() * (end - start + 1) + start);
    int pivotVal = data[pivot];
    swap(data, pivot, start);
    int less = start + 1;
    for (int i = start; i < end; i++){
      if(pivotVal > data[i]){
        swap(data, i, less);
      //  System.out.println(Arrays.toString(data));
        less++;
      }
    }swap(data, less - 1, start);
    //System.out.println(Arrays.toString(data));
    System.out.println(pivot + " " + pivotVal);
    return less - 1;
  }

}
