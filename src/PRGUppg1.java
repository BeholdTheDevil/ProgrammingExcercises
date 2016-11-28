import javax.swing.*;
import java.util.Scanner;

/**
 * Created by anton on 2016-11-28.
 */
public class PRGUppg1 {

    public static void main(String[] args) {
        del1(9);
        del2(100000);
        del3();
    }

    private static void del1(int row) {
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j * i + " ");
            }
            System.out.print("\n");
        }
    }

    private static void del2(int max) {
        double val = 0;

        for(int i = 1; i <= max; i++) {
            if (i % 2 == 0) {
                val = val - ((double) 1 / i);
                System.out.print(" - 1/" + i);
            } else {
                val = val + ((double) 1 / i);
                System.out.print(" + 1/" + i);
            }
        }
        System.out.println(val);
    }

    private static void del3() {

        String palindrome = JOptionPane.showInputDialog(null, "Enter a word: ");
        String reverse = new StringBuilder(palindrome).reverse().toString();

        if(palindrome.equals(reverse)) {
            JOptionPane.showMessageDialog(null, String.format("%s is a palindrome", palindrome));
        } else {
            JOptionPane.showMessageDialog(null, String.format("%s is not taa palindrome", palindrome));
        }
    }


}
