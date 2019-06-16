import java.awt.image.BufferedImage;

public class Thread1 extends Thread {
    BinaryHeap<MyImage> PQLEX;
    BinaryHeap<MyImage> PQBMX;
    BinaryHeap<MyImage> PQEUC;
    BufferedImage image;
    private final int CREATE_THREADS = 100;


    public BinaryHeap<MyImage> getPQLEX() {
        return PQLEX;
    }

    public void setPQLEX(BinaryHeap<MyImage> PQLEX) {
        this.PQLEX = PQLEX;
    }

    public BinaryHeap<MyImage> getPQBMX() {
        return PQBMX;
    }

    public void setPQBMX(BinaryHeap<MyImage> PQBMX) {
        this.PQBMX = PQBMX;
    }

    public BinaryHeap<MyImage> getPQEUC() {
        return PQEUC;
    }

    public void setPQEUC(BinaryHeap<MyImage> PQEUC) {
        this.PQEUC = PQEUC;
    }

    public BufferedImage getImage() {
        return image;
    }


    public Thread1()
    {

    }
    public void setImage(BufferedImage image)
    {
        this.image = image;
    }
    @Override
    public void run()
    {

        int threadCounter = 0;
        for(int i = 0 ; i < image.getWidth() ; ++i)
        {
            for(int j = 0 ; j < image.getHeight() ; ++j)
            {
                if(threadCounter == CREATE_THREADS)
                {
                    Thread2 secondThread = new Thread2();
                    secondThread.setSize(image.getWidth()*image.getHeight());
                    secondThread.setAnyQueue(PQLEX);
                    Thread3 thirdThread = new Thread3();
                    thirdThread.setSize(image.getWidth()*image.getHeight());
                    thirdThread.setAnyQueue(PQEUC);
                    Thread4 fourthThread = new Thread4();
                    fourthThread.setSize(image.getWidth()*image.getHeight());
                    fourthThread.setAnyQueue(PQBMX);

                    secondThread.start();
                    thirdThread.start();
                    fourthThread.start();

                }
                else
                {
                    int blue = image.getRGB(i, j) & 0xFF;
                    int green = (image.getRGB(i, j) >> 8) & 0xFF;
                    int red = (image.getRGB(i, j) >> 16) & 0xFF;
                    MyImage temp = new MyImage(red, green, blue);
                    PQLEX.add(temp);
                    PQEUC.add(temp);
                    PQBMX.add(temp);
                    System.out.println("Thread1 : [" + red + ", " + green + ", "+ blue + "]");
                }
                threadCounter++;
            }
        }
    }
}
