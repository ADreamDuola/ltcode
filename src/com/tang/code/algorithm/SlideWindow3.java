/**
 * 
 */
package com.tang.code.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 思想：通过2个指针：start && end,end控制循环字段长度，start通过滑动窗口分割条件，当窗口被重新分割时，start移动到该窗口的开始位置；
 * 比如字符串"abcdehgfcabc";请查找出不重复的最长子串的长度
 *时间复杂度O(n),空间复杂度O(m)
 * 技巧：滑动窗帘+双指针
 * 解法有2中：
 * 方法一：暴力解法 一个for循环遍历遍历字串，一个for循环找到重复字串，并通过hashSet 判断是否重复，最后将截取后的不重复字串存储在
 * 方法二：滑动窗帘+双指针，通过
 */
public class SlideWindow3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="abcdcfcabcdefghi";
		int res=findMaxLenBySildeWin(str.toCharArray());
		System.out.println(res);
	}
	public static int findMaxLenBySildeWin(char[] s) {
		int res=0;
		if(s.length ==0){
			return res;
		}
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for (int start = 0,end = 0; end < s.length && start <= end; end++) {
			if (map.containsKey(s[end])) {
				start = Math.max(map.get(s[end]) + 1, start);
			}
				map.put(s[end], end);
			res = Math.max(end-start+1, res);
		}
		return res;
	}
//	作者：LeetCode-Solution
//	链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

	/**
	 * 时间复杂度O(n^2),空间复杂度O(m)
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> occ = new HashSet<Character>();
		int n = s.length();
		// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1, ans = 0;
		for (int i = 0; i < n; ++i) {
			if (i != 0) {
				// 左指针向右移动一格，移除一个字符
				occ.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
				// 不断地移动右指针
				occ.add(s.charAt(rk + 1));
				++rk;
			}
			// 第 i 到 rk 个字符是一个极长的无重复字符子串
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}
}
