package easy;

import java.util.HashMap;

public class Q013_roman_to_integer {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> units = new HashMap<Character, Integer>();
        units.put('I', 1);
        units.put('V', 5);
        units.put('X', 10);
        units.put('L', 50);
        units.put('C', 100);
        units.put('D', 500);
        units.put('M', 1000);

        char sIndex;
        int tmp;
        int sum = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sIndex = s.charAt(i);
            tmp = units.get(sIndex);
            if (tmp < prev) {
                sum -= tmp;
            } else {
                sum += tmp;
            }
            prev = tmp;
        }
        return sum;
    }

    public static int romanToInt2(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }

    public static int romanToInt3(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        char c;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = chars[i];
            switch (c) {
            case 'I':
                res += (res >= 5 ? -1 : 1);
                break;
            case 'V':
                res += 5;
                break;
            case 'X':
                res += 10 * (res >= 50 ? -1 : 1);
                break;
            case 'L':
                res += 50;
                break;
            case 'C':
                res += 100 * (res >= 500 ? -1 : 1);
                break;
            case 'D':
                res += 500;
                break;
            case 'M':
                res += 1000;
                break;
            default:
                throw new IllegalArgumentException();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
                "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
                "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII",
                "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV",
                "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
                "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
                "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C", "DI", "DL", "DXXX", "DCCVII",
                "DCCCXC", "MD", "MDCCC", "CM" };
        for (int i = 0; i < test.length; i++) {
            if ((romanToInt(test[i]) != romanToInt2(test[i])))
                System.out.println(test[i] + "=" + romanToInt(test[i]) + ","
                        + romanToInt2(test[i]));
        }
    }
}
