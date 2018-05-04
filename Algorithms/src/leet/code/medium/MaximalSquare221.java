package leet.code.medium;

public class MaximalSquare221 {

	public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int sq = Math.min(matrix.length, matrix[0].length);
        for(int ii = sq; ii > 0; ii--) {
            for(int jj = 0; jj < matrix.length; jj++) {
                for(int kk = 0; kk < matrix[0].length; kk++) {
                    if(matrix.length - jj < ii || matrix[0].length - kk < ii)
                        continue;
                    if(checksq(matrix, jj, kk, ii))
                        return ii*ii;
                }
            }
        }
        return 0;
    }
                    
                        
                        
    public static boolean checksq(char[][] matrix, int jj, int kk, int ii) {
        for(int j = jj; j < jj + ii && jj + ii <= matrix.length; j++) {
            for(int k = kk; k < kk + ii && kk + ii <= matrix[0].length; k++) {
                if(matrix[j][k] != 1) {
                    return false;
                }
            }
        }            
        return true;
    }
	public static void main(String[] args) {
		System.out.println(
			maximalSquare(new char[][]
			{
			  { 1, 0, 1, 0, 0},
			  { 1, 0, 1, 1, 1},
			  { 1, 1, 1, 1, 1},
			  { 1, 0, 0, 1, 0}
			}));

	}

}
