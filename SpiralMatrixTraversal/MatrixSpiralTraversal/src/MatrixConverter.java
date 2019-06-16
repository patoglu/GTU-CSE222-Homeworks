import java.util.Iterator;

/**
 * Matrix converter that traverses the matrix in spiral way. Also implements iterable interface.
 */
public class MatrixConverter implements Iterable {

    private int x = 0; //static variable for keeping the array in one dimension.
    private int[][] matrix; // input matrix
    private int [] satelliteOutput; //output matrix.

    /**
     *
     * @param inputMatrix is a matrix coming from satellite
     * @param row row information of matrix
     * @param col col information of matrix
     */
    public MatrixConverter(int[][] inputMatrix, int row, int col)
    {
        satelliteOutput = new int[row * col];
        matrix = new int[row][col];
        for(int i = 0 ; i < row ; ++i)
        {
            for(int j = 0 ; j < col ; ++j)
            {
                matrix[i][j] = inputMatrix[i][j];
            }
        }
    }

    /**
     * Helper recursive function.
     * @param satelliteInput input matrix
     * @param r current row
     * @param colLimit collength
     * @param count index
     */
    private void helperRightRecursive(int satelliteInput[][], int r, int colLimit, int count)
    {
        if(count > colLimit)
        {
            return;
        }
        else
        {
            satelliteOutput[x] = matrix[r][count];
            //System.out.print(matrix[r][count]+ " ");
            x++;
            helperRightRecursive(matrix, r,colLimit,count+1);
        }
    }

    /**
     * Helper recursive function.
     * @param satelliteInput input matrix
     * @param r current row
     * @param rowLimit row length
     * @param colLimit col length
     * @param count index
     */
    private void helperDownRecursive(int satelliteInput[][], int r, int rowLimit,int colLimit, int count)
    {
        if(count > rowLimit)
        {
            return;
        }
        else
        {
            satelliteOutput[x] = matrix[count][colLimit];
            x++;
            //System.out.print(matrix[count][colLimit] + " ");
            helperDownRecursive(matrix, r, rowLimit, colLimit, count + 1);
        }
    }

    /**
     * Helper recursive function.
     * @param satelliteInput input matrix
     * @param r current row
     * @param rowLimit row length
     * @param colLimit col length
     * @param c current column
     * @param count index
     */
    private void helperLeftRecursive(int satelliteInput[][], int r, int rowLimit, int colLimit, int c, int count)
    {
        if(r+1 <= rowLimit){
            if(count < c)
            {
                return;
            }
            else
            {
                satelliteOutput[x] = matrix[rowLimit][count];
                x++;
               //System.out.print(matrix[rowLimit][count] + " ");
                helperLeftRecursive(matrix, r, rowLimit, colLimit, c, count -1);
            }
        }
    }

    /**
     * Helper recursive function.
     * @param satelliteInput input matrix
     * @param c current column
     * @param colLimit column length
     * @param rowLimit row length
     * @param r current row
     * @param count index
     */
    private void helperUpRecursive(int satelliteInput[][], int c, int colLimit, int rowLimit, int r, int count)
    {
        if(c+1 <= colLimit) {
            if (count <= r)
            {
                return;
            }
            else
            {

                satelliteOutput[x] = matrix[count][c];
                x++;
                //System.out.print(matrix[count][c] + " ");
                helperUpRecursive(matrix, c, colLimit, rowLimit, r, count - 1);
            }
        }

    }

    /**
     * Main recursive function, uses tail recursion.
     * @param satelliteInput input matrix
     * @param r current row
     * @param c current col
     * @param colLimit column length
     * @param rowLimit row length
     */
    private void satelliteOutput(int[][] satelliteInput, int r, int c, int colLimit,  int rowLimit){
        this.helperRightRecursive(satelliteInput, r, colLimit,c);
        this.helperDownRecursive(satelliteInput,r, rowLimit, colLimit,c + 1);
        this.helperLeftRecursive(satelliteInput, r, rowLimit, colLimit, c,colLimit - 1);
        this.helperUpRecursive(satelliteInput,c, colLimit, rowLimit, r,rowLimit - 1);

        if(r+1 > rowLimit-1 || c+1 > colLimit-1){

        }
        else
        {
            satelliteOutput(satelliteInput, r+1, c+1, colLimit-1, rowLimit-1);
        }
    }

    public void traverseMatrix()
    {

        if(matrix == null)
        {
            throw new NullPointerException("Please satisfy the input matrix.");
        }

        this.satelliteOutput(matrix,0,0,matrix[0].length-1,matrix.length-1);
        System.out.println();

    }

    /**
     *
     * @return an iterator over Java array
     */
    public Iterator<Integer> iterator()
    {

        return new Iterator<Integer>()
        {
            private int a = 0;

            /**
             *
             * @return true if element hasNext otherwise false.
             */
            public boolean hasNext()
            {
                if(matrix.length * matrix[0].length > a)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

            /**
             *
             * @return the next element.
             */
            public Integer next()
            {
                return satelliteOutput[a++];
            }

            /**
             * Not wanted in HW
             */
            public void remove()
            {
                throw new UnsupportedOperationException("Do not implement remove method");
            }

        };
    }

}
