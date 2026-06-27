class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Hamesha chote array par binary search chalayein taaki complexity minimum rahe
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            // Agar partitionX 0 hai, matlab left side me koi element nahi hai (use -infinity manenge)
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            // Agar partitionX pure array ke barabar hai, matlab right side me koi element nahi hai (use +infinity manenge)
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            // Sahi partition mil gaya
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Agar total elements even hain
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else { // Agar total elements odd hain
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } 
            // Hum bohot right me hain, left shift karna hoga
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } 
            // Hum bohot left me hain, right shift karna hoga
            else {
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}