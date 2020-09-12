package com.sap.code;

import java.util.HashMap;
import java.util.Map;

/*
 *无重复字符的最长子串e
 */
public class WuChongFuZiChuan {
    public static void main(String[] args) {
        String test = "abcdcefg";
//        String test = "abcadefbb";
        int i = WuChongFuZiChuan.find(test);
        System.out.println(i);

    }

    public static int find(String s){
        int len = s.length();
        int res = 0;
//        int end=0,start=0;
        Map<Character,Integer> map=new HashMap<>();
          for(int end=0,start=0;start<len && end<len;end++){
            if(map.containsKey(s.charAt(end))){
                start=Math.max(map.get(s.charAt(end)),start);
                //从有重复的下一个位置继续找或者start不变（例如abcdceag第一次遇到了c,start放到d的位置，第二次遇到遇到a时，start就不变了）
            }
            map.put(s.charAt(end),end+1);//map每次更新
            res=Math.max(res,end-start+1);//结果每次更新
        }
        return res;
    }
}
//算法
//滑动窗口初听觉得抽象模糊，其实拿卷尺一对比很好理解
//一个字符串，要在里面找出最长且没有重复字符的子串，就像拿着卷尺在上面不停地缩拉测量
//子串就是这个卷尺的伸出部分，即一个窗口，左边缩进，右边拉出
//因为不能有重复的字符，在右端逐渐拉长的过程中，每新增加的一个新字符都要拿来和左侧子串中的字符做对比

//滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
// 使用 Hash表将字符存储在当前窗口 [i,j)（最初 j=i）中。 然后我们向右侧滑动索引 j，如果它不在 Hash表中，我们会继续滑动 j。直到 s[j] 已经存在于 Hash表中。
// 此时，我们找到的没有重复字符的最长子字符串将会以索引 i开头。

//start++代表，如果窗口向后滑动时，出现了跟前边一样的字符(出现过的字符)，那重复的字符可能start那个位置的字符，也可能是前边字符串中start靠后位置的字符，start++的目的是逐步将头部缩短，
// 以达到将重复字符排除在外的目的。举例子好理解一些: abcb***，窗口是[0,1)[0,2)[0,3)，对应的是a,ab,abc,都没有重复字符，
// 到[0,4)时，abcb,发现b在HashSet中已经出现过，这时候移除start++对应的字符，注意此时end没有++，得到[1,4), bcb,然后继续在while中执行，
// 发现end对应的字符仍然在set中出现过，继续移除start++对应的字符，得到[2,4),即cb，此时再进入循环执行，已经没有重复的了，将向后继续滑动窗口，执行end++

/*
 eg   abcabcbb
        start   end   res       map            滑动窗口范围
         0       0     1        a->1                a
         0       1     2        a->1,b->2           a,b
         0       2     3        a->1,b->2,c->3      a,b,c
         1       3     3        a->4,b->2,c->3      b,c,a
*/

