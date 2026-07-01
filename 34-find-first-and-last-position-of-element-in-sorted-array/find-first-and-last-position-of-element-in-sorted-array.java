class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    // First occurrence dhoodhne ke liye binary search
    private int findFirst(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1; // Agar bada ya barabar hai, toh left side dhoodho
            } else {
                low = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid; // Potential answer save karo
            }
        }
        return index;
    }

    // Last occurrence dhoodhne ke liye binary search
    private int findLast(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1; // Agar chota ya barabar hai, toh right side dhoodho
            } else {
                high = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid; // Potential answer save karo
            }
        }
        return index;
    }
}