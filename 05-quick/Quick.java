import java.util.*;
import java.io.*;
public class Quick{
  public static void main (String[] args){
    int [] data = new int[] {4,3,2,1,0};
System.out.println("Original: "+Arrays.toString(data));
int pivot = partition( data , 0, 4);
System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
System.out.println("Modified: "+Arrays.toString(data));
System.out.println();
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
      if(data[i] <= data[pivot]){
        if(data[i] == data[pivot] && dupeBefore % 2 == 0){
          dupeBefore++;
        }else{
          dupeBefore++;
          less++;
          swap(data, less, i);
        }
      }
    }swap(data, less + 1, pivot);
    return less + 1;
  }
}
