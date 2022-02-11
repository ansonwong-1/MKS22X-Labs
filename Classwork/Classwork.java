public class Classwork{

  public static boolean groupSum(int start, int[] nums, int target) {
    if (target == 0){
      return true;
    }else if(start == nums.length){
      return false;
    }else{
      return groupSum(start + 1, nums, target - nums[start]) ||
             groupSum(start + 1, nums, target);
    }
  }

  public static boolean splitArray(int[] nums) {
    return splitArray(0, 0, 0, nums);
  }
  public static boolean splitArray(int index, int groupSum1, int groupSum2, int[] nums){
    if(index == nums.length){
      return groupSum1 == groupSum2;
    }else{
      return splitArray(index + 1, groupSum1 + nums[index], groupSum2, nums) ||
             splitArray(index + 1, groupSum1, groupSum2 + nums[index], nums);
    }
  }

  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }if (nums[start] == 6){
      return groupSum6(start + 1, nums, target - nums[start]);
    }return groupSum6(start + 1, nums, target - nums[start])
    || groupSum6(start + 1, nums, target);
  }


  public static boolean groupSum5(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }if (nums[start] % 5 == 0){
      if (start < nums.length - 1 && nums[start + 1] == 1){
        return groupSum5(start + 2, nums, target - nums[start]);
      }return groupSum5(start + 1, nums, target - nums[start]);
    }return groupSum5(start + 1, nums, target) ||
            groupSum5(start + 1, nums, target - nums[start]);
  }


  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }if 
  }
  public static void main(String[] args){
    int[] arr = {3, 5, 1};
    System.out.println(groupSum5(0, arr, 5));
    System.out.println(groupSum5(0, arr, 8));
    System.out.println(groupSum5(0, arr, 19));
    int[] nums = {2, 5, 1, 8};
    System.out.println(groupSum5(0, nums, 6));
  }
}
