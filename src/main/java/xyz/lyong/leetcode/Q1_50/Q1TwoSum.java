package xyz.lyong.leetcode.Q1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lvyong
 * @Desription
 * @Date 2019-10-31 11:08
 */

public class Q1TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        List<Integer> lessHalfList = new ArrayList<Integer>();
        List<Integer> greaterHalfList = new ArrayList<Integer>();
        List<Integer> halfList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++){
            //if (numbers[i] <= target){
            if (numbers[i] > target / 2){
                greaterHalfList.add(i);
            } else if (numbers[i] == target / 2){
                halfList.add(i);
            } else {
                lessHalfList.add(i);
            }
            //}
        }

        int isFinish = 0;
        for (int i = lessHalfList.size() - 1; i >= 0; i--){
            for (int j = 0; j <= greaterHalfList.size() - 1; j++){
                if (numbers[lessHalfList.get(i)] + numbers[greaterHalfList.get(j)] == target){
                    result[0] = lessHalfList.get(i);
                    result[1] = greaterHalfList.get(j);
                    isFinish = 1;
                    break;
                }
            }
            if (isFinish == 1){
                break;
            }
        }

        if (halfList.size() == 2){
            result[0] = halfList.get(0);
            result[1] = halfList.get(1);
        }

        return result;
    }
}
