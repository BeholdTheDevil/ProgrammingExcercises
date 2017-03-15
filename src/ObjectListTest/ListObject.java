package ObjectListTest;

import static ObjectListTest.LinkedListTest.first;

/*
            List Object class for
 */

class ListObject {

    private ListObject prev;
    private ListObject next;
    private int priority;

    ListObject(ListObject prev, int priority) {
        this.priority = priority;
        this.prev = prev;
        if (prev != null) prev.next = this;
    }

    void print() {
        System.out.print(" " + priority);
        if(next != null) next.print();
    }

    void sort() {

        while (prev != null && priority < prev.priority) {
            ListObject temp = next;
            next = prev;
            prev.next = temp;
            if(temp != null) temp.prev = prev;

            temp = prev.prev;
            prev.prev = this;
            prev = temp;
            if(temp != null) temp.next = this;
        }
        if(prev == null) first = this;
        if (next != null) {
            next.sort();
        }
    }
}