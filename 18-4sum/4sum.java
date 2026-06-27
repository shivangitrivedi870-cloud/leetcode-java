import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. सबसे पहले ऐरे को सॉर्ट करें
        Arrays.sort(nums);
        int n = nums.length;
        
        // 2. पहला फिक्स्ड पॉइंट (i)
        for (int i = 0; i < n - 3; i++) {
            // i के डुप्लिकेट्स को छोड़ें
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 3. दूसरा फिक्स्ड पॉइंट (j)
            for (int j = i + 1; j < n - 2; j++) {
                // j के डुप्लिकेट्स को छोड़ें
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // 4. टू-पॉइंटर अप्रोच (L और R)
                int L = j + 1;
                int R = n - 1;
                
                while (L < R) {
                    // Integer Overflow से बचने के लिए sum को long में कैलकुलेट करें
                    long sum = (long) nums[i] + nums[j] + nums[L] + nums[R];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        
                        // L के डुप्लिकेट्स को छोड़ें
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        // R के डुप्लिकेट्स को छोड़ें
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        
                        L++;
                        R--;
                    } else if (sum < target) {
                        L++; // सम छोटा है, तो लेफ्ट पॉइंटर बढ़ाएं
                    } else {
                        R--; // सम बड़ा है, तो राइट पॉइंटर घटाएं
                    }
                }
            }
        }
        
        return result;
    }
}