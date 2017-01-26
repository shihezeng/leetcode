package easy;

public class Q371_sum_two_integers {
	public static int getSum(int a, int b) {
		int carry = 0;
		while (b != 0) {
			carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	public static int getSum2(int a, int b) {
		return b == 0 ? a : getSum2(a ^ b, (a & b) << 1);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.println(i + "+" + j + "=" + getSum(i, j) + ", "
						+ getSum2(i, j));
			}
		}
	}
}
