package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/intersection-of-two-arrays/
//https://discuss.leetcode.com/topic/45685/three-java-solutions/2
public class Q349_intersection_of_arrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> cache1 = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        for(int num: nums1){
            cache1.add(num);
        }
        for(int num: nums2){
            if(cache1.contains(num)){
                result.add(num);
            }
        }
        int[] intersect = new int[result.size()];
        int index=0;
        for(Integer num: result){
            intersect[index++]=num;
        }
        return intersect;
	}
	
	public static int[] intersection1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> intersect = new HashSet<Integer>();
		int i=0;
		int j=0;
		while(i<nums1.length && j<nums2.length){
			if(nums1[i] > nums2[j]){
				j++;
			}else if(nums1[i]< nums2[j]){
				i++;
			}else{
				intersect.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[intersect.size()];
		int index=0;
		for(Integer num: intersect){
			result[index++]=num;
		}
		return result;
	}
	
	public static int[] intersection2(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);
		Set<Integer> intersect = new HashSet<Integer>();
		for(int num: nums1){
			if(binarySearch(nums2, num)){
				intersect.add(num);
			}
		}
		int[] result = new int[intersect.size()];
		int index=0;
		for(Integer num: intersect){
			result[index++]=num;
		}
		return result;
	}
	
	public static boolean binarySearch(int[] reference, int target){
		int low = 0;
		int high = reference.length-1;
		int mid;
		while(low<high){
			mid=(low+high)/2;
			if(reference[mid]<target){
				low=mid+1;
			}else if(reference[mid]>target){
				high = mid-1;
			}else{
				return true;
			}
		}
		return false;
	}
	
	public static int[] intersection3(int[] nums1, int[] nums2) {
		Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
		return Arrays.stream(nums1).distinct().filter(e-> set.contains(e)).toArray();
	}
	
	public static void main(String[] args){
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] result = intersection(nums1, nums2);
		int[] result1 = intersection1(nums1.clone(), nums2.clone());
		int[] result2 = intersection2(nums1.clone(), nums2.clone());
		int[] result3 = intersection3(nums1.clone(), nums2.clone());
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result1));
		System.out.println(Arrays.toString(result2));
		System.out.println(Arrays.toString(result3));
	}
}
