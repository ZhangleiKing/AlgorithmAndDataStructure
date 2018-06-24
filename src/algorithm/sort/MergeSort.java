package algorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void sort(int[] nums, int l, int r) {
        if(l < r) {
            int mid = l+(r-l)/2;
            sort(nums, l, mid);
            sort(nums, mid+1, r);
            mergeSort(nums, l, mid, r);
        }
    }

    //用于将数组l~mid和mid+1~r两个区间内的数进行按序合并
    public static void mergeSort(int[] nums, int l, int mid, int r) {
        int[] A = new int[mid-l+1];
        int[] B = new int[r-mid];
        for(int i=l;i<=mid;i++)
            A[i-l] = nums[i];
        for(int i=mid+1;i<=r;i++)
            B[i-mid-1] = nums[i];
        int ax = 0, bx = 0, i=l;
        while(ax<A.length && bx<B.length) {
            if(A[ax]<B[bx])
                nums[i++] = A[ax++];
            else
                nums[i++] = B[bx++];
        }
        while(ax<A.length) {
            nums[i++] = A[ax++];
        }
        while(bx<B.length) {
            nums[i++] = B[bx++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,6,1,4,5};
        sort(nums, 0, nums.length-1);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
