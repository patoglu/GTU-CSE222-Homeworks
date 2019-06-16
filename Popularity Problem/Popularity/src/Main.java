
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Your file should have numbers that smaller or equal to number of people.
         */
        Popularity pop = new Popularity();
        pop.getFileContent();
        pop.createGraph();
        System.out.println(pop.calculatePopular());
    }
}
