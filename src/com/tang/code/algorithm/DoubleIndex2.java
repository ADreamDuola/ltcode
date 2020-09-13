/**
 * 
 */
package com.tang.code.algorithm;

/**
 * 双指针思想：主要是链表的移动，通过快慢指针，间隔一定step达到快速定位的作用
 * 练习题：如何快速找到链表中倒数第k个值，如何找到中间（1/2）的值，或者1/3处值
 */
public class DoubleIndex2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Node head= new Node(1);
//		head.next = new Node(2);
		
	}
	public Node findKFromTail(Node head,int k ) {
		Node fast= head;
		Node slow= head;
		for (int i = 0; i < k; i++) {
			if (fast == null) {//在没走到k步之前若返回，则证明k>链表长度
				return null;
			}
			fast=fast.next;
		}
		while (fast !=null) {
			fast=fast.next;
			slow=slow.next;
		}
		
		return slow;
	}
	
	static	class Node {
		int item;
		Node next;
		
		Node( int val) {
			this.item = val;
			this.next = null;
		}
	}
}
