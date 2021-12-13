import java.util.Hashtable;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {
	
	/**
	 * 暴力枚举
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; ++i) {
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[0];
	}
	
	/**
	 * 哈希表
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> hashtable=new Hashtable<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashtable.containsKey(target-nums[i])){
				return new int[]{hashtable.get((target-nums[i])),i};
			}
			hashtable.put(nums[i],i);
		}
		
		return new int[0];
	}
}
