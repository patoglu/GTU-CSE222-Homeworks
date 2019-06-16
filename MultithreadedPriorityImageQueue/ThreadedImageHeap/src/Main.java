import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(args[0]));
        BinaryHeap<MyImage> PQLEX = new BinaryHeap<MyImage>(new LEXComparator(), 3);
        BinaryHeap<MyImage> PQEUC = new BinaryHeap<MyImage>(new EUCComparator(), 3);
        BinaryHeap<MyImage> PQBMX = new BinaryHeap<MyImage>(new BMXComparator(), 3);
        int threadCounter = 0;
        MyImage firstByte = new MyImage(255,255,255);
        PQBMX.setMaxElem(firstByte);
        PQLEX.setMaxElem(firstByte);
        PQEUC.setMaxElem(firstByte);


        Thread1 firstThread = new Thread1();
        firstThread.setImage(bImage);
        firstThread.setPQBMX(PQBMX);
        firstThread.setPQEUC(PQEUC);
        firstThread.setPQLEX(PQLEX);

        firstThread.start();



    }







}

