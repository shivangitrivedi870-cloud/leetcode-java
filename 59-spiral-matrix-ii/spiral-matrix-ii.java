class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        
        while (top <= bottom && left <= right) {
            // 1. Left se Right fill karein (Top row)
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // Top row complete, boundary niche shift karein
            
            // 2. Top se Bottom fill karein (Right column)
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // Right col complete, boundary left shift karein
            
            // 3. Right se Left fill karein (Bottom row)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--; // Bottom row complete, boundary upar shift karein
            }
            
            // 4. Bottom se Top fill karein (Left column)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; // Left col complete, boundary right shift karein
            }
        }
        
        return matrix;
    }
}