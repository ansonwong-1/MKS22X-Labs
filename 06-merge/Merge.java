import java.util.*;
import java.io.*;
public class Merge{
  public static void main (String[] args){
    int[] arr = {2,3,4,1,4,2,1,2,4,1,2};
    System.out.println(Arrays.toString(mergesortH(arr)));
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

  public static int[] mergesortH(int [] data){
      //********************
      //COMPLETE THIS METHOD
      //********************
      //if more than 1 element{
        //left = copy half of data
        //right = copy other half of data
        //sort each half and merge them together
      //}
      if(data.length > 1){
        int l = data.length / 2;
        int[] L = new int[l];
        int[] R = new int[data.length - l];
        for(int i = 0; i < l; i++){
          L[i] = data[i];
        }System.out.println(Arrays.toString(L));
      }return new int[1];
    }

    /*mergesort uses the recursive mergesortH method to create a sorted
    *version of the array. It then copies the data back into the original
    *array. (This is for compatibility with prior sort testers)
    *@param data the array to be sorted, this will be modified by the method
    */
    public static void mergesort(int [] data){
      int [] temp  =  mergesortH(data);
      for(int i = 0; i < data.length; i++){
        data[i] = temp[i];
      }
    }

// int[] mergesortH(data){
//   if more than 1 element{
//     left = copy half of data
//     right = copy other half of data
//     return merge(mergesortH(left),mergesortH(right))
//   }
// }
}
