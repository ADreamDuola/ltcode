/**
 * 
 */
package com.tang.code.algorithm;

/**
 * @author tanghuan
 *假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 * 时间复杂度：程序运行过程中所有消耗的时间成本，通常有7种：O(1)，O(n),O(n^2),O(logn),O(nlogn),O(2^n),O(n!);
 *           当随着n的增大（n为5时是一个转折点），复杂度有小到大顺序：O(1)<O(logn)<O(n)<O(nlogn)<O(n^2)<O(2^n)<O(n!);
 *           详情时间复杂度曲线分析图
 * 空间复杂度：程序运行需要额外消耗的内存空间。比如：一维数组O(n),二维数组O(n^2)，树的深度为n,则O(n)
 * 算法解题思路，4步走：
 *          1、确认问题无误；
 *          2、想到所以的解决方法，并列出每种的时间空间复杂度；
 *          3、找出最优方法，即运算最快，内存消耗最小；
 *          4、开始写代码，并测试结果。
 * 关于递归的4种解决方法：
 *          1、二分法查找 O(logn)
 *          2、二叉树遍历 O(n)
 *          3、有序二维矩阵 O(n)
 *          4、归并排序 O(nlogn)
 */
public class ClimbTheStairs {
    private static int total;

    /**
     * 方法一：递归调用
     * 时间复杂度为O(2^n),空间复杂度O(n)   时间复杂度和空间复杂度最大的方法
     * @param n
     * @return int
     */
    public static int fib01(int n) {
        if (n == 1 || n == 2)
            total = n;
        else
            total = fib01(n - 1) + fib01(n - 2);
        return total;
    }

    /**
     * 方法2：三目运算符（类似递归）
     * 时间复杂度为O(2^n),空间复杂度O(n)   时间复杂度和空间复杂度最大的方法
     * @param n
     * @return int
     */
    public static int fib02(int n) {
        return (n == 1 || n == 2) ? n : fib02(n - 2) + fib02(n - 1);
    }

    /**
     * 方法3：备忘录法
     * 时间复杂度为O(2^n),空间复杂度O(n)一维数组
     * @param n
     * @return
     */
    public static int fib03(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        } else {
            int[] array = new int[n + 1];
            array[1] = 1;
            array[2] = 2;
            return dfs(n, array);
        }
    }
    public static int dfs(int n, int[] array) {
        if (array[n] != 0) {
            return array[n];
        } else {
            array[n] = dfs(n - 1, array) + dfs(n - 2, array);
            return array[n];
        }
    }
    /**
     * 方法4：动态规划法 (利用数组来存储)
     * 时间复杂度为O(n),空间复杂度O(n)
     * @param n
     * @return int
     */
    public static int fib04(int n) {
        if (n == 0)
            return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 方法5：状态压缩法(又称滚动数组、滑动窗口，用于优化动态规划法的空间复杂度)
     * 时间复杂度为O(n),空间复杂度O(1)
     * @param n
     * @return
     */
    public static int fib05(int n) {
        if (n == 1 || n == 0)
            return 1;
        n = n - 1;
        int result = 0;
        int zero = 1;
        int first = 1;
        while (n > 0) {
            result = zero + first;
            zero = first;
            first = result;
            n--;
        }
        return result;
    }

    /**
     * 方法6：斐波那契数列的通项公式
     * 时间复杂度为O(logn),空间复杂度O(1)
     * @param n
     * @return int
     */
    public static int fib06(int n) {
        if (n == 0)
            return 1;
        if (n == 1 || n == 2)
            return n;
        int result = (int) Math.floor(
                1 / Math.sqrt(5) * (Math.pow((1 + Math.sqrt(5)) / 2, n + 1) - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)));
        return result;
    }



    public static void main(String[] args) {
        int num01 = fib01(8);//递归方法
        System.out.println(num01);
        int num02 = fib02(8);//三目运算
        System.out.println(num02);
//        int num03 = fib03(0);
//        System.out.println(num03);
        int num04 = fib04(8);//动态规划
        System.out.println(num04);
//        int num05 = fib05(8);
//        System.out.println(num05);
//        int num06 = fib06(2);
//        System.out.println("用斐波那契数列的通项公式:" + num06);

    }

}
