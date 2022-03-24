import java.util.*;
import java.io.*;
public class Merge{
  public static void main (String[] args){
    int[] data = {3,51,2,3,1,4,3,6,7};
    Arrays.sort(data);
    int[] data1 = {34,-31,-4,-5,-33};
    Arrays.sort(data1);
    System.out.println(Arrays.toString(merge(data1, data)));
  }

  public static int[] merge(int[] left, int[] right){
    int[] merged = new int[left.length + right.length];
    int ll = 0, lr = 0;
    for(int i = 0; i < merged.length; i++){
      if (ll < left.length && lr < right.length){
        if (left[ll] < right[lr]){
          merged[i] = left[ll];
          ll++;
        }else{
          merged[i] = right[lr];
          lr++;
        }
      }else if (lr < right.length){
        merged[i] = right[lr];
        lr++;
      }else if (ll < left.length){
        merged[i] = left[ll];
      }
    }return merged;
  }

// public static void mergesort(int[] data){
//   int [] temp  =  mergesortH(data);
//   data = Arrays.copyOf(temp, temp.length);
// }
// public static int[] mergesortH(int[]data){
//   if(data.length > 1){
//     int l = data.length / 2;
//     int r = data.length - l;
//     int[] L = new int[l];
//     int[] R = new int[r];
//     for(int i = 0; i < data.length; i++){
//       if (i < l){
//         L[i] = data[i];
//       }else{
//         R[i - l] = data[i];
//       }
//     }
//     mergesort(L);
//     mergesort(R);
//     return merge(L, R);
//   }return data;
// }
//
// int[] mergesortH(data){
//   if more than 1 element{
//     left = copy half of data
//     right = copy other half of data
//     return merge(mergesortH(left),mergesortH(right))
//   }
// }
}
