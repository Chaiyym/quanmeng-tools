/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class Reverse {
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
				return 0;
			}
			//x的末尾
			int digit = x % 10;
			x /= 10;
			res = res * 10 + digit;
		}
		return res;
	}
}
