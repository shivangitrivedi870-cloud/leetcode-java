class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>>result = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n-3; i++){

            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j =i+1; j<n-2; j++){
                
                if( j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

              int  L = j+1;
              int  R = n-1;

                while(L < R){

                    long sum = (long)nums[i]+nums[j]+nums[L]+nums[R];

                    if(sum == target){

                        result.add(Arrays.asList(nums[i], nums[j],nums[L], nums[R]));
 
                        while( L < R && nums[L] == nums[L+1]){
                            L++;
                        }
                        
                        while( L < R && nums[R] == nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }
                    else if (sum < target){
                        L++;
                    } else{
                        R--;
                    }
                }
            }


        }
        return result;

        
    }
}