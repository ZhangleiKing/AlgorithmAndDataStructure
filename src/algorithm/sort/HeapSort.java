package algorithm.sort;

/**
 * Created by Vincent on 2018/6/25.
 * 堆可用于实现优先队列，
 */
public class HeapSort {
    public static void sort(int[] nums, boolean big) {
        int len = nums.length;
        buildHeap(nums, big);
        if(!big) {
            for(int i=0;i<nums.length;i++) {
                System.out.println(deleteTop(nums, len--));
            }
        }else {
            for(int i=0;i<nums.length;i++) {
                System.out.println(deleteMaxTop(nums, len--));
            }
        }
    }

    /**
     * 构建堆（区分大顶堆、小顶堆）
     * @param nums
     * @param big
     */
    public static void buildHeap(int[] nums, boolean big) {
        if(!big) {
            //对于所有非叶子节点，将其与子节点比较，并采用将较大数据下沉的方式
            for(int len=nums.length, i=len/2-1;i>-1;i--) {
                shiftDown(nums, i, len);
            }
        } else {
            //对于所有的叶子结点，将其与父节点比较，使得较大数据上浮
            for(int size=nums.length, i=size-1;i>(size-2)/2;i--) {
                shiftUp(nums, i);
            }
        }
    }

    public static void shiftDown(int[] nums, int idx, int size) {
        int flag = 0, rc, sidx;
        //如果父节点大于子节点，则交换；使得大数下沉
        while((idx+1)*2-1<size && flag==0) {
            rc = (idx+1)*2;
            if(nums[idx] > nums[rc-1]) {
                sidx = rc-1;
            } else {
                sidx = idx;
            }
            if(rc < size) {
                if(nums[sidx] > nums[rc]) {
                    sidx = rc;
                }
            }
            if(sidx != idx) {
                swap(nums, idx, sidx);
                idx = sidx;
            } else {
                flag = 1;
            }
        }
        return;
    }

    public static void shiftUp(int[] nums, int idx) {
        int parent, flag = 0;
        //如果子节点大于父节点，则交换；使得大数上浮
        while(idx!=0 && flag==0) {
            parent = (idx-1)/2;
            if(nums[idx]>nums[parent]) {
                swap(nums, idx, parent);
                idx = parent;
            } else {
                flag = 1;
            }
        }
        return;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static int deleteTop(int[] nums, int size) {
        int ret = nums[0];
        nums[0] = nums[size-1];
        //交换后只需调整一次，因为次小值是原来最小值的子节点
        shiftDown(nums, 0, size-1);
        return ret;
    }

    public static int deleteMaxTop(int[] nums, int size) {
        int ret = nums[0];
        nums[0] = nums[size-1];
        size--;
        //交换后需要调整所有的节点
        for(int i=size-1;i>0;i--) {
            shiftUp(nums, i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,2,5,9,4,8,10,7,1};
        sort(nums, true);
    }
}

