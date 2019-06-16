public class Thread3 extends Thread {
    public BinaryHeap<MyImage> getAnyQueue() {
        return anyQueue;
    }

    public void setAnyQueue(BinaryHeap<MyImage> anyQueue) {
        this.anyQueue = anyQueue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    BinaryHeap<MyImage> anyQueue;
    int size;


    public void run()
    {
        int i = 1;
        MyImage tempImage = new MyImage(0, 0, 0);
        while(i++ < size)
        {
            tempImage = anyQueue.poll();
            System.out.println("Thread3-PQEUC : [" + tempImage.getRed() + ", " + tempImage.getGreen() + ", "+ tempImage.getBlue() + "]");
        }
    }
}
