import java.util.NoSuchElementException;

/**
A linked list is a sequence of nodes with efficient
element insertion and removal. This class
contains a subset of the methods of the standard
java.util.LinkedList class.
 */
public class LinkedList
{
    private Node first;

    /**
    Constructs an empty linked list.
     */
    public LinkedList()
    {
        first = null;
    }



    /**
    Returns the first element in the linked list.
    @return the first element in the linked list
     */
    public Object getFirst()
    {
        if(first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
    Removes the first element in the linked list.
    @return the removed element
     */
    public Object removeFirst()
    {
        if(first == null)
            throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        return element;
    }

     /**
	    Boolean for contains method
	    @return the removed element
     */
     public boolean contains(Object element)
	    {
	        Node currentNode = first;
	        Object data = currentNode.data;
	        for (int i = 0; i < size(); i++)
	        {
	            data = currentNode.data;
	            if (data.equals(element))
	            {
	                return true;
	            }
	            currentNode = currentNode.next;

	        }
	        return false;
	    }



    /**
    Adds an element to the front of the linked list.
    @param element the element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }

       /**
    Computes the size of the linked list
    @return the number of elements in the list
     */
    public int size()
    {
        int count = 0;
        Node current = first;


        while(current !=null)
        {

            count ++;
            current = current.next;
        }
        return count;
    }

    /**
    Returns an iterator for iterating through this list.
    @return an iterator for iterating through this list
     */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    //Class Node
    class Node
    {
        public Object data; //this object
        public Node next;

    }

    class LinkedListIterator implements ListIterator
    {
        //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
        Constructs an iterator that points to the front
        of the linked list.
         */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
        Moves the iterator past the next element.
        @return the traversed element
         */
        public Object next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            previous = position;
            isAfterNext = true;
            if(position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }
            return position;
        }


        /**
        Tests if there is an element after the iterator position.
        @return true if there is an element after the iterator position
         */
        public boolean hasNext()
        {
            if(position == null)
                return first!=null;
            else
                return position.next !=null;
        }

        /**
        Adds an element before the iterator position
        and moves the iterator past the inserted element.
        @param element the element to add
         */
        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element);
                position = first;

            }

            else
            {
                Node newNode = new Node();
                newNode.data = element; //Alias
                newNode.next = position.next; //I know who is next :)
                position.next = newNode; //Iterator thinks next is me
                position = newNode; //current position is me, little conflict if you call remove

            }

            isAfterNext = false;
        }


        /**
        Removes the last traversed element. This method may
        only be called after a call to the next() method.
         */
        public void remove()
    {
        if(!isAfterNext) //flag
        {
            throw new IllegalStateException();


        }

        if(position == first)
        {
            removeFirst(); //calls LL method because we are an inner class

        }

        else
        {
            previous.next = previous.next; //move the reference of previous to node after me
        }

        position = previous;
        isAfterNext = false;

        //first call to remove the current position reverts to the predecessor!
        // of removed element ---> thus predecessor is not longer known! (cant call remove again!)



    }



    /**
    Sets the last traversed element to a different value.
    @param element the element to set
     */
    public void set(Object element)
    {
        if(!isAfterNext)
        {
            throw new IllegalStateException();
        }
        position.data = element;

    }



    }//LinkedListIterator
}//LinkedList
