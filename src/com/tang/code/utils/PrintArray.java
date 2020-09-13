/**
 * 
 */
package com.tang.code.utils;

/**
 * 打印数组
 *
 */
public class PrintArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void printArray(String desc,int[] arr) {
		System.out.print(desc+":");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
}
