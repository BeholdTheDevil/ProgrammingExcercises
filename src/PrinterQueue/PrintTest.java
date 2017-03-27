package PrinterQueue;

import java.util.Scanner;

/**
 * Created by anton on 2017-03-20.
 */
public class PrintTest {

    static Printer printer;

    public static void main(String[] args) throws Printer.QueueException {
        //Initialize printer
        printer = new Printer();

        testTwo();
    }

    private static void testThree() {
        printer.enqueue("a");
        printer.enqueue("c");
        printer.enqueue("b");
        System.out.println(printer.size());
        printer.queue.purge();
        System.out.println(printer.size());
    }

    private static void testTwo() throws Printer.QueueException {
        printer.enqueue("a");
        printer.queue.enqueueFirst("b");
        printer.enqueue("c");
        printer.queue.enqueueFirst("d");

        printer.startPrinter(true);
    }

    private static void testOne() throws Printer.QueueException {
        printer.enqueue("Hello");
        printer.enqueue("There");
        printer.enqueue("Magnus");

        System.out.println(printer.size());
        System.out.println(printer.isEmpty());
        printer.startPrinter(true);
    }
}
