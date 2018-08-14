package algorithm.dp;

/**
 * 矩阵链乘，求取矩阵乘积运算次数最小的数值
 */
public class MatrixMultiplay {
    public int multiplay(int[] matrixRow, int[] matrixCol) {
        int len = matrixRow.length;
        int[][] dp = new int[len+1][len+1];
        for(int l=2;l<=len;l++) {  // 链的长度
            for(int i=1;i<=len-l+1;i++) { // 起点
                int j = i+l-1; // 终点
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+matrixRow[i-1]*matrixCol[k-1]*matrixCol[j-1]);
                }
            }
        }
        return dp[1][len];
    }

    public static void main(String[] args) {
        int[] rows = {30,35,15,5,10,20};
        int[] cols = {35,15,5,10,20,25};
        System.out.println(new MatrixMultiplay().multiplay(rows, cols));
    }
}
