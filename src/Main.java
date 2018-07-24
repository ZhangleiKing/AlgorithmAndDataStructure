import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int pro = Integer.MAX_VALUE;
        int len = array.length;
        for(int i=0;i<len;i++) {
            if(binarySearch(array, sum-array[i])!=-1) {
                if(array[i]*(sum-array[i])<pro) {
                    ret.clear();
                    ret.add(array[i]);
                    ret.add(sum-array[i]);
                    pro = array[i]*(sum-array[i]);
                }
            }
        }
        return ret;
    }

    private int binarySearch(int[] array, int num) {
        int low=0, high=array.length-1, mid=low+(high-low)/2;
        while(low<=high) {
            mid = low+(high-low)/2;
            if(array[mid]<num) {
                low = mid+1;
            }else if(array[mid]==num) {
                return mid;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n==1) return 0;
        ArrayList<Integer> all = new ArrayList<>();
        for(int i=0;i<n;i++) {
            all.add(i);
        }
        int size = all.size();
        int start = 0;
        while(size>1) {
            start += m;
            int idx = start>size ? start%size==0 ? size-1 : start%size-1 : start-1;
            all.remove(idx);
            size = all.size();
            start = idx==size?0:idx;
        }
        return all.get(0);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null || pHead.next==null)
            return null;
        ListNode start = new ListNode(-1);
        start.next = pHead;
        ListNode slow = pHead, fast = pHead;
        while(fast != null) {
            if(fast.next==null || fast.next.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }
        slow = pHead;
        while(slow!=fast) {
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

    public  static void main(String[] args) {
        Main m = new Main();
        ListNode l1 = m.new ListNode(1);
        ListNode l2 = m.new ListNode(2);
        ListNode l3 = m.new ListNode(3);
        ListNode l4 = m.new ListNode(4);
        ListNode l5 = m.new ListNode(5);
        ListNode l6 = m.new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l3;
        System.out.println(m.EntryNodeOfLoop(l1).val);
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}