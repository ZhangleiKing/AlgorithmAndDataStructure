package algorithm.leetcode;

import java.util.Scanner;

public class PowerOfTwo {

    public static boolean isPowerofTwo(int n) {
        return (n>0) && ((n&(n-1))==0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(;;) {
            int a = in.nextInt();
            System.out.println(isPowerofTwo(a));
        }

    }
}
