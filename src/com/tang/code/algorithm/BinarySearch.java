/**
 * 
 */
package com.tang.code.algorithm;

import java.util.Arrays;

/**
 * @author 
 *二分法查找
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] arr2 = {1,2,3,12,5,6,7,8};
		Arrays.sort(arr2);//要经过排序的数组
		int a = 8;
		System.out.println(binarySearch(a,arr));
	}
	/**
	 * 二分法查找，查出目标对象数组中的位置
	 * @return
	 */
	public static int twoSearch(int a,int[] arr) {
		int minIdx = 0;//最小索引
		int maxIdx = arr.length -1;//最大索引
		int halfIdx = minIdx+(minIdx+maxIdx)/2;//中间位置索引
		while (minIdx<=maxIdx) {
			if (arr[halfIdx]== a) {//找到结果
				return halfIdx;
			}else if (arr[halfIdx] > a) {
				maxIdx = halfIdx-1;
			}else{
				minIdx = halfIdx +1;
			}
			halfIdx = minIdx + (maxIdx-minIdx)/2;//重新移动中间索引位置
		}
		return -1;
	}
	// 二分法查找
	static int binarySearch(int a,int[] arr){
		// 最大索引
		int maxIndex = arr.length -1;
		// 最小索引
		int minIndex = 0;
		// 中间索引
		int halfIndex = minIndex+(maxIndex-minIndex)/2;

		while (minIndex<=maxIndex){
			// 找到时 
			if (arr[halfIndex]==a){
				return halfIndex;
			}else if (arr[halfIndex]<a){// 比a小时
				minIndex = halfIndex + 1;
			}else {// 比a大时
				maxIndex = halfIndex - 1;
			}
			halfIndex = minIndex+(maxIndex-minIndex)/2;
		}
		return -1;
	}

}
