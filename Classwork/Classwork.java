public class Classwork{
  public static boolean partialSum(int start,int[] arr,int targetValue){
    if (targetValue > 0 || start == arr.length - 1){
      if (!partialSum()){
        
      }
    }
    else if (targetValue == 0){
      return true;
    }
    return false;
  }

  public static void main (String [] args){
    int[] arr = {5, 3, 7, 1};
    System.out.println(partialSum(0, arr, 11));
  }
}
