package ObjectListTest;

import java.util.Random;

/**
 * Created by anton on 2017-03-14.
 */
public class LinkedListTest {

    static ListObject first;

    public static void main(String[] args) {
        int max = 100;
        int numberOfObjects = 15;

        ListObject[] list = new ListObject[numberOfObjects];
        Random rand = new Random();
        first = new ListObject(null, rand.nextInt(max));
        list[0] = new ListObject(first, rand.nextInt(max));

        for(int i = 1; i < list.length; i++) {
            list[i] = new ListObject(list[i-1], rand.nextInt(max));
        }
        first.print();
        System.out.println("");
        first.sort();
        first.print();
    }
}
