package algorithm.sort;

/**
 * 快速排序，选择第一个值作为标准；左右指针分别向中间移动，以此可划分出两块区域（大于标准值和小于标准值）
 * 若数组原本为正序或逆序，则会产生快排最坏情况，可采用随机打乱、pivot利用随机数产生、或者三位取中
 * 若数组全部为相同的数，则可以考虑使用双路快排，避免等于标志位的数集中于某一边
 */
public class QuickSort {

    public static void sort(int[] nums, int l, int r) {
        if(l < r) {
            int mid = partition(nums, l, r);
            sort(nums, l, mid);
            sort(nums,mid+1, r);
        }
    }

    //每一趟遍历，保持左边的数不大于基准数；右边则为不小于
    public static int partition(int[] nums, int l, int r) {
        int tmp = nums[l];
        int idx = l;
        while(l < r) {
            while(l<r && nums[r]>=tmp) {
                r--;
            }
            while(l<r && nums[l]<=tmp) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, idx, l);
        return l;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,6,1,4,5};
        sort(nums, 0, nums.length-1);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
