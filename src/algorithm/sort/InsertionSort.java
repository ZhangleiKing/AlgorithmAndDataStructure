package algorithm.sort;

/**
 * 直接插入排序适合数据量小的情况
 */
public class InsertionSort {
    public static void sort(int[] nums) {
        int len = nums.length;
        if(len < 2)
            return;
        for(int i=1;i<len;i++) {
            int j, tmp=nums[i];
            for(j=i-1;j>-1;j--) {
                if(nums[j]<tmp) {
                    break;
                }
            }
            j++;//j为当前处理的tmp应该插入的位置下标
            //需要把从j开始、到i结束的数依次往后移动一位
            for(int k=i-1;k>=j;k--) {
                nums[k+1] = nums[k];
            }
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,2,4,3,3,6};
        sort(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
