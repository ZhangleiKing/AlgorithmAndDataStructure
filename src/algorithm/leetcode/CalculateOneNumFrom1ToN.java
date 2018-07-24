package algorithm.leetcode;

/**
 * 计算从1到n中，数字k出现的次数（1<=k<=9）
 */
public class CalculateOneNumFrom1ToN {

    public static int solve(int n, int k) {
        int cur, remainder, i = 1;
        int ret = 0;
        while(true) {
            if(n / pow(i-1) ==0)
                break;
            remainder = n%pow(i);
            cur = remainder / pow(i-1);
            ret += (n/pow(i)) * pow(i-1);
            if(cur > k) {
                ret += pow(i-1);
            } else if(cur == k) {
                int low = getLow(remainder);
                if(i == 1) {
                    ret++;
                }else {
                    ret += (low+1);
                }
            }
            i++;
        }
        return ret;
    }

    private static int pow(int n) {
        int k = 1;
        while(n > 0) {
            k *= 10;
            n--;
        }
        return k;
    }

    private static int getLow(int n) {
        int cnt = 0, tmp = n;
        while(tmp > 0) {
            tmp /= 10;
            cnt++;
        }
        return n%pow(cnt-1);
    }

    public static void main(String[] args) {
        System.out.println(solve(3, 1));
    }
}
