import java.util.*;
import java.io.*;
public class Merge{

  public static int[] mergesortH(int[]data){
    if(data.length > 1){
      int[] L = new int[data.length / 2];
      if(data.length % 2 == 1){
        int[] R2 = new int[data.length / 2 + 1];
        for(int i = 0; i < data.length; i++){
          if (i < data.length / 2){
            L[i] = data[i];
          }else{
            R2[i] = data[i];
          }
        }mergesort(L);
        mergesort(R2);
        return merge(L, R2);
      }else{
        int[] R = new int[data.length / 2];
        for(int i = 0; i < data.length; i++){
          if (i < data.length / 2){
            L[i] = data[i];
          }else{
            R[i] = data[i];
          }
        }
        mergesort(L);
        mergesort(R);
        return merge(L, R);
      }
    }return data;
  }
  public static int[] merge(int[] left, int[] right){
    int[] merged = new int[left.length + right.length];
    int ll = 0, lr = 0;
    for (int i = 0; i < merged.length; i++){
      if(ll >= left.length){
        while(i < merged.length){
          merged[i] = right[ll];
          ll++;
          i++;
        }
      }else if(lr >= right.length){
        while(i < merged.length){
          merged[i] = right[lr];
          lr++;
          i++;
        }
      }else{
        if(left[ll] < right[lr]){
          merged[i] = left[ll];
          ll++;
        }else{
          merged[i] = right[lr];
          lr++;
        }
      }
    }return merged;
  }

public static void mergesort(int[] data){
  int [] temp  =  mergesortH(data);
  data = Arrays.copyOf(temp, temp.length);
}
//
// int[] mergesortH(data){
//   if more than 1 element{
//     left = copy half of data
//     right = copy other half of data
//     return merge(mergesortH(left),mergesortH(right))
//   }
// }
}
