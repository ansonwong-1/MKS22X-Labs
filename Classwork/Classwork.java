public class Classwork{


  public static boolean groupSum(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }return groupSum(start + 1, nums, target - nums[start])
    || groupSum(start + 1, nums, target);
  }

  // Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)
  //
  //
  // splitArray([2, 2]) → true
  // splitArray([2, 3]) → false
  // splitArray([5, 2, 3]) → true
  // public static boolean splitArray(int[] nums) {
  //   splitArray(0, nums);
  // }
  // public static boolean splitArray(int index, int[] nums){
  //   if(index == nums.length){
  //     return false;
  //   }
  // }


  // Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen. (No loops needed.)
  //
  //
  // groupSum6(0, [5, 6, 2], 8) → true
  // groupSum6(0, [5, 6, 2], 9) → false
  // groupSum6(0, [5, 6, 2], 7) → false
  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start == nums.length){
      return target == 0;
    }if (nums[start] == 6){
      return groupSum6(start + 1, nums, target - nums[start]);
    }return groupSum6(start + 1, nums, target - nums[start])
    || groupSum6(start + 1, nums, target);
  }

  public static void main(String[] args){
    int[] arr = {5, 6, 2};
    System.out.println(groupSum6(0, arr, 8));
    System.out.println(groupSum6(0, arr, 9));
  }
}
