/**
 * 
 */
package com.tang.code.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanghuan
 *
 */
public class DevRule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toList();
		toArray();

	}
	/**
	 * Arrays.asList坑点
	 * 必须为包装类型，并且不能直接用集合的操作add/remove等
	 */
	public static void toList() {
		//基本数据类型 不支持，还是一个数组
//		int[] myArray={1,2,3};
//		List mList=(List) Arrays.asList(myArray);//编译报错
//		System.out.println(mList.size());
//		反例
		//包装数据类型
		Integer[] myArray={1,2,3};
//		List list=Arrays.asList(myArray);//转型错误
//		list.add("4");//报错：没有这个操作
//		System.out.println(list.toString());
		//正例
		List<Integer> list2=new ArrayList<Integer>(Arrays.asList(myArray));
		list2.add(4);
		System.out.println(list2.toString());
		
	}
	/**
	 * Collections.asList坑点
	 */
	public static void toArray() {
		List<String> list3=new ArrayList<String>(10);
		list3.add("1");
		list3.add("hello");
		list3.toArray();
		System.out.println(list3.toString());
	}
}
