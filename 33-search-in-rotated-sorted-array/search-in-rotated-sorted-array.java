class Solution {
    // 1. Iska naam 'search' se badalkar 'findPivot' kiya aur 'n' ko define kiya
    public int findPivot(int[] nums) {
        int n = nums.length; 
        int s = 0; 
        int e = n - 1; 
        int ans = -1; 
        
        while (s <= e) {
            int mid = s + (e - s) / 2; 
            if (nums[mid] <= nums[n - 1]) {
                e = mid - 1; 
            } else {
                ans = mid; 
                s = mid + 1; 
            } 
        } 
        return ans; 
    } 

    // 2. Binary Search function (Spelling sahi hai)
    public int binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2; 
            if (nums[mid] == target) {
                return mid; 
            } 
            if (target > nums[mid]) {
                s = mid + 1; 
            } else {
                e = mid - 1; 
            } 
        } 
        return -1; 
    } 

    // 3. Main Search function jo LeetCode call karega
    public int search(int[] nums, int target) {
        int n = nums.length; 
        int pivot = findPivot(nums); 
        
        if (pivot == -1) {
            return binarySearch(nums, 0, n - 1, target); 
        } 
        
        // Agar target pivot par hi mil jaye
        if (nums[pivot] == target) {
            return pivot;
        }
        
        // Target ko sahi half mein search karne ka logic
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot, target);
        } else {
            return binarySearch(nums, pivot + 1, n - 1, target);
        }
    }
}