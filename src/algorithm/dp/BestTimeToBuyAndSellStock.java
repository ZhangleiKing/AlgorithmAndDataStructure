package algorithm.dp;

import java.util.Arrays;

/**
 * 买卖股票最大收益，有多种不同的条件限制
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 至多完成一次交易
     * @param prices
     * @return
     */
    public static int onceDeal(int[] prices) {
        int len = prices.length;
        if(len < 2)
            return 0;
        int cur_min = prices[0], cur_max_profit = 0;
        for(int i=1; i<len; i++) {
            if(prices[i] <= cur_min) {
                cur_min = prices[i];
            } else {
                cur_max_profit = Math.max(cur_max_profit, prices[i]-cur_min);
            }
        }
        return cur_max_profit;
    }

    /**
     * 不限制交易次数，求最大利润值
     * @param prices
     * @return
     */
    public static int anytimesDeal(int[] prices) {
        int len = prices.length;
        if(len < 2)
            return 0;
        boolean bought = false, sold = false;
        int min_buy = prices[0], max_sell = 0, ret = 0;
        for(int i=1; i<len; i++) {
            if(prices[i] <= min_buy && !bought) {
                min_buy = prices[i];
            }else if(prices[i] > min_buy && prices[i] >= max_sell) {
                bought = true;
                max_sell = prices[i];
            }else {
                ret += (max_sell-min_buy);
                bought = false;
                min_buy = prices[i];
                max_sell = 0;
            }
        }
        if(max_sell != 0)
            ret += (max_sell-min_buy);
        return ret;
    }

    /**
     * 至多K次交易能获取的最大的利润
     * @param prices
     * @param k
     * @return
     */
    public static int kTimesDeal(int[] prices, int k) {
        int len = prices.length;
        if(len < 2 || k < 1)
            return 0;

        int ret = 0;
        // 相当于不限次数
        if(k >= len/2) {
            for(int i=1;i<len;i++) {
                if(prices[i]>prices[i-1]) {
                    ret += (prices[i]-prices[i-1]);
                }
            }
            return ret;
        }

        int[] buy = new int[k+1]; //buy[i]表示完成第i次交易的买入动作时的最大利润
        int[] sell = new int[k+1]; //sell[i]表示完成第i次交易的卖出动作时的最大利润
        Arrays.fill(buy, Integer.MIN_VALUE);
        for(int i=0; i<len; i++) {
            for(int j=1; j<=k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j], buy[j]+prices[i]);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,6,5,0,3};
        System.out.println(kTimesDeal(nums, 2));
    }
}
