package com.sap.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 **给定nums = [2,7,11,15], target  =9
 * 因为nums[0]+nums[1]=2+7=0
 * 所以返回[0,1]
 */

public class SumOfTwo {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int completement = target - nums[i];

      if (map.containsKey(completement)) {
        return new int[]{map.get(completement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No");
  }

  public static void main(String[] args) {
//        int[] nums ={2,7,11,15};
    int[] nums = new int[4];
    nums[0] = 2;
    nums[1] = 7;
    nums[2] = 9;
    nums[3] = 22;
    int target = 9;
    int[] result;
    int[] nums1 = {2, 1, 5, 4, 10};
    String str = "a9a-vc9";
    int test1 = str.indexOf("-");
    String pattern = "^[A-Za-z].*";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(str);
    Boolean test = m.matches();
    int[] result1;
    SumOfTwo sumOfTwo = new SumOfTwo();
    result = sumOfTwo.twoSum(nums, target);
    Boolean res = sumOfTwo.repeatedSubstringPattern("abab");
    result1 = sumOfTwo.dailyTemperatures(nums1);
    for (int i = 0; i < 2; i++) {
      System.out.println(result[i]);
    }

  }

//    public int[] jiaobiao(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            int completement = nums[i];
//
//            if(map.containsKey(completement)){
//                return new int[]{map.get(completement),i};
//            }
//            map.put(nums[i],i);
//        }
//        throw new IllegalArgumentException("No");
//    }

  //    class Solution {
  public int[] dailyTemperatures(int[] T) {
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      int temp = T[i];
      while (!stack.empty() && temp > T[stack.peek()]) {
        int c = stack.pop();
        ans[c] = i - c;
      }
      stack.push(i);
    }
    return ans;
  }

  public boolean repeatedSubstringPattern(String s) {
    String test = (s+s).substring(1, 2 * s.length() - 1);
    return (s + s).substring(1, 2 * s.length() - 1).contains(s);
  }
//    }


}
