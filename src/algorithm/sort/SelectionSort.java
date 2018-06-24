package algorithm.sort;

/**
 * 选择排序，每一趟遍历，在未排序的数中选择最小(大)的数放入已排序的数末尾
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++) {
            int tmp = nums[i]; //记录当前需要调整的数
            int idx = i; //记录最小的数的下标
            for(int j=i+1;j<len;j++) {
                if(nums[j]<tmp) {
                    nums[i] = nums[j];
                    idx = j;
                }
            }
            nums[idx] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5};
        sort(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
