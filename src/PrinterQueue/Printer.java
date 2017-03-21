package PrinterQueue;

/**
 * Created by anton on 2017-03-16.
 */
public class Printer {

    static Document first;
    static Document last;

    Printer() {}

    public int size() {                                     //Retrieve linked list size
        Document current = first;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        if(first == null) return true;
        else return false;
    }

    public void addFirst(Document d) {
        d.next = first;                                     //Set a new Document as the first in the queue
        first = d;
    }

    public void dequeue() {
        first = first.getNext();                            //Dequeue first Document
    }

    public void removeLast() {
        Document current = first;
        if(current != null) {                               //Find the last Document in the queue
            while(current.next != last) {
                current = current.getNext();
            }
            current.setNext(null);                          //Set next of the second to last Document to null to remove link to last Document
            last = current;                                 //Set the last to the second to last Document (in practice, remove the last Document)
        }
    }

    public void enqueue(String message) {
        Document d = new Document(message);                 //Create new message
        if(isEmpty()) {                                     //If queue is empty add the new Document as the first and also set it as the last one
            first = d;
            last = first;
        } else {                                            //Add the new Document to the end of the queue
            last.setNext(d);
            last = d;
        }

    }

    public void startPrinter(boolean printAll) {
        first.print(printAll);
    }

    class Document {

        Document next;
        String message;

        Document(String message_) {
            message = message_;
        }

        void print(boolean printAll) {              //Boolean for printing all documents or a single document
            System.out.println(message);
            try {
                Thread.sleep(2000);             //Waiting time so to simulate the time it takes for the printer to print documents
            } catch (InterruptedException ie) {

            }
            dequeue();                              //Remove first Document from queue
            if (next != null && printAll) next.print(true);         //Print the next Document if such exists
        }

        Document getNext() {
            return next;
        }

        void setNext(Document d) {
            next = d;
        }
    }
}
