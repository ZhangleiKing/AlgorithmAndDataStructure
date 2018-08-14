package algorithm.dp;

import java.util.Scanner;

/**
 * 切割钢条,求如何切割能获取最大值
 */
public class CutRod {
    public int curRod(int[] lens, int[] vals, int l) {
        int[] dp = new int[l+1];
        int num = lens.length;
        for(int i=0; i<num; i++) {
            if(lens[i]<=l) {
                dp[lens[i]] = vals[i];
            }
        }
        for(int i=1;i<=l;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
            }
        }
        return dp[l];
    }

    public static void main(String[] args) {
        int[] lens = {1,2,3,4,5,6,7,8,9,10};
        int[] vals = {1,5,8,9,10,17,17,20,24,30};
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(new CutRod().curRod(lens, vals, n));
    }
}
