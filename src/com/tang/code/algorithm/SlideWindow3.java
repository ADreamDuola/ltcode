/**
 * 
 */
package com.tang.code.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 思想：通过2个指针：start && end,end控制循环字段长度，start通过滑动窗口分割条件，当窗口被重新分割时，start移动到该窗口的开始位置；
 * 比如字符串"abcdehgfcabc";请查找出不重复的最长子串的长度
 */
public class SlideWindow3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="abcdcfcabc";
		int res=findMaxLenBySildeWin(str.toCharArray());
		System.out.println(res);
	}
	public static int findMaxLenBySildeWin(char[] s) {
		int res=0;
		int len=s.length;
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for (int start = 0,end = 0; end < len && start <= end; end++) {
			if (map.containsKey(s[end])) {
				start = Math.max(map.get(s[end]), start);
			}
			map.put(s[end], end+1);
			res = Math.max(end-start+1, res);
		}
		return res;
	}
}
