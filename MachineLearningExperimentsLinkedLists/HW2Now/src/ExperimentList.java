import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ExperimentList implements Iterable {
    /**
     * No parameter ExperimentList constructor
     */
    ExperimentList() {
        head = null;
        size = 0;
    }


    private Node head = null;
    private int size;

    /**
     * Method that returns head of the list
     * @return Head of the list.
     */
    public Node getHead() {
        return head;
    }

    /**
     *Method that sets head of the list.
     * @param theHead is head of another list.
     */
    public void setHead(Node theHead)
    {
        head = theHead;
    }

    /**
     * Class Node for more pure implementation.
     */
    public static class Node {
        Experiment experiment;
        Node nextExperiment;
        Node nextDay;

        /**
         * Node class constructor
         * @param theExperiment is the single Experiment data.
         */
        private Node(Experiment theExperiment) {
            experiment = theExperiment;
            nextExperiment = null;
            nextDay = null;
        }

        /**
         * Node class two parameter constructor.
         * @param theExperiment is the single Experiment data.
         * @param theNextExperiment is next node as parameter.
         */
        private Node(Experiment theExperiment, Node theNextExperiment) {
            experiment = theExperiment;
            nextExperiment = theNextExperiment;
            nextDay = null;
        }

        /**
         * Node class three parameter constructor.
         * @param theExperiment is the single Experiment data.
         * @param theNextExperiment is next node as parameter.
         * @param theNextDay is next Day node as parameter.
         */
        private Node(Experiment theExperiment, Node theNextExperiment, Node theNextDay) {
            experiment = theExperiment;
            nextExperiment = theNextExperiment;
            theNextDay = theNextDay;
        }

        /**
         *
         * @return a String.
         *Node class' toString override.
         */
        @Override
        public String toString() {
            return experiment.toString();
        }
    }

    /**
     * Method that adds an Experiment to front of list.
     * @param anExperiment is a Experiment data.
     */
    public void addFirst(Experiment anExperiment) {
        head = new Node(anExperiment, head);
        size++;
    }

    /**
     *
     * @param node Is a node the data will be placed after it.
     * @param anExperiment is a data to be placed.
     */
    public void addAfter(Node node, Experiment anExperiment) {
        node.nextExperiment = new Node(anExperiment, node.nextExperiment);
        size++;
    }

    /**
     *toString method in our book.
     * @return String
     */
    public String toString() {
        Node nodeRef = head;
        StringBuilder result = new StringBuilder();
        while (nodeRef != null) {
            result.append(nodeRef.experiment);
            nodeRef = nodeRef.nextExperiment;
        }
        return result.toString();
    }

    /**
     *
     * @param index as a value starting from 0.
     * @return a specified Node.
     */
    public Node getNode(int index) {
        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException("OOB");
        }
        Node node = head;
        for (int i = 0; i < index && node != null; ++i) {
            node = node.nextExperiment;
        }
        return node;
    }

    /**
     * Helper method that finds LastDay of a specified day value.
     * @param firstDay is a firstDay.
     * @param anExperiment is a data.
     * @return Last day's location.
     */
    public int findLastDay(int firstDay, Experiment anExperiment) {
        int index = 0;
        Node node = getNode(firstDay - 1);
        while (node.nextExperiment != null && node.experiment.getDay() == anExperiment.getDay()) {
            index++;
            node = node.nextExperiment;
        }
        return index;

    }

    /**
     * Helper method that finds the first day of specified day value.
     * @param anExperiment is a data.
     * @return the index of firstDay
     */
    public int findFirstDay(Experiment anExperiment) {
        int index = 0;
        int paramDay = anExperiment.getDay();
        Node temp = head;
        while (temp.nextExperiment != null) {
            index++;
            if (temp.experiment.getDay() == paramDay) {
                return index;
            }
            temp = temp.nextExperiment;
        }
        return index;
    }

    /**
     *
     * @param index is the specified index value.
     * @return the Experiment data.
     */
    public Experiment get(int index) {
        Node node = getNode(index);
        return node.experiment;
    }

    /**
     *
     * @param index is the specified index value
     * @param anExperiment is an Experiment to be placed.
     * @return returns the placed Experiment data.
     */
    public Experiment set(int index, Experiment anExperiment) {
        Node node = getNode(index);
        Experiment result = node.experiment;
        node.experiment = anExperiment;
        return result;
    }

    /**
     *
     * @param anExperiment is anExperiment that will be added.
     */
    public void addExp(Experiment anExperiment) {
        int index;
        if (size == 0) {
            addFirst(anExperiment);

        } else {
            Node temp = getNode(size - 1);
            if (temp.experiment.getDay() <= anExperiment.getDay()) {
                addAfter(temp, anExperiment);
            } else {
                index = findFirstDay(anExperiment);
                index = findLastDay(index, anExperiment);
                Node node = getNode(index - 1);
                addAfter(node, anExperiment);
            }
        }
        //index = findLastDay(anExperiment);
        //Node node = getNode(index);
        //addAfter(node, anExperiment);
    }

    /**
     *
     * @param theDay is the specified day value.
     * @param index is the index where we'll get Experiment data.
     * @return the specified Experiment value.
     */
    public Experiment getExp(int theDay, int index) {
        Node search = head;
        while (search.nextExperiment != null) {
            if ((search.experiment.getDay() == theDay)) {
                Node newNode = search;
                for (int i = 0; i < index - 1 && search.nextExperiment != null; ++i) {
                    search = search.nextExperiment;
                }
                if (search.experiment.getDay() != newNode.experiment.getDay()) {
                    throw new Error("There is no such day with specified index!!!");
                } else {
                    return search.experiment;
                }

            }
            search = search.nextExperiment;
        }
        return search.experiment;
    }

    /**
     *
     * @param theDay specified day value to store Experiment place
     * @param index the index of day.
     * @param anExperiment anExperiment that will be added.
     */
    public void setExp(int theDay, int index, Experiment anExperiment) {
        Node search = head;
        while (search.nextExperiment != null) {
            if ((search.experiment.getDay() == theDay)) {
                Node newNode = search;
                for (int i = 0; i < index - 1 && search.nextExperiment != null; ++i) {
                    search = search.nextExperiment;
                }
                if (search.experiment.getDay() != newNode.experiment.getDay()) {
                    throw new Error("There is no such day with specified index!!!");
                } else {
                    search.experiment = anExperiment;
                    break;
                }

            }
            search = search.nextExperiment;
        }
    }

    /**
     *
     * @param node that will be deleted after it.
     */
    private void removeAfter(Node node) {
        Node temp = node.nextExperiment;
        if (temp != null) {
            node.nextExperiment = temp.nextExperiment;
            size--;
        } else {
            throw new NoSuchElementException("No such element!!!");
        }
    }

    /**
     * Helper method that deletes the last node.
     */
    private void deleteLastNode() {
        Node temp = head;
        Node t = null;
        while (temp.nextExperiment != null) {
            t = temp;
            temp = temp.nextExperiment;
        }
        t.nextExperiment = null;
    }

    /**
     * Helper method that removes the first item.
     */
    private void removeFirst() {
        Node temp = head;
        if (head != null) {
            head = head.nextExperiment;
        }
        if (temp != null) {
            size--;
        } else {
            throw new NoSuchElementException("No such element!!!");
        }
    }

    /**
     * Helper method that removes the all of specified day values.
     * @param day is the specified day value.
     */
    public void removeDay(int day) {
        Node iterator = head;
        int headDay = head.experiment.getDay();

        if (day == headDay) {
            Node tempHead = head;
            while (tempHead.experiment.getDay() == headDay) {
                removeFirst();
                tempHead = tempHead.nextExperiment;
            }
        } else {
            int index = 0;
            int lastIndex;
            Experiment tempExperiment = new Experiment(day, "temp");
            index = findFirstDay(tempExperiment);
            lastIndex = findLastDay(index, tempExperiment);
            index = index - 1;


            Node deleteNode = getNode(index - 1);
            while (lastIndex > 0) {
                lastIndex--;
                removeAfter(deleteNode);
            }
            while (iterator.nextExperiment != null) {
                iterator = iterator.nextExperiment;
            }
            if (iterator.experiment.getDay() == day) {
                this.deleteLastNode();
            }

        }
    }

    /**
     *removes an experiment at specified day and index.
     * @param day is the day value which will be deleted.
     * @param index is the index value of day.
     */
    public void removeExp(int day, int index) {
        Node iterator = head;
        int lastDay;

        Experiment tempExperiment = new Experiment(day, "Temp");
        while (iterator.nextExperiment != null) {
            iterator = iterator.nextExperiment;
        }
        //Found day value at last node.
        lastDay = iterator.experiment.getDay();
        int f = this.findFirstDay(tempExperiment);
        int l = this.findLastDay(f, tempExperiment);
        if (day == 1 && index == 0) {
            removeFirst();
        } else if (day == lastDay && f + index == size) {
            this.deleteLastNode();
        } else {
            int firstDay = findFirstDay(tempExperiment);
            Node firstDayNode = getNode(firstDay - 2 + index);
            removeAfter(firstDayNode);
        }
    }

    /**
     *lists all completed experiments in given day.
     * @param theDay is the day value that will be listed.
     */
    public void listExp(int theDay) {
        Node temp = head;
        System.out.println("Sorting completed ones");
        while (temp.nextExperiment != null) {
            if (temp.experiment.isCompleted() == true && temp.experiment.getDay() == theDay) {
                System.out.println(temp);

            }
            temp = temp.nextExperiment;
        }
    }

    /**
     *
     * @return Node as head of sorted list.
     */

    public Node orderExperiments() {
        /*int i = 0;
        Node temp = head;
        Experiment[] experimentListArr = new Experiment[this.size];

        while (temp.nextExperiment != null) {
            Experiment anExperiment = new Experiment();
            anExperiment.setCompleted(temp.experiment.isCompleted());
            anExperiment.setDay(temp.experiment.getDay());
            anExperiment.setSetup(temp.experiment.getSetup());
            anExperiment.setAccuracy(temp.experiment.getAccuracy());
            anExperiment.setTime(temp.experiment.getTime());
            experimentListArr[i] = anExperiment;
            i++;
            temp = temp.nextExperiment;
        }
        Experiment anExperiment = new Experiment();
        anExperiment.setCompleted(temp.experiment.isCompleted());
        anExperiment.setDay(temp.experiment.getDay());
        anExperiment.setSetup(temp.experiment.getSetup());
        anExperiment.setAccuracy(temp.experiment.getAccuracy());
        anExperiment.setTime(temp.experiment.getTime());
        experimentListArr[i] = anExperiment;


        System.out.println("Printing whole array againnnn");
        /*for (i = 0; i < size; ++i) {
            System.out.println(experimentListArr[i]);

        }*/
        Node temp = head;
        Node sortedList = mergeSort(temp);
        return sortedList;
    }

    /**NOTE!!! THIS FUNCTION NOT IMPLEMENTED AS YOU WANTED.
     * MY IMPLEMENTATION ONLY SHOWS THE SORTED DAY'S ACCORDING
     * TO THEIR ACCURACIES. THEREFORE I CAN'T UPDATE ORIGINAL
     * LIST.
     *
     *
     *
     * @param theDay is theDay value to be sorted inside list.
     */
    public void orderDay(int theDay)
    {
        Experiment anExperiment = new Experiment();
        anExperiment.setDay(theDay);
        int startOfDay = findFirstDay(anExperiment);
        int endOfDay = findLastDay(startOfDay, anExperiment);
        endOfDay = startOfDay + endOfDay;
        int j = 0;
        Experiment[] experimentListArr = new Experiment[endOfDay - startOfDay];
        for(int i = startOfDay ; i < endOfDay ; ++i)
        {

            Experiment anExp = new Experiment();
            anExp.setCompleted(getNode(i).experiment.isCompleted());
            anExp.setDay((getNode(i).experiment.getDay()));
            anExp.setSetup((getNode(i).experiment.getSetup()));
            anExp.setAccuracy(getNode(i).experiment.getAccuracy());
            anExp.setTime(getNode(i).experiment.getTime());
            experimentListArr[j] = anExp;
            j++;
        }
        for(int i = 0 ; i < experimentListArr.length - 1 ; ++i)
        {
            for (j = 0 ; i < experimentListArr.length - 1 ;++i)
            {
                if(experimentListArr[j].getAccuracy() < experimentListArr[j+1].getAccuracy())
                {
                    Experiment tempExp = new Experiment();
                    tempExp.setDay(experimentListArr[j].getDay());
                    tempExp.setCompleted(experimentListArr[j].isCompleted());
                    tempExp.setTime(experimentListArr[j].getTime());
                    tempExp.setSetup(experimentListArr[j].getSetup());
                    tempExp.setAccuracy(experimentListArr[j].getAccuracy());
                    experimentListArr[j].setAccuracy(experimentListArr[j+1].getAccuracy());
                    experimentListArr[j].setSetup(experimentListArr[j+1].getSetup());
                    experimentListArr[j].setTime(experimentListArr[j+1].getTime());
                    experimentListArr[j].setCompleted(experimentListArr[j+1].isCompleted());
                    experimentListArr[j].setDay(experimentListArr[j+1].getDay());

                    experimentListArr[j+1].setAccuracy(tempExp.getAccuracy());
                    experimentListArr[j+1].setSetup(tempExp.getSetup());
                    experimentListArr[j+1].setTime(tempExp.getTime());
                    experimentListArr[j+1].setCompleted(tempExp.isCompleted());
                    experimentListArr[j+1].setDay(tempExp.getDay());
                }
            }
        }
        for(int i = 0 ; i < experimentListArr.length - 1 ; ++i)
        {
            System.out.println(experimentListArr[i]);
        }
    }
    /**Helper method.
     *Sorting list with recursive Merge Sort method.
     * @param head is head of our list.
     * @return the sorted another head;
     */
    private Node mergeSort(Node head) {
        if ( head.nextExperiment == null || head == null ) {
            return head;
        }

        Node middle = middleElement(head);
        Node nextofMiddle = middle.nextExperiment;
        middle.nextExperiment = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextofMiddle);

        Node sort = merge(left, right);

        return sort;
    }

    /**
     * Helper method for recursive mergesort/.
     * @param leftExperiment is the leftSide of recursive sum
     * @param rightExperiment is the rightSide of recursive Sum
     * @return Operated Node value.
     */
    private Node merge(Node leftExperiment, Node rightExperiment) {
        Node tempExp = null;
        if (leftExperiment == null) {
            return rightExperiment;
        }
        if (rightExperiment == null) {
            return leftExperiment;
        }
        if (leftExperiment.experiment.getDay() < rightExperiment.experiment.getDay()) {
            tempExp= leftExperiment;
            tempExp.nextExperiment = merge(leftExperiment.nextExperiment, rightExperiment);
        }
        else
        {
            tempExp = rightExperiment;
            tempExp.nextExperiment = merge(leftExperiment, rightExperiment.nextExperiment);
        }

        return tempExp;
    }

    /**Helper function for mergesort.
     *
     * @param head is the head of the list
     * @return the slowGrowing component as Node.
     */
    private Node middleElement(Node head) {
        Node slowCursor = head;
        Node fastCursor = head;
        while (fastCursor != null && fastCursor.nextExperiment != null && fastCursor.nextExperiment.nextExperiment != null) {
            slowCursor = slowCursor.nextExperiment;
            fastCursor = fastCursor.nextExperiment.nextExperiment;
        }
        return slowCursor;
    }

    /**
     *
     * @return My custom iterator
     */
    public Iterator iterator()
    {
        return new sushiIterator(this);

    }

    /**
     * sushiIterator that implements Iterator interface.
     */
    public class sushiIterator implements Iterator
    {
        Node cursor;

        /**
         *
         * @param expList as a List
         */
        public sushiIterator(ExperimentList expList)
        {
            cursor = expList.head;
        }

        /**
         * Checks if the cursor has next element or not.
         * @return boolean as true or false.
         */
        public boolean hasNext()
        {
            if(cursor != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Iterates cursor to next.
         * @return the Experiment value.
         */
        public Experiment next()
        {
            Experiment anExperiment = cursor.experiment;
            cursor = cursor.nextExperiment;
            return anExperiment;
        }

        /**
         * Not using remove for my iterator implementation.
         */
        public void remove()
        {
            throw new UnsupportedOperationException("Not using remove method for Iterator.");
        }

    }


}

