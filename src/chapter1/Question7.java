package chapter1;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0 its entire row and column
 * are set to 0
 */
public class Question7 {


    public void resetMatrix(int[][] matrix)
    {
        // do an in place reset

        if(matrix == null)
        {
            return ;
        }
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        boolean[] rowReset = new boolean[rowSize];
        boolean[] colReset = new boolean[colSize];
        for(int rowIndex = 0 ; rowIndex < rowSize ; rowIndex++)
        {
            for(int colIndex = 0 ; colIndex < colSize ; colIndex++)
            {
                if(matrix[rowIndex][colIndex] == 0)
                {
                    rowReset[rowIndex] = true ;
                    colReset[colIndex] = true ;
                }
            }
        }

        for(int rowIndex = 0 ; rowIndex < rowSize ; rowIndex ++)
        {
            if(rowReset[rowIndex])
            {
                for(int colIndex = 0 ; colIndex < colSize ; colIndex++)
                {
                    matrix[rowIndex][colIndex] = 0;
                }
            }
        }

        for(int colIndex = 0 ; colIndex < colSize ; colIndex++)
        {
            if(colReset[colIndex ])
            {
                for(int rowIndex = 0 ; rowIndex < rowSize ; rowIndex++)
                {
                    matrix[rowIndex][colIndex]= 0;
                }
            }
        }
    }

}
