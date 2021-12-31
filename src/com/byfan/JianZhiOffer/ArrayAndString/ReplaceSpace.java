package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @Description: 替换字符串中的空格
 * @Author: byfan
 * @Date: 2021/12/27 10:13
 */

import java.util.Scanner;

/**
 * 题目描述
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 */
public class ReplaceSpace {
    /**
     * 解题方案
     * 思路
     * ·标签：字符串
     * ·最简单的方案自然是直接使用库函数啦！当然题目肯定是不希望我们这样做的！
     * ·增加一个新字符串，遍历原来的字符串，遍历过程中，如果非空格则将原来的字符直接拼接到新字符串中，如果遇到空格则将%20拼接到新字符串中
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     *
     * @param str
     * @return
     */
    public static String replaceSpace(String str){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if (c == ' '){
                        sb.append("%20");
                    }else {
                        sb.append(c);
                    }
            }
        return sb.toString();
    }

    /**
     * 使用库函数直接替换
     * @param str
     * @return
     */
    public static String replaceSpace_2(String str){
        return str.replace(" ","%20");
    }



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            System.err.println(replaceSpace(str));
        }
    }
