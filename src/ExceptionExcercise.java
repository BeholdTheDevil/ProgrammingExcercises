import javax.swing.*;

/**
 * Created by anton on 2017-02-06.
 */
public class ExceptionExcercise {

    static String errorMessage = "";
    static boolean closed = false;

    public static void main(String[] args) {
        String age;
        double price = -1;
        while(price < 0 && !closed) {
            try {
                age = ageVerification();
                price = calculatePrice(age);
                System.out.println(price);
            } catch (IllegalArgumentException iae) {
                errorMessage = "\nInvalid age!";
            } catch (InterruptedException ie) {
                break;
            }
        }
    }

    private static String ageVerification() throws InterruptedException {
        String input = JOptionPane.showInputDialog(null, "Enter your age " + errorMessage);
        if(input == null) {
            throw new InterruptedException();
        }
        return input;
    }

    private static double calculatePrice(String input) {
        int age;
        try {
            age = Integer.parseInt(input);
            if(age < 0) {
                throw new IllegalArgumentException();
            }
        } catch(NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
        if(age >= 65 || (age >= 20 && age <= 25)) {
            //Pensionär och ungdom
            return 28.00;
        } else if(age >= 26) {
            //Vuxen
            return 34.00;
        } else if(age >= 7) {
            //Barn
            return 14.00;
        }
        //Små barn
        return 0.00;
    }


}
