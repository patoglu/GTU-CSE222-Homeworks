
import java.util.*;

public class sushiLL<E> implements Iterable<E>
{
    /**
     * Static class Node that holds data and nextNode.
     * @param <E> Any type. Edge in our case.
     */
    private static class Node<E>
    {
        private E data;
        private Node<E> nextNode;

        public Node(E data, Node<E> next)
        {
            this.nextNode = next;
            this.data = data;
        }
    }
    private Node<E> head;

    /**
     * No parameter constructor that initializes head to null.
     */
    public sushiLL()
    {
        head = null;
    }

    /**
     * Method that adds item to the head of LL
     * @param item is the item that will be added.
     */
    public void addFirst(E item)
    {
        head = new Node<E>(item, head);
    }

    /**
     * Iterator method that returns my iterator.
     * @return my iterator aka sushiLLIterator.
     */
    public Iterator<E> iterator()
    {
        return new sushiLLIterator();
    }

    /**
     * myIterator class.
     */
    private class sushiLLIterator  implements Iterator<E>
    {
        private Node<E> nextNode;

        /**
         * Initializes next node to head.
         */
        public sushiLLIterator()
        {
            nextNode = head;
        }

        /**
         * Overriding hasNext method.
         * @return if the element has next element or not.
         */
        public boolean hasNext()
        {
            return nextNode != null;
        }

        /**
         * Overriding next method
         * @return the next element
         */
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("No such element like that.");
            }
            E res = nextNode.data;
            nextNode = nextNode.nextNode;
            return res;
        }

        /**
         * Not supported.
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}