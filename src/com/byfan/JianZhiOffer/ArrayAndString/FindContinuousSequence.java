package com.byfan.JianZhiOffer.ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 寻找连续序列
 * @Author: byfan
 * @Date: 2021/12/16 18:04
 */

/**
 * 题目描述
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence {

    /**
     * 解题方案
     * 思路
     * ·标签：滑动窗口、指针
     * ·整体思路：
     *      ·最容易想到的思路就是暴力枚举，因为题目条件要求至少含有两个数，所以枚举到 target/2 即可停止，时间复杂度较高
     *      ·更好的方式是使用滑动窗口，设立左右指针，从开始位置维护一个子数组作为窗口，判断该窗口是否求和为 target，如果是则将结果加入，如果小于 target 则窗口右移，大于 target 则窗口左移
     * ·复杂度：
     *      ·时间复杂度：O(target)。滑动窗口最多移动 target/2 次
     *      ·空间复杂度：O(1)。排除必要的存储结果数组之外，只需要保存左右指针
     * 算法流程
     * 1.首先初始化窗口，left=1 和 right=2
     * 2.当 left < right 时始终维护该窗口，只有当到达边界位置时，窗口和 sum > target，left 始终右移，才会结束窗口维护
     * 3.根据求和公式 sum = (left + right) * (right - left + 1) / 2sum=(left+right)∗(right−left+1)/2 可以直接算出滑动窗口和
     * 4.当 sum == target 时，将窗口放入结果数组中
     * 5.当 sum < target 时，说明窗口结果需要变大，right++
     * 6.当 sum > target 时，说明窗口结果需要变小，left++
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target){
        List<int[]> res = new ArrayList<>();
        int left = 1,right=2;
        while (left<right){
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target){
                int[] arr = new int[right-left+1];
                for (int i=0,j=left;j<=right;i++,j++){
                    arr[i] = j;
                }
                res.add(arr);
                left++;
            }
            else if(sum > target){
                left++;
            }
            else {
                right++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 思路：
     * 一个数的连续序列和，其中序列中最小的数绝对不超过该数的的一半，这样遍历时就可以把开始的数减少一半。
     * 从target/2开始进行遍历，作为起始数，然后继续下一个数字的累加。
     * 判断累加结果：等于目标数，则创建一个数组，长度为当前末位数减去起始数加一，然后把从起始数到末位数包括末位数遍历放入到数组。起始位加一重新遍历。
     *             小于目标数，末位数加一继续遍历。
     *             大于目标数，起始数加一重新遍历。
     *
     * 因为要求返回二维数组，而二维数组的长度是不确定的，内部的每一个一维数组的长度也是不确定的，所以每次初始化是一个List，然后每次得到满足条件的序列需要创建新得数组，将数组放进List中，最后返回时将List转换成二维数组即可。
     * @param target
     * @return
     */
    public static int[][] myFindContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int start = 1,end = 2;
        while (start <= target/2){
            int n = start;
            for (end = start+1;end<=target;end++){
                n += end;
                if (n == target){
                    int[] arr = new int[end-start+1];
                    for (int i=0,j=start; j<=end; i++,j++){
                        arr[i] = j;
                    }
                    res.add(arr);
                    start++;
                    break;
                }
                if (n > target){
                    start++;
                    break;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
//        int[][] continuousSequence = myFindContinuousSequence(target);
        int[][] continuousSequence = findContinuousSequence(target);
        for (int[] list : continuousSequence){
            for (Integer i : list){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
