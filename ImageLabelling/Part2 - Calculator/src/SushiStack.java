import java.util.EmptyStackException;

public class SushiStack {
    private static final int EMPTY = -1;
    private String[] data;
    int used = 0;
    int topElement = EMPTY;
    private static final int INITIAL_CAPACITY = 10;

    /**
     * No parameter constructor.
     */
    public SushiStack() {
        data =  new String[INITIAL_CAPACITY];
    }

    /**
     *
     * @param anElement the element will be pushed.
     * @return String that pushed.
     */
    public String pushElement(String anElement)
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
     * pop element.
     * @return the popped element.
     */
    public String pop()
    {
        if(empty())
        {
            throw new EmptyStackException();
        }

        return data[topElement--];
    }

    /**
     *
     * @return true if empty.
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
     * @return the top element, but does not remove it.
     */
    public String peek()
    {
        if(empty())
        {
            throw new EmptyStackException();
        }
        return data[topElement];
    }

    /**
     * reallocates the array.
     */
    private void reallocate()
    {
        int initialSize = data.length;
        String[] toCopy =  new String[2 * initialSize];
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
