import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Popularity {
    Graph graph;
    private int numberOfPeople = 0;
    private int numberOfRelations = 0;
    private int relationArr[];
    private int adjMatrix[][];
    private int oneDimensionalAdjMatrix[];

    /**
     * Method that gets file content.
     * @throws FileNotFoundException if file is not specified in given path. File is in project folder in our case.
     * @throws IllegalArgumentException If the element has more that people numbers value, then it's illegal.
     */
    public void getFileContent() throws FileNotFoundException, IllegalArgumentException{
        int counter = 0;
        int arrayCounter = 0;
        Scanner reader = new Scanner(new File("input.txt"));
        while (reader.hasNext()){

            int i = reader.nextInt();
            if(counter == 0)
            {
                numberOfPeople = i;
            }
            if(counter == 1)
            {
                numberOfRelations = i;
                relationArr = new int[numberOfRelations * 2];
            }
            if(counter >= 2)
            {
                if(i == 0)
                {
                    throw new IllegalArgumentException("The node can't have zero value. Please satisfy with any number that different from zero.");
                }
                relationArr[arrayCounter] = i;
                arrayCounter++;
            }
            counter++;
        }
    }

    /**
     * Functions that creates graph into oneDimensonalMatrix.
     */
    public void createGraph(){
        int k = 0;
        Graph graph = new Graph(numberOfPeople);

        for(int i = 0,j = 0;  i < numberOfRelations ; ++i,j = j + 2)
        {

            graph.addEdge(relationArr[j], relationArr[j+1]);
        }

        graph.drawRelations();
        adjMatrix = new int[numberOfPeople][numberOfPeople];
        oneDimensionalAdjMatrix = new int[numberOfPeople*numberOfPeople];
        adjMatrix = graph.getAdjMatrix();
        for(int i = 0 ; i < numberOfPeople ; ++i)
        {
            for(int j = 0 ; j < numberOfPeople ; ++j)
            {
                oneDimensionalAdjMatrix[k] = adjMatrix[i][j];
                k++;
            }
        }
    }

    /**
     * Function that calculates the popular people.
     * @return popular people count.
     */
    public int calculatePopular()
    {
        int arr[] = new int[numberOfPeople];
        for(int i = 1 ; i <= numberOfPeople ; ++i)
        {
            arr[i-1] = i;
        }
        int reachNum = 0;
        int popularPerson = 0;
        int j = 0;
        for(int k = 0 ; k < arr.length; ++k)
        {
            for(int i = 0 ; i < numberOfPeople * numberOfPeople ; ++i)
            {

                if(arr[j] == oneDimensionalAdjMatrix[i])
                {
                    reachNum++;
                }

            }
            if(reachNum == arr.length)
            {
                popularPerson++;
            }
            reachNum = 0;
            j++;
        }
        return popularPerson;
        //System.out.println("Popular person count : " + popularPerson);
    }
}
