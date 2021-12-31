package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @Description: 翻转单词顺序
 * @Author: byfan
 * @Date: 2021/12/28 14:55
 */

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串 "I am a student. "，则输出 "student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 *
 * 示例 2：
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * ·无空格字符构成一个单词。
 * ·输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * ·如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWords {
    /**
     * 解题方案
     * 思路
     * ·标签：双指针
     * ·整体思路：先将开头和结尾处多余的空格去掉，从后向前遍历，通过前后指针锁定单词，跳过中间空格，最终将整个句子中的单词反转
     * ·时间复杂度：O(n)，空间复杂度：O(n)
     * 算法流程
     * 1.首先将原始字符串去掉开头和结尾的空格得到 tmp，便于之后直接从单词处理开始
     * 2.初始化单词起始位置 start 和单词结束位置 end 指针，位置在字符串结尾处
     * 3.初始化结果字符串 res 为空字符串
     * 4.当 start >= 0 时，说明字符串未遍历结束，作为循环条件
     * 5.在 tmp[start] 位置如果不为空格，说明还没有获取到完整的单词，则 start--
     * 6.获取到完整单词之后，截取 [start+1, end+1] 这一段字符串加入结果字符串中，因为是从后向前扫描单词的，所以可以直接加到res后面，通过空格连接
     * 7.在 tmp[start] 位置如果为空格，说明还没有到下一个单词的结尾位置，则 start--
     * 8.到单词结尾位置之后，end = start，往复进行上述流程，将单词全部反转
     * 9.将结果字符串 res 去掉开头和结尾多余的空格
     *
     * @param str
     * @return
     */
    public static String reverseWords(String str){
        String tmp = str.trim();
        int start = tmp.length()-1;
        int end = tmp.length()-1;
        String res = "";
        while (start >= 0){
            while (start>=0 && tmp.charAt(start)!=' '){
                start--;
            }
            res += tmp.substring(start+1,end+1) + " ";
            while (start>=0 && tmp.charAt(start)==' '){
                start--;
            }
            end = start;
        }
        return res.trim();
    }

    /**
     * 思路：
     * 遍历字符串，遍历完一个单词就把它加入到返回结果中。
     * 流程：
     * 1.初始化返回结果res=""和临时单词word=""，先去除字符串两端空格，然后依次遍历字符串中的字符。
     * 2.如果该字符不是空格，就添加到word后面。
     * 3.如果该字符是空格，证明至少扫描完一个单词，此时判断单词是否为空，如果不为空则加在返回结果res前面，中间用空格连接。之后继续遍历。
     * 4.遍历完字符串之后，再次判断单词word是否为空，不为空则加在res前面，中间用空格连接。
     * 5.最后将拼接好的字符串res去除两端空格返回即可。
     * @param str
     * @return
     */
    public static String MyreverseWords(String str){
        str = str.trim();
        String res = "";
        String word = "";
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c!=' '){
                word += c;
            }else if (!word.equals("")){
                res = word + " " + res;
                word = "";
            }
        }
        if (!word.equals("")){
            res = word + " " + res;
        }
        return res.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.err.println(reverseWords(str));
    }
}
