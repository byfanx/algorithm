package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @Description: 左旋转字符串
 * @Author: byfan
 * @Date: 2021/12/27 11:05
 */

import java.util.Scanner;

/**
 * 题目描述
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class ReverseLeftString {
    /**
     * 解题方案
     * 思路
     * ·标签：字符串遍历
     * ·整体思路：在原字符串处从需要反转的位置 n 开始向后遍历，并保存到结果字符串中，然后再从原字符串的初始位置遍历到位置 n，继续添加到结果字符串
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     * 算法流程
     * 1.初始化结果字符串sb，获取字符串长度 len
     * 2.从下标 n 开始遍历，遍历到字符串 s 结尾，将区间 [n, len] 的字符添加到 sb 中
     * 3.从下标 0 开始遍历，遍历到下标 n 位置，将区间 [0, n] 的字符添加到 sb 中
     *
     * @param str
     * @param k
     * @return
     */
    public static String reverseLeftString(String str,int k){
        StringBuilder sb = new StringBuilder();
        for (int i=k;i<str.length();i++){
            char c = str.charAt(i);
            sb.append(c);
        }
        for (int i=0; i<k; i++){
            char c = str.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        System.err.println(reverseLeftString(str,k));
    }
}
