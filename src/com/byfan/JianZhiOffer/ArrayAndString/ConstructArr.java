package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @File: ConstructArr.java.java
 * @Description: 构建数组
 * @Author: byfan
 * @Date: 2021/12/14 22:35
 */

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class ConstructArr {

    /*
     * 解题方案
     * 思路
     * ·标签：数组遍历
     * ·整体思路：
     *      ·这道题如果可以使用除法，那么就很简单了，先求出来所有数的乘积，然后再依次除掉每个对应的值即可
     *      ·不让使用除法，那么最简单的思路就是将B[i]每个位置都把所有需要的数乘一遍，但是这样的时间复杂度非常高
     *      ·降低时间复杂度的方式就是以A[i]为界线，分割出左右三角形，其中每个三角形从尖部到底部都是可以累积的，这样就可以减少时间复杂度（具体见画）
     * ·复杂度：
     *      ·时间复杂度：O(n)。因为左右三角遍历求乘积的时间复杂度都是O(n)
     *      ·空间复杂度：O(1)。不将结果数组算入的话，只需要常量的空间复杂度
     * 算法流程
     * 1.首先申请结果数组 res
     * 2.求出左侧三角从上到下的值，依次存入 res[i] 中
     * 3.求出右侧三角从下到上的值，并且和之前的 res[i] 做乘积存入，即可得到结果
     */
    public static int[] constructArr(int[] a){
        int[] res = new int[a.length];
        // 从上到下计算左下三角  见constructArr_1.jpeg
        int left = 1;
        for (int i=0; i<a.length; i++){
            res[i] = left;
            left *= a[i];
        }
        // 从下到上计算右上三角  见constructArr_2.jpeg
        int right = 1;
        for (int i= a.length-1; i>=0; i--){
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = scanner.nextInt();
        }
        int[] b = constructArr(a);
        for (int i : b){
            System.out.println(i);
        }
    }
}
