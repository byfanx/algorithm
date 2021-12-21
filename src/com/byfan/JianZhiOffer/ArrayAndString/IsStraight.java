package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @Description: 判断数组是否是顺子
 * @Author: byfan
 * @Date: 2021/12/20 23:07
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
 * 2 ～ 10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1：
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2：
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * ·数组长度为 5
 * ·数组的数取值为 [0, 13]
 */
public class IsStraight {

    public static boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int zero_count = 0;
        int i = 0;
        for (;i<nums.length;i++){
            if (nums[i] > 0){
                break;
            }else if (nums[i] == 0){
                zero_count++;
            }
        }
        for (++i;i<nums.length;i++){
            if (nums[i] == nums[i-1]){
                return false;
            }
            zero_count -= (nums[i] - nums[i-1] - 1);
            if (zero_count < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i=0;i<nums.length;i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(isStraight(nums));
    }
}
