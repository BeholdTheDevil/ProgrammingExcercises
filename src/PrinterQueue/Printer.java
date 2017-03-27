package PrinterQueue;

/**
 * Created by anton on 2017-03-16.
 */
public class Printer {

    LinkedList<String> queue;

    Printer() {
        queue = new LinkedList<>();
    }

    void enqueue(String message) {queue.enqueue(message);}

    void dequeue() {queue.dequeue();}

    public boolean isEmpty() {return queue.isEmpty();}

    public int size() {return queue.size();}

    public void startPrinter(boolean printAll) throws QueueException, NullPointerException {
        /*
        Print either all items in the queue or only the first (printAll == true/false)
        Waiting time to simulate the time it takes for the printer to print documents
        Remove first Document from queue
         */
        try {
            try {
                do {
                    Thread.sleep(2000);
                    System.out.println(queue.getNextData());
                    queue.dequeue();
                } while(!queue.isEmpty() && printAll);
            } catch (InterruptedException ie) {}
        } catch(NullPointerException npe) {
            throw new QueueException("Printqueue is empty", npe);
        }
    }

    class QueueException extends Exception {
        /*
        Custom exception for returning message when the queue is null
         */
        public QueueException() { super(); }
        public QueueException(String message) { super(message); }
        public QueueException(String message, Throwable cause) { super(message, cause); }
        public QueueException(Throwable cause) { super(cause); }
    }
}
