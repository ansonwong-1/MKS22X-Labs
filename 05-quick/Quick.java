import java.util.*;
import java.io.*;
public class Quick{
  public static void main (String[] args){
    int[] data = {4, 3, 2, 14, 42, 8, 1, 9, 1, 1, 1, 1, 1, 1};
    System.out.println("Original: " + Arrays.toString(data));
    int pivot = partition( data , 0, data.length);
    System.out.println("Pivot value: "+ data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    System.out.println();
  }

  public static int quickselect(int[] data, int k){
    int s = 0;
    int e  = data.length - 1;
    int r = partition(data, s, e);
    while(r != k){
      if(r < k){
        s = r;
        r = partition(data, s + 1, e);
      }
      else if(r > k){
        e = r;
        r = partition(data, s, e - 1);
      }
    }return data[r];
  }

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
    int dupeBefore = 1;
    for (int i = start; i < end; i++){
      if(pivotVal > data[i]){
        swap(data, i, less);
        less++;
      }else if (pivotVal == data[i]){
        if(dupeBefore % 2 == 0){
          swap(data, i, less);
          less++;
        }dupeBefore++;
      }
    }swap(data, less - 1, start);
    return less - 1;
  }

}
