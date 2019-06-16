import java.util.EmptyStackException;

public class SushiStack {
    private static final int EMPTY = -1;
    private Coordinates[] data;
    int used = 0;
    int topElement = EMPTY;
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Default constructor.
     */
    public SushiStack() {
        data =  new Coordinates[INITIAL_CAPACITY];
    }

    /**
     *
     * @param anElement Coordinate value for an entry.
     * @return pushed coordinate value.
     */
    public Coordinates pushElement(Coordinates anElement)
    {
        if(topElement == data.length - 1)
        {
            reallocate();
        }
        topElement++;
        data[topElement] = anElement;
        return anElement;
    }

    /**
     *
     * @return popped coordinate value.
     */
    public Coordinates pop()
    {
        if(empty())
        {
            throw new EmptyStackException();
        }
        return data[topElement--];
    }

    /**
     *
     * @return returns the list is empty or not.
     */
    public boolean empty()
    {
        if(topElement == EMPTY)
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
     * @return the top element. But does not pop.
     */
    public Coordinates peek()
    {
        if(empty())
        {
            throw new EmptyStackException();
        }
        return data[topElement];
    }

    /**
     * reallocate method for array.
     */
    private void reallocate()
    {
        int initialSize = data.length;
        Coordinates[] toCopy =  new Coordinates[2 * initialSize];
        System.arraycopy(data, 0, toCopy, 0, initialSize);
        data = toCopy;
    }
    @Override
    public String toString()
    {
        int stackSize = topElement;
        StringBuilder result = new StringBuilder();
        while(stackSize >= 0)
        {
            result.append("\n" + data[stackSize].toString() + "\n");
            stackSize--;
        }

        return result.toString();
    }


}
