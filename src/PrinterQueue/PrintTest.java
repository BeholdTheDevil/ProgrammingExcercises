package PrinterQueue;

import java.util.Scanner;

/**
 * Created by anton on 2017-03-20.
 */
public class PrintTest {

    public static void main(String[] args) {
        String a = "";
        Printer printer = new Printer();            //Initialize printer
        Scanner scan = new Scanner(System.in);      //Scanner for user input

        while(!a.equals("start")) {
            System.out.print("Message to print: ");
            a = scan.nextLine();
            if(!a.equals("start")) printer.enqueue(a);
        }

        printer.startPrinter(false);                     //Start printer, only prints first document in queue (printAll: false)
        System.out.println("");
        printer.startPrinter(true);                     //Start printer, prints the rest of the documents (printAll: true)
    }
}
