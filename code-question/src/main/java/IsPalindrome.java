/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class IsPalindrome {
	
	/**
	 * 反转一半数字
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome1(int x) {
		String reversedStr = (new StringBuilder(x + "")).reverse().toString();
		return (x + "").equals(reversedStr);
	}
	
	/**
	 * 进阶解法---数学解法
	 *
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {
		if (x <= 0) {
			return false;
		}
		int div = 1;
		while (x / div > 10) {
			div *= 10;
		}
		while (x > 0) {
			int end = x % 10;
			int start = x / div;
			if (start != end) {
				return false;
			}
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	
	
	/**
	 * 对折
	 *
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome3(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int revertedNumber=0;
		while (x>revertedNumber){
			revertedNumber=revertedNumber*10+x%10;
			x/=10;
		}
		return x == revertedNumber || x == revertedNumber / 10;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome2(12321));
	}
}
