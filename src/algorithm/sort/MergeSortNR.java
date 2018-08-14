package algorithm.sort;

/**
 * 归并排序，非递归版本
 * Created by Vincent on 2018/8/14.
 */
public class MergeSortNR {

    public static void mergeSortNR(int[] nums) {
        int k = 1, len = nums.length;
        while(k<len) {
            mergePass(nums, k, len);
            k*=2;
        }
    }

    /**
     * 将相邻的两个有K个元素的数组区间进行合并，因此步长为2K
     * @param nums
     * @param k
     * @param len
     */
    private static void mergePass(int[] nums, int k, int len) {
        int i = 0;
        while(i<len-k*2+1) {
            merge(nums, i, i+k-1, i+2*k-1);
            i+=k*2;
        }
        //将“落单的”不足2K的数组区间进行合并
        if(i<len-k) {
            merge(nums, i, i+k-1, len-1);
        }
    }

    /**
     * 负责将两个有序数组合并为一个
     * @param nums
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low, j = mid+1, k=0;
        while(i<=mid && j<=high) {
            if(nums[i]<=nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while(i<=mid) {
            temp[k++] = nums[i++];
        }
        while(j<=high) {
            temp[k++] = nums[j++];
        }
        for(int x=0;x<temp.length;x++) {
            nums[low+x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,0,2,5,4};
        mergeSortNR(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
