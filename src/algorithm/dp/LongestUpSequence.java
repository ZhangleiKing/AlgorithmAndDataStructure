package algorithm.dp;

import java.util.Arrays;

/**
 * 最长不下降子序列(包括上升或持平)
 * n²的解法
 */
public class LongestUpSequence {

    public int solve(int[] nums) {
        int len = nums.length, max = 1;
        int[] dp = new int[len+1];//dp[i]表示前i个数字中的非下降子序列最大长度
        Arrays.fill(dp, 1);
        for(int i=2;i<=len;i++) {
            for(int j=i-1;j>0;j--) {
                //只有当前第i个数字大于之前的数字，并且之前发现的最长子序列的长度不得小于当前长度，则更新当前的dp[i];max为全局更新
                if (nums[i - 1] >= nums[j - 1] && dp[j]>=dp[i]) {
                    dp[i] = dp[j] + 1;
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,5,7,3};//答案为{4,6,7}
        System.out.println(new LongestUpSequence().solve(nums));
    }
}
