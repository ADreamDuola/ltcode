package com.sap.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum2ZX {

  public int[] solution(int[] arr,int target){
    Map<Integer,Integer> m = new HashMap<>();
    int[] a = new int[2];
    for(int i=0;i<arr.length;i++){
      int c = target-arr[i];
      if(m.containsKey(c))
      {
//        int s = m.get(c);
//        a[0]=s;
//        a[1]=i;
//        return a;
        return new int[]{m.get(c),i};
      }
      m.put(arr[i],i);
    }
//    return "";
    throw new IllegalArgumentException("no");
  }

  public static void main(String[] args) {
    int[] nums = new int[4];
    nums[0] = 2;
    nums[1] = 7;
    nums[2] = 9;
    nums[3] = 22;
    int target = 9;
    int[] result;
    int[] nums1 = {2, 1, 5, 4, 10};
    Sum2ZX s = new Sum2ZX();
    int[] resul = s.solution(nums1,target);
  }

}
