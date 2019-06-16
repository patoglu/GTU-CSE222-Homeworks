import java.io.*;
import java.util.Scanner;

public class LabelFinder {


    private int column;
    private int row;
    private String[][] map;
    private String[][] visitedCells;
    private SushiStack patogluStack;

    /**
     *
     * @param matrixFile file that contains matrix.
     * @throws IOException IOException
     */
    public LabelFinder(String matrixFile) throws IOException {
        this.getFileContents(matrixFile);
        visitedCells = new String[this.getRow()][this.getColumn()];
        for(int i = 0 ; i < this.getRow() ; ++i)
        {
            for(int j = 0 ; j < this.getColumn() ; ++j)
            {
                visitedCells[i][j] = String.valueOf('N');
            }
        }
    }

    /**
     *
     * @param matrixFile file that contains matrix.
     * @throws IOException IOException
     */
    public void getFileContents(String matrixFile) throws IOException
    {
        String fileName;
        fileName = matrixFile;
        Scanner scan = new Scanner(new File(fileName)); //provide file name from outside
        int rowCount = 0; //keep track of how many lines in the file
        int colCount = 0;
        while(scan.hasNextLine())
        {
            String line = new String(scan.nextLine());
            colCount = 0;
            for (String val: line.split(" "))
                colCount++;
            rowCount++;
        }

        scan.close();
        BufferedReader br = new BufferedReader(new FileReader("test_file_1.txt"));
        map = new String[rowCount][colCount];
        int j = 0;
        for (int i = 0; i < rowCount; i++) {
            String line = br.readLine();
            j = 0;
            //for (int j = 0; j < colCount; j++) {
            for (String val: line.split(" "))
            {
                map[i][j] = val;
                j++;
            }
        }
        column  = colCount;
        row = rowCount;


        br.close();
        //System.out.println(Arrays.deepToString(map));

    }

    /**
     *
     * @return the component count.
     */
    public int labelPixels()
    {
        int i,j;
        int components = 0;

        patogluStack = new SushiStack();
        Coordinates nearCoordinates;
        for(int a = 0 ; a < this.getRow() ; ++a)
        {
            for(int b = 0 ; b < this.getColumn() ; ++b)
            {
                if(map[a][b].equals("1"))
                {
                    components++;
                    map[a][b] = "X";
                    patogluStack.pushElement(new Coordinates(a,b));
                }

                while(!patogluStack.empty())
                {
                    Coordinates instanceCoordinate = new Coordinates();
                    instanceCoordinate = patogluStack.pop();
                    i = instanceCoordinate.getX();
                    j = instanceCoordinate.getY();
                    if(visitedCells[instanceCoordinate.getX()][instanceCoordinate.getY()].equals("N"))
                    {
                        visitedCells[i][j] = "V";
                        if(i+1 < this.getRow() && map[i+1][j] .equals("1") ) //down
                        {
                            if(visitedCells[i+1][j].equals("N"))
                            {
                                nearCoordinates = new Coordinates();
                                nearCoordinates.setX(i+1);
                                nearCoordinates.setY(j);
                                patogluStack.pushElement(nearCoordinates);
                                //visitedCells[i+1][j] = "V";
                                map[i+1][j] = "X";
                            }

                        }
                        if(i-1 >= 0 && map[i-1][j].equals("1")) //up
                        {
                            if(visitedCells[i-1][j].equals("N"))
                            {
                                nearCoordinates = new Coordinates();
                                nearCoordinates.setX(i-1);
                                nearCoordinates.setY(j);
                                patogluStack.pushElement(nearCoordinates);
                                //visitedCells[i-1][j] = "V";
                                map[i-1][j] = "X";
                            }
                        }
                        if(j+1 < this.getColumn() && map[i][j+1].equals("1")) // right
                        {
                            if(visitedCells[i][j+1].equals("N"))
                            {
                                nearCoordinates = new Coordinates();
                                nearCoordinates.setX(i);
                                nearCoordinates.setY(j+1);
                                patogluStack.pushElement(nearCoordinates);
                                //visitedCells[i][j+1] = "V";
                                map[i][j+1] = "X";
                            }
                        }
                        if(j-1 >= 0 && map[i][j-1].equals("1")) //left
                        {
                            if(visitedCells[i][j-1].equals("N"))
                            {
                                nearCoordinates = new Coordinates();
                                nearCoordinates.setX(i);
                                nearCoordinates.setY(j-1);
                                patogluStack.pushElement(nearCoordinates);
                                //visitedCells[i][j-1] = "V";
                                map[i][j-1] = "X";
                            }
                        }

                    }
                }
            }
        }

        return components;
    }

    /**
     *
     * @return Column of matrix.
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @return Row of matrix.
     */
    public int getRow() {
        return row;
    }
    @Override
    public String toString()
    {
        for (int i = 0 ; i < this.getRow() ; ++i)
        {
            for(int j = 0 ; j < this.getColumn() ; ++j)
            {
                System.out.print(this.map[i][j] +" ");
            }
            System.out.println();
        }
        String s = "The map has " + this.getRow() + " row and " + this.getColumn() +" column.";
        return s;
    }

}