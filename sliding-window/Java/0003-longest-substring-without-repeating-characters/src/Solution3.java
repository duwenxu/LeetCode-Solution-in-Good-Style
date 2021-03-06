public class Solution3 {

    // 最基本的滑动窗口

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        // 描述 [left, right) 里是否有元素的变量
        int[] hashMap = new int[128];
        // [left, right) 无重复的元素
        int res = 1;
        for (int left = 0, right = 0; right < len; right++) {
            hashMap[charArray[right]]++;

            if (hashMap[charArray[right]] == 2) {
                while (hashMap[charArray[right]] == 2) {
                    hashMap[charArray[left]]--;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution3 solution3 = new Solution3();
        int res = solution3.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
