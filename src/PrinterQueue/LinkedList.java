package PrinterQueue;

/**
 * Created by anton on 2017-03-27.
 */
public class LinkedList<E> {

    LinkedNode<E> first, last;

    LinkedList() {}

    public int size() {
        LinkedNode current = first;
        int count = 0;
        while(current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void purge() {
        /*
        Remove all pointers and let java trashcollection remove now unused Nodes
         */
        first = null;
        last = null;
    }

    public boolean isEmpty() {return first == null;}

    public void enqueueFirst(E data) {
        /*
        Add a node to the beginning of the list
         */
        LinkedNode<E> d = new LinkedNode<E>(data);
        if(isEmpty()) last = d;
        d.next = first;
        first = d;
    }

    public void dequeueLast() {
        /*
        Find the last Document in the queue
        Dequeue last Node in list and change "last" to the second to last Node
         */
        LinkedNode<E> current = first;
        if(current != null) {
            while(current.next != last) {
                current = current.getNext();
            }
            current.setNext(null);
            last = current;
        }
    }

    public void enqueue(E data) {
        LinkedNode<E> d = new LinkedNode<E>(data);          //Create new message
        if(isEmpty()) {                                     //If queue is empty add the new Node as the first and also set it as the last one
            first = d;
            last = first;
        } else {                                            //Add the new Node to the end of the queue
            last.setNext(d);
            last = d;
        }
    }

    public void dequeue() {first = first.getNext();}                             //Dequeue first Node in list

    public E getNextData() {return first.getData();}

    private class LinkedNode<E> {

        private E data;
        private LinkedNode next;

        LinkedNode(E data_) {
            data = data_;
        }

        private LinkedNode getNext() {return next;}

        private void setNext(LinkedNode next_) {next = next_;}

        private boolean hasNext() {return next != null;}

        private E getData() {return data;}
    }
}
