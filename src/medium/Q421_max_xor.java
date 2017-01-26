package medium;

import java.util.HashSet;
import java.util.Set;

public class Q421_max_xor {
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            System.out.println(i);
            System.out.println("mask="+mask);
            System.out.println("max="+max);
            System.out.println("tmp="+tmp);
            System.out.println("=======");
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 23, 20, 18, 28 };
        findMaximumXOR(nums);
    }

}
