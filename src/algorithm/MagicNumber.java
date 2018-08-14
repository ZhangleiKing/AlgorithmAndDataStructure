package algorithm;

/**
 * Created by Vincent on 2018/7/27.
 */
public class MagicNumber {

    private void getEachNumberSum(int[] info, int n) {
        int sum = 0;
        int cnt = 0;
        while(n>0) {
            sum += (n % 10);
            n /= 10;
            cnt++;
        }
        info[0] = sum;
        info[1] = cnt;
    }

    public boolean check(int n) {
        int[] info = new int[2];
        getEachNumberSum(info, n);
        if(info[0]%2==1)
            return false;
        int[] nums = new int[info[1]];
        int tmp = n, i=0;
        while(tmp>0) {
            nums[i++] = tmp%10;
            tmp/=10;
        }
        int up = info[0]/2;
        boolean[] ok = new boolean[info[0]];
        for(int k=0,len=nums.length;k<len;k++) {
            ok[nums[k]] = true;
            for(int j=up;j>=0;j--) {
                if(ok[j] && j+nums[k]<=up) {
                    ok[j+nums[k]] = true;
                }
            }
            if(ok[up])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicNumber mn = new MagicNumber();
        System.out.println(mn.check(28));
    }
}
