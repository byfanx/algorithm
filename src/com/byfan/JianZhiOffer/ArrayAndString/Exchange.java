package com.byfan.JianZhiOffer.ArrayAndString;

import java.util.Scanner;

/**
 * @Description: 数组奇偶排序
 * @Author: byfan
 * @Date: 2021/12/15 22:27
 */
/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 * 1.1 <= nums.length <= 50000
 * 2.1 <= nums[i] <= 10000
 *
 */

 public class Exchange {

     /*
      * 解题方案
      * 思路
      * ·标签：双指针
      * ·整体思路：首先指定前指针 left 和后指针 right，然后前指针定位偶数，后指针定位奇数，定位到之后将两个值互换，直到数组遍历完成
      * ·时间复杂度：O(n)，空间复杂度：O(1)
      * 算法流程
      * 1.初始化前指针 left = 0，后指针 right = nums.length - 1
      * 2.当 left < right 时表示该数组还未遍历完成，则继续进行奇数和偶数的交换
      * 3.当 nums[left] 为奇数时，则 left++，直到找到不为奇数的下标为止
      * 4.当 nums[right] 为偶数时，则 right--，直到找到不为偶数的下标为止
      * 5.交换 nums[left] 和 nums[right]，继续下一轮交换
      * 6.返回 nums，即为交换后的结果
      */
    public static int[] exchange(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right){
            while (left<right && (a[left]%2!=0)){
                left++;
            }
            while (left<right && (a[right]%2==0)){
                right--;
            }
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        return a;
    }


    public static int[] myExchange(int[] a) {
        int left = 0;
        int right = a.length-1;
        while (left<right){
            if (a[left] % 2 != 0){
                left ++;
                continue;
            }
            if (a[right] % 2 == 0){
                right--;
                continue;
            }
            int t = a[left];
            a[left] = a[right];
            a[right] = t;

        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }
        int[] b = exchange(a);
        for (int i : b){
            System.out.println(i);
        }
    }
}
