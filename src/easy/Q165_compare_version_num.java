package easy;

public class Q165_compare_version_num {
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        String[] verarray1 = version1.split("\\.");
        String[] verarray2 = version2.split("\\.");
        int i = verarray1.length;
        int j = verarray2.length;
        int k = Math.max(i, j);
        int l = 0;
        int result = 0;
        while (result == 0 && l < k) {
            int a = l < i ? Integer.parseInt(verarray1[l]) : 0;
            int b = l < j ? Integer.parseInt(verarray2[l]) : 0;
            if (a > b) return 1;
            else if (a < b) return -1;
            l++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("01", "1"));
    }

}
