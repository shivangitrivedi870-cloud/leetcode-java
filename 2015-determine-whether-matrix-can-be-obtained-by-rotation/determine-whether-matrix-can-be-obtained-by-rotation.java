class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {


        int n = mat.length;

        for( int k =0; k<4; k++) {
            if ( Arrays.deepEquals(mat, target)){
                return true;
            }
        
        for( int i = 0; i<n; i++ ){
            for( int j = i+1; j < n; j++){

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                 mat[j][i] = temp;
            }
        }

        for(int row = 0; row<n; row++){

            int startCol = 0;
            int endCol = n-1;

            while( startCol <= endCol){

                int temp = mat [row][startCol];
                mat [row][startCol] = mat [row][endCol];
                mat [row][endCol]  = temp;

                startCol++;
                endCol--;

            }
        }
        }
        return false;
    }
}