package algorithm.leetcode;

/**
 * 能否将数组分成两部分，使两部分的和相等
 * 本题采用dfs会超时，使用dp（类似01背包问题）
 */
public class PartitionEqualSubsetSum {

    public static boolean solve(int[] nums) {
        int len = nums.length, sum = 0;
        for(int i=0;i<len;i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        boolean[] dp = new boolean[sum/2+1]; // dp[i]表示可以从数组中选择数字组成得到和为i
        dp[0] = true;
        for(int i=0;i<len;i++) {
            for(int j=sum/2;j>=nums[i];j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum/2];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,5};
        System.out.println(solve(nums));
    }
}
