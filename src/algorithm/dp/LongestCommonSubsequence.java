package algorithm.dp;

/**
 * 求两字符串的最长公共子序列（不要求连续）
 */
public class LongestCommonSubsequence {

    private int lcs(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int len_a = ac.length, len_b = bc.length;
        if(len_a==0 || len_b==0)
            return 0;
        int[][] dp = new int[len_a+1][len_b+1];
        for(int i=1;i<=len_a;i++) {
            for(int j=1;j<=len_b;j++) {
                if(ac[i-1]==bc[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[len_a][len_b];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().lcs("abcbdab", "bdcaba"));
    }
}
