
public class MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //maintain a subarray that sums greater than s
        int left = 0;
        int right = 0;
        int sum = nums[0];
        
        //used to mark minimum subarray
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        
        while (right < nums.length) {
            //forward right only if current sum is less than s
            while (sum < s && right + 1 < nums.length) {
                sum += nums[++right];
            }
            if (sum >= s && right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
                end = right;
            }
            
            //forward left shinrk the size
            while (left < right && sum - nums[left] >= s) {
                sum -= nums[left++];
            }
            if (sum >= s && right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
                end = right;
            }
            right++;
            if (right < nums.length)
                sum += nums[right];
        }
        if (minLen != Integer.MAX_VALUE) {
            return end - start + 1;
        } else {
            return -1;
        }
    }
}
