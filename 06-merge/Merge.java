public class Merge{
  public static void mergesort(int[]data){

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

// public static void mergesort(data){
//   int [] temp  =  mergeSortH(data);
//   data = Arrays.copyOf(temp, temp.length);
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
