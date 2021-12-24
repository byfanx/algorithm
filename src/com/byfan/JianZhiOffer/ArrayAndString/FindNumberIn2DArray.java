package com.byfan.JianZhiOffer.ArrayAndString;

/**
 * @Description: 从二维数组中查询
 * @Author: byfan
 * @Date: 2021/12/20 22:46
 */

import java.util.Scanner;

/**
 * 题目描述
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例：
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回 true。
 * 给定 target=20，返回 false。
 
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class FindNumberIn2DArray {
    /**
     * 解题方案
     * 思路
     * ·标签：数组遍历
     * ·从矩阵的左下角看，上方的数字都比其小，右方的数字都比其大，所以依据该规律去判断数字是否存在
     * ·设当前数字为 cur，目标数字为 target，当 target < cur 时，cur 更新为其上面的数字，
     * 当 target > cur 时，cur 更新为其右侧的数字，直到相等则返回 true，否则到了矩阵边界返回 false
     * ·时间复杂度：O(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArra(int[][] matrix, int target){
        if(matrix.length == 0)
            return false;

        int x = matrix.length-1,y = 0;
        while (x >= 0 && y < matrix[0].length){
            if (target > matrix[x][y]){
                y++;
            }else if (target < matrix[x][y]){
                x--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();
        System.out.println(findNumberIn2DArra(matrix,target));
    }
}
