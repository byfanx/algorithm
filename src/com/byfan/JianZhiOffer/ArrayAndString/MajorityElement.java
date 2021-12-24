package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @Description: 寻找过半数字
 * @Author: byfan
 * @Date: 2021/12/21 21:48
 */

import java.util.*;

/**
 * 题目描述
 * 数组中一定有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 */
public class MajorityElement {

    // 排序法
    // 首先将 nums 排序，由于该数字超过数组长度的一半，所以数组的中间元素就是答案，时间复杂度为 O(nlogn)O(nlogn)
    public static int majorityElement_1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 哈希计数
    // 遍历 nums 数组，将数字作为key存在 HashMap 中，统计数字出现次数，
    // 统计完成后再遍历一次 HashMap，找到最大的value值，对应的key就是超过一半计数的数字，时间复杂度为 O(n)O(n)
    public static int majorityElement_2(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        Set<Integer> keys = map.keySet();
        int resKey = keys.iterator().next();
        for (Integer key : keys){
            if (map.get(key) > map.get(resKey)){
                resKey = key;
            }
        }
        return resKey;
    }

    // 摩尔投票（最优解）
    /* 思路：
     * 遍历 nums 数组，使用 count 进行计数，记录当前出现的数字为 cur，如果遍历到的 num 与 cur 相等，则 count 自增，否则自减，
     * 当其减为 0 时则将 cur 修改为当前遍历的 num，通过增减抵消的方式，最终达到剩下的数字是结果的效果，时间复杂度为 O(n)。空间复杂度 O(1)
     *
     * 算法流程：
     * 1.初始化：预期结果 cur = 0 和计数器 count = 0
     * 2.遍历数组 nums，遍历过程中取到的数字为 num
     * 3.当 count 为 0 时，表示不同的数字已经将当前的结果抵消掉了，可以换新的数字进行尝试，则 cur = num
     * 4.当 num == cur 时，表示遍历数字和预期结果相同，则计数器 count++
     * 5.当 num != cur 时，表示遍历数字和预期结果不同，则计数器 count--
     * 6.最终留下的数字 cur 就是最终的结果，出现次数超过一半的数字一定不会被抵消掉，最终得到了留存
     */
    public static int majorityElement_3(int[] nums){
        int cur=0,count=0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                cur = nums[i];
                count++;
            }
            else if (cur == nums[i])
                count++;
            else count--;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        System.err.println(majorityElement_2(nums));
    }
}
