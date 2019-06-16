import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @param <E> Can be any type, Image in our case.
 */
public class BinaryHeap<E>
{
    Comparator<E>  comparator = null; //comparator reference.
    private E[] data; //Raw data object.
    private int size; //Size of data.
    private int capacity; //Capacity of data.

    private static final int ROOT = 1; //ROOT ele.


    @SuppressWarnings("unchecked")
    /**
     * One parameter constructor that sets the heap on specified size.
     */
    public BinaryHeap(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        data = (E[]) new Object[this.capacity + 1];

    }

    /**
     * Two parameter constructor that sets heap size and comparator.
     * @param comp is a Comparator object.
     * @param capacity is a capacity of heap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(Comparator<E> comp, int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        data = (E[])new Object[this.capacity + 1];
        comparator = comp;

    }

    /**
     * Gets the parent location of current position.
     * @param thePositon current position
     * @return parent position.
     */
    private int getParentLocation(int thePositon)
    {
        int position = thePositon / 2;
        return position;
    }

    /**
     * Gets the left child of parent
     * @param thePosition Parent location
     * @return Left child location
     */
    private int leftChild(int thePosition)
    {
        int position = 2 * thePosition;
        return position;
    }

    /**
     * Gets the right child of parent.
     * @param thePosition current position.
     * @return the right child position
     */
    private int rightChild(int thePosition)
    {
        return this.leftChild(thePosition) + 1;
    }

    /**
     * Sets the max element for first element.
     * @param max Any value that greater than 255,255,255(MAX Pixel values)
     */
    public void setMaxElem(E max)
    {
        data[0] = max;
    }

    /**
     * Checks if the specified position is leaf or not.
     * @param pos is the specified position/
     * @return true if leaf false otherwise.
     */
    private boolean isLeaf(int pos)
    {
        boolean inBound = false;
        boolean isLeaf = false;
        if(pos >= size / 2)
        {
            isLeaf = true;
        }
        if(pos <= size)
        {
            inBound = true;
        }
        if(inBound && isLeaf)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Simple swap function
     * @param firstPosition first parameter
     * @param secondPosition second parameter
     */
    private void swap(int firstPosition,int secondPosition)
    {
        E temp;
        temp = data[firstPosition];
        data[firstPosition] = data[secondPosition];
        data[secondPosition] = temp;
    }

    /**
     * Recursive function that updates the tree.
     * @param pos is the begining of heapify process.
     */
    private void heapify(int pos)
    {
        if (!isLeaf(pos))
        {
            if(compare(data[pos], data[leftChild(pos)]) < 0 || compare(data[pos], data[rightChild(pos)]) < 0)
            {

                if(compare(data[leftChild(pos)], data[rightChild(pos)]) > 0)
                {
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }
        }
    }

    /**
     * In order to grow the capacity of our heap.
     */
    private void reallocate()
    {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    /**
     *Adds the element into heap.
     *
     * @param element an Element, Image in our case.
     */
    public void add(E element)
    {
        synchronized (this) {
            int lastIndex;
            if(size + 1 >= capacity)
            {
                this.reallocate();
            }
            data[++size] = element;
            lastIndex = size;

            while(compare(data[lastIndex],data[getParentLocation(lastIndex)] ) > 0)
            {
                swap(lastIndex,getParentLocation(lastIndex));
                lastIndex = getParentLocation(lastIndex);
            }
            notify();
        }

    }

    /**
     * Returns if the list is empty or not.
     * @return true if the list is empty.
     */
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the max element but does not remove it.
     * @return the max element.
     */
    public E peek()
    {
        E max = data[ROOT];
        return max;
    }

    /**This method is synchronized in order to achieve multiple threading.
     * Returns the max element and removes it
     * @return the max element.
     */
    public E poll()
    {
        synchronized (this) {
            while(size == 0)
            {
                try {
                    wait();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
            E max = data[ROOT];

            if(size == 1)
            {
                size--;
                return max;
            }
            else
            {
                data[ROOT] = data[size--];
                heapify(ROOT);
            }
            notify();
            return max;

        }

    }

    /**
     * Compare method
     * @param left left Image data.
     * @param right right Image data.
     * @return comparison integer.
     */
    private int compare(E left, E right) {
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else { // Use left’s compareTo method.
            return ( (Comparable < E > ) left).compareTo(right);
        }
    }

    /**
     * Gets the heap size.
     * @return the size of heap.
     */
    public int getHeapSize()
    {
        return size;
    }


}