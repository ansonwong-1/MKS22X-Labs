import java.util.*;
import java.io.*;
public class Quick{
  public static void main (String[] args){
    int[] data = {4, 3, 2, 14, 42, 8, 1, 9, 1, 1, 1, 1, 1, 1};
    System.out.println("Original: " + Arrays.toString(data));
    quicksort(data);
    //System.out.println("Pivot value: "+ data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    System.out.println();
    int[] data1 = {0, 1,2,4,5,6,9,100};
    System.out.println("og" + Arrays.toString(data1));
    System.out.println(quickselect(data, 3));
    System.out.println(Arrays.toString(data1));
  }
  public static void quicksort(int[]data){
    quicksort(data,0,data.length-1);
  }

  public static void quicksort(int[]data,int lo,int hi){
    if (lo < hi){
      int p = partition(data, lo, hi);
      quicksort(data, p + 1, hi);
      quicksort(data, lo, p - 1);
    }
  }

  public static int quickselect(int[] data, int k){
    int s = 0;
    int e  = data.length - 1;
    //int r = partition(data, s, e);
    while(s <= e){
      int r = partition(data, s, e);
      if(k == r){
        return data[r];
      }
      else if(r < k){
        s = r + 1;
      }
      else{
        e = r - 1;
      }
    }return -1;
  }

  public static void swap (int[] arr, int swap, int swap1){
    int temp = arr[swap];
    arr[swap] = arr[swap1];
    arr[swap1] = temp;
  }
  public static int partition (int [] data, int start, int end){
    int pivot = (int)(Math.random() * (end - start + 1) + start);
    swap(data, pivot, end);
    pivot = end;
    int less = start - 1;
    int dupeBefore = 1;
    for (int i = start; i < end; i++){
      if(data[pivot] > data[i]){
        less++;
        swap(data, i, less);
      }else if (data[pivot] == data[i]){
        if(dupeBefore % 2 == 0){
          less++;
          swap(data, i, less);
        }dupeBefore++;
      }
    }swap(data, less + 1, start);
    return less + 1;
  }
}