package algorithm.dfs;

import java.util.Arrays;

/**
 * Created by Vincent on 2018/6/27.
 * 给定一些数字，取若干数字加起来和为K
 * 求解有多少种不同的方式
 */
public class SumToK {
    public static void dfs(int[] nums, int left, int start, int[] ret) {
        if(left < 0)
            return;
        if(left == 0)
            ret[0]++;
        for(int i=start;i<nums.length;i++) {
            if(left>=nums[i]) {
                dfs(nums, left-nums[i], i+1, ret);
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,4,6,5};
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++)
            swap(nums, i, nums.length-1-i);
        int[] ret = new int[1];
        int target = 4;
        dfs(nums, target, 0, ret);
        System.out.println(ret[0]);
    }
}
