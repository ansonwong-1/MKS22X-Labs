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

  // Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)


  // splitArray([2, 2]) → true
  // splitArray([2, 3]) → false
  // splitArray([5, 2, 3]) → true
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


  // Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with these additional constraints: all multiples of 5 in the array must be included in the group. If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
  //
  //
  // groupSum5(0, [2, 5, 10, 4], 19) → true
  // groupSum5(0, [2, 5, 10, 4], 17) → true
  // groupSum5(0, [2, 5, 10, 4], 12) → false
  public static boolean groupSum5(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }if (nums[start] % 5 == 0){
      groupSum5(start + 1, nums, target - nums[start]);
      if (nums[start] == 1){
        groupSum5(start + 1, nums, target);
      }
    }return groupSum5(start + 1, nums, target)
    || groupSum5(start + 1, nums, target - nums[start]);
  }

  public static void main(String[] args){
    int[] arr = {2, 2};
    System.out.println(splitArray(arr));
    System.out.println(groupSum5(0, arr, 9));
  }
}
