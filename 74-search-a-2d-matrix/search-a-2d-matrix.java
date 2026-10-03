class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int totalRow = matrix.length;
        int totalCol = matrix[0].length;

        int n = totalRow * totalCol;
        
        int s = 0;
        int e = n-1;

        while( s <= e ) {
            int mid = s + ( e-s )/ 2;
            int rowIndex = mid/totalCol;
            int colIndex = mid%totalCol;

            if(matrix[rowIndex][colIndex] == target) {
                return true;
            }
            else if(matrix[rowIndex][colIndex] > target) {
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        return false;
        
    }
}