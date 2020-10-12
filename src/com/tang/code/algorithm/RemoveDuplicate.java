package com.tang.code.algorithm;

/**
 *  删除排序数组中的重复项
 *给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * nums = [0,0,1,1,1,2,2,3,3,4],函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
       int result= removeDuplicate(nums);
        System.out.println(result);
    }

    /**
     * 双指针法,其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]，我们就增加 jj 以跳过重复项。
     * @param arr
     * @return
     */
    public static int removeDuplicate(int[] arr) {
        int j=0;//慢指针
        for (int i = j; i < arr.length; i++) {
            if(arr[i]!=arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return  j+1;
    }
}
