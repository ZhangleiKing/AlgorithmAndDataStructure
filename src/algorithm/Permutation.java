package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * 对于给定的字符数组，输出其全排列
 * 递归求解
 */
public class Permutation {

    public static List<List<Character>> permutation(char[] chars) {
        List<List<Character>> ret = new ArrayList<>();
        recursive(ret, chars, 0);
        return ret;
    }

    public static void recursive(List<List<Character>> ret, char[] chars, int pos) {
        if(pos == chars.length-1) {
            List<Character> list = new ArrayList<>();
            for(Character c : chars) {
                list.add(c);
            }
            ret.add(list);
            return;
        }
        for(int i=pos;i<chars.length;i++) {
            if(canSwap(chars, pos, i)) {
                swap(chars, pos, i);
                recursive(ret, chars, pos+1);
                swap(chars, pos, i);
            }
        }
    }

    /**
     * 对于有重复字符的存在，需要判断当前是否有交换的必要
     * 举例：a,b,a,a,a
     * 当pos=1时，b首先和自己交换，然后和i=2的a交换，到i=3的a时，由于之前和i=2的a交换已经产生a,a前缀了，因此不用再和i=3的a交换了
     * @param chars
     * @param a
     * @param b
     * @return
     */
    public static boolean canSwap(char[] chars, int a, int b) {
        for(int i=a;i<b;i++) {
            if(chars[b]==chars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(char[] chars, int a, int b) {
        char c = chars[a];
        chars[a] = chars[b];
        chars[b] = c;
    }

    public static void main(String[] args) {
        int n=10;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }
}
