import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public int InversePairs(int [] array) {
        int len = array.length;
        if(len<2) return 0;
        long ret = 0L;
        long[] tmp = new long[len];
        tmp[len-2] = array[len-2]>array[len-1]?1:0;
        for(int i=len-3;i>-1;i--) {
            if(array[i]>array[i+1]) {
                tmp[i]=tmp[i+1]+1;
                if(array[i]>array[len-1]) {
                    tmp[i] += 1;
                }
            }else if(array[i]==array[i+1]) {
                tmp[i]=tmp[i+1];
            }else {
                for(int k=i+2;k<len-1;k++) {
                    if(array[k]==array[i]) {
                        tmp[i] = tmp[k];
                        break;
                    }else if(array[k]< array[i]) {
                        tmp[i] = tmp[k]+1;
                        break;
                    }
                }
                if(array[i]>array[len-1]) {
                    tmp[i] += 1;
                }
            }
        }
        long m = 1000000007;
        for(int i=0;i<len-1;i++) {
            ret = (ret+tmp[i])%m;
        }

        return (int)(ret%m);
    }

    public static void main(String[] args) {

    }
}