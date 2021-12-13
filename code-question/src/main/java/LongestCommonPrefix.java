/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res = match(res, strs[i]);
			if (res.length() == 0) {
				break;
			}
		}
		return res;
	}
	
	private String match(String str1, String str2) {
		int length = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < length && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		return str1.substring(0, index);
	}
}
