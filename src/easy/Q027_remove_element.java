package easy;

public class Q027_remove_element {
    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left < nums.length && nums[left] != val) {
                left++;
            } else if (right >= 0 && nums[right] == val) {
                right--;
            } else {
                nums[left] = nums[right];
                left++;
                right--;
            }
        }
        return left;
    }

    public static int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;

    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 2, 2, 3 };
        // removeElement(array, 3);
        System.out.println(removeElement(array, 1));
    }
}
