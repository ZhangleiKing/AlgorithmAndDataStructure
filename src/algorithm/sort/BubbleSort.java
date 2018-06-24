package algorithm.sort;

/**
 * 冒泡排序，每次比较相邻的两个数，以此将最小(大)的数传递至前方，类似于水泡一样慢慢浮起来
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++) {
            for(int j=1;j<len-i;j++) {
                // 如果前者比后者大，则交换；因此可将最大值移动到最后
                if(nums[j-1] > nums[j]) {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,3,2,4};
        sort(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
