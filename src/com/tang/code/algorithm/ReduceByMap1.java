/**
 * 
 */
package com.tang.code.algorithm;

import java.util.HashMap;
import java.util.Map;

import com.tang.code.utils.PrintArray;

/**
 * map减少内循环思想：
 * 数组[2,12,7,5,9,1,3],两个数加起来之和为target=9，请找出数组中的这两个数的下角标
 * 如：2+7=9，下角标[0,2]
 */
public class ReduceByMap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,12,7,5,9,1,3};
		int[] res=findIndexTwo(arr);
		PrintArray.printArray("2层for循环", res);
		//通过map减少内循环
		findIndexOne(arr);
		PrintArray.printArray("map减少内循环", res);
	}
	/**
	 * map减少内循环
	 * @param arr
	 * @return
	 */
	public static int[] findIndexOne(int[] arr) {
		int[] result={-1,-1};
		int target = 9;
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				result[0] =map.get(arr[i]);
				result[1] =i;
				return result;
			}
			map.put(target-arr[i], i);//当前数的剩余目标值
		}
		return result;
	}
	/**
	 * 2层for循环
	 * @param arr
	 * @return
	 */
	public static int[] findIndexTwo(int[] arr) {
		int[] result={0,0};
		int target = 9;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				if (arr[i] +arr[j] == target) {
					result[0] =i;
					result[1] =j;
					return result;
				}
			}
		}
		return result;
	}

}
