public class Merge{
  public static void mergesort(int[]data){

  }
  public static int[] merge(int[] left, int[] right){
    int[] merged = new int[left.length + right.length];
    int ll = 0, lr = 0;
    for (int i = 0; i < merged.length; i++){
      if(ll >= left.length){
        //add all remaining values of right to the end
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
//   int [] merge(int [] left, int[] right){
//   //return a new array that is the merged version of left and right
// }
//
// void mergesort(data){
//   int [] temp  =  mergeSortH(data);
//   copy temp into data
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
