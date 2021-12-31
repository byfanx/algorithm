package com.byfan.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Description: 寻找数组中缺少的数字
 * @Author: byfan
 * @Date: 2021/12/26 16:52
 */

/**
 * 题目描述
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0～n-1 之内。在范围 0～n-1 内的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 * 1 <= 数组长度 <= 10000
 */
public class MissingNumber {

    /**
     * 思路：
     * 遍历数组，比较当前数字和当前角标是否相同，不相同就返回当前角标。
     * @param nums
     * @return
     */
    public static int missingNumber_1(int[] nums){
        for (int i=0;i<nums.length;i++){
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 思路：
     * 因为是递增，如果不连续要么不是从0开始的，要么其中一定有两个数相差大于1。
     * 1.如果第一个数不等于0，则代表缺少0，返回0；
     * 2.如果第一个数等于0，设pre是当前数，pre初始为数组第一个数。
     * 3.从第二位遍历数组，遍历的当前数与pre差值大于1，则代表缺少pre+1。
     * 4.如果当前数与pre差值不大于1，pre等于当前数，继续遍历。
     * @param nums
     * @return
     */
    public static int missingNumber_2(int[] nums){
        if (nums[0] != 0){
            return 0;
        }
        int pre = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i] - pre > 1){
                return pre+1;
            }
            pre = nums[i];
        }
        return nums.length;
    }


        /**
         * 解题方案
         * 思路
         * ·标签：数组、二分查找
         * ·整体思路：
         *      ·因为数组从0增序存储，所以如果不缺失则数字与数组索引对应。缺失的数字等于 “右子数组的首位元素” 对应的索引，因此考虑使用二分法查找 “右子数组的首位元素”。
         *      ·左子数组： nums[i] == i，数字与数组索引相等，则前半部分没有缺失，在右半部分查找
         *      ·右子数组： nums[i] != i，数字与数组索引不相等，则缺失数字在左半部分
         * ·复杂度：
         *      ·时间复杂度：O(logn)
         *      ·空间复杂度：O(1)
         * 算法流程
         * 1.首先初始化二分查找的左边界 left = 0，右边界 right = nums.length - 1
         * 2.当左边界不大于右边界时进行查找
         * 3.计算 mid = (left + right) / 2
         * 4.如果 nums[mid] == mid ，则缺失的元素，即右子数组的首位元素在 [mid + 1, right] 中间，令 left = mid + 1
         * 5.如果 nums[mid] != mid ，则缺失的元素，即右子数组的首位元素在 [left, mid - 1] 中间，令 right = mid - 1
         * @param nums
         * @return
         */
    public static int missingNumber_3(int[] nums){
        int left=0,right=nums.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] == mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }



        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();;
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        System.err.println(missingNumber_1(nums));
    }
}
