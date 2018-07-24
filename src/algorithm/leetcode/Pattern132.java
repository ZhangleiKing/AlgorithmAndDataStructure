package algorithm.leetcode;

import java.util.Stack;

/**
 * 在数组中找到a_i<a_k<a_j,且i<j<k
 */
public class Pattern132 {

    public static boolean solve(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for(int len=nums.length,i=len-1;i>-1;i--) {
            if(nums[i]<s3)
                return true;
            else {
                while(stack.size()>0 && nums[i]>stack.peek()) {
                    s3 = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5};
        System.out.println(solve(nums));
    }
}
