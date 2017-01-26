package easy;

//https://leetcode.com/problems/nim-game/
public class Q291_nim_game {

	public static boolean canWinNim(int n) {
		return n % 4 != 0;
	}
	
	public static boolean canWinNim2(int n) {
		return (n & 3) != 0;
	}

	public static void main(String[] args) {
		System.out.println(canWinNim2(4));
	}

}
