import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static File file;

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "test_file_1.txt";
        if(args.length > 0)
        {
            fileName = (args[0]);
        }
        else
        {
            throw new FileNotFoundException("File not found!!!");
        }
        try
        {
            LabelFinder test = new LabelFinder(fileName);
            int labelCount = test.labelPixels();
            System.out.println("There are " +labelCount+ " labels in your matrix!");
        }
        catch (IOException ex)
        {
            System.out.println("Whoops. IOException.");
        }
    }
}
