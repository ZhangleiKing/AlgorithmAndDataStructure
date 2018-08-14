package algorithm;

/**
 * Created by Vincent on 2018/7/27.
 */
public class QuickPow {

    public static int solve(int base, int pow) {
        int ret = 1;
        while(pow>0) {
            if(pow%2==1) {
                ret = ret*base;
            }
            base = base*base;
            pow = pow>>1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(QuickPow.solve(2,5));
    }
}
