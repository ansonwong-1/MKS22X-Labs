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
      if (start < nums.length - 1 && nums[start + 1] == 1){
        return groupSum5(start + 2, nums, target);
      }return groupSum5(start + 1, nums, target - nums[start]);
    }return groupSum5(start + 1, nums, target) ||
            groupSum5(start + 1, nums, target - nums[start]);
  }


  // Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)
  //
  //
  // groupNoAdj(0, [2, 5, 10, 4], 12) → true
  // groupNoAdj(0, [2, 5, 10, 4], 14) → false
  // groupNoAdj(0, [2, 5, 10, 4], 7) → false

  //wrong
  // public static boolean groupNoAdj(int start, int[] nums, int target) {
  //   if (start == nums.length){
  //     return target == 0;
  //   }if (groupNoAdj(start + 1, nums, target - nums[start])){
  //     start++;
  //   }return groupNoAdj(start + 1, nums, target)
  //   || groupNoAdj(start + 1, nums, target - nums[start]);
  // }

  public static void main(String[] args){
    int[] arr = {3, 5, 1};
    System.out.println(groupSum5(0,arr, 5));
    System.out.println(groupSum5(0, arr, 8));
    System.out.println(groupSum5(0, arr, 19));
    int[] nums = {2, 5, 1, 8};
    System.out.println(groupSum5(0, nums, 6));
  }
}
