package algorithm.dp;

/**
 * 经典0-1背包问题
 * dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i])
 */
public class ZeroOnePackage {
    public int solve(int totalWeight, int[] weights, int[] values) {
        int num = weights.length;
        int[][] dp = new int[num+1][totalWeight+1];//dp[i][j]表示从前i个物品中挑选出能放入容量为j的背包得到的最大value值
        for(int i=0;i<num;i++) {
            dp[i][0] = 0;
        }
        for(int i=0;i<=totalWeight;i++) {
            dp[0][i] = 0;
        }
        for(int i=1;i<=num;i++) {
            for(int j=1;j<=totalWeight;j++) {
                //如果第i件物品太重，放不进容量为j的背包
                if(weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    //第i件物品要么不放入，要么放入，比较这两种情况的较大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[num][totalWeight];
    }

    public static void main(String[] args) {
        int[] weights = {3,5,2,6,4};
        int[] values = {4,4,3,5,3};
        int totalWeight = 12;
        System.out.println(new ZeroOnePackage().solve(totalWeight, weights, values));
    }
}
