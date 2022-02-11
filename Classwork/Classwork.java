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
    if (start >= nums.length){ //cause this one has errors otherwise cause the + 2 can make it go over
      return target == 0;
    }return groupNoAdj(start + 1, nums, target) ||
            groupNoAdj(start + 2, nums, target - nums[start]);
  }

  public static boolean splitOdd10(int[] nums) {
    return splitOdd10(0, 0, 0, nums);
  }
  public static boolean splitOdd10(int start, int group10, int groupOdd, int[] nums){
    if (start == nums.length){
      return group10 % 10 == 0 && groupOdd % 2 == 1;
    }return splitOdd10(start + 1, group10 + nums[start], groupOdd, nums) ||
            splitOdd10(start + 1, group10, groupOdd + nums[start], nums);
  }

  public static void main(String[] args){
    int[] arr = {3, 5, 1};
    System.out.println(groupNoAdj(0, arr, 5));
    System.out.println(groupNoAdj(0, arr, 8));
    System.out.println(groupSum5(0, arr, 19));
    int[] nums = {2, 5, 1, 8};
    System.out.println(groupSum5(0, nums, 6));
  }
}
