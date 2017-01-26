package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/intersection-of-two-arrays-ii
//https://discuss.leetcode.com/topic/45920/ac-solution-using-java-hashmap
public class Q350_intersection_of_two_arrays {
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int num: nums1){
            cache.put(num,cache.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int num: nums2){
            if(cache.containsKey(num) && cache.get(num) >0){
                result.add(num);
                cache.put(num, cache.get(num)-1);
            }
        }
        int[] inter = new int[result.size()];
        for(int i=0; i< inter.length; i++){
            inter[i] = result.get(i);
        }
        return inter;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2,1};
        int[] b = {2,2};
        System.out.println(Arrays.toString(intersect(a, b)));
    }

}
