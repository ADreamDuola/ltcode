package com.tang.code.algorithm;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且n的值至少为 2。
 * 方法一：2层for
 * 方法一：双指针O(n)
 * 方法二：单调栈
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("最大面积暴力解法："+maxArea);
        int res = maxArea01(height);
        System.out.println("最大面积双指针解法：" + res);
    }

    /**
     * @param height
     * @return
     */
    public static int maxArea01(int[] height) {
        int res = 0;
        int len = height.length - 1;
        for (int i = len; i > 0; i--) {
            for (int j = 1; j < len - 1; j++) {
                res = Math.max(Math.min(height[j], height[i]) * (i - j), res);
            }
        }
        return res;
    }

    /**
     * 计算面积：双指针
     * s=h*w=height[i]*height[j]
     * i为快，j为慢
     * 慢指针
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int area = 0;
        int r = height.length - 1;//right
        int l = 1;//left
        while (l < r) {
            int s = Math.min(height[l], height[r]) * (r - l);
            area = Math.max(s, area);
            if (height[l] <= height[r]) {
                l++;//如果右边的高度>左边，则需要移动小的一边，目标是变大
            } else {
                r--;
            }
        }
        return area;
    }

}
