/**
 * Created by anton on 2017-04-24.
 */
public class ComplexNumbers {

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1f, 1f);
        ComplexNumber b = new ComplexNumber(-2f, 2f);
        a.mult(b);
        System.out.print(a.asString());
    }

    static class ComplexNumber {
        float realpart;
        float imaginarypart;

        ComplexNumber(float real, float imaginary) {
            realpart = real;
            imaginarypart = imaginary;
        }

        boolean equals(ComplexNumber com) {
            if(realpart == com.realpart&& imaginarypart == com.imaginarypart)
                return true;
            return false;
        }

        int compare(ComplexNumber com) {
            double magA = Math.sqrt(realpart*realpart + imaginarypart*imaginarypart);
            double magB = Math.sqrt(com.realpart*com.realpart + com.imaginarypart*com.imaginarypart);
            if(magA < magB) return -1;
            if(magA > magB) return 1;
            return 0;
        }

        String asString() {
            //Complex numbers can be written as a+bi
            return new String("(" + realpart + " + " + imaginarypart+"i)");
        }

        void add(ComplexNumber com) {
            realpart += com.realpart;
            imaginarypart += com.imaginarypart;
        }

        void add(int scalar) {
            realpart += scalar;
        }

        void sub(ComplexNumber com) {
            realpart -= com.realpart;
            imaginarypart -= com.imaginarypart;
        }

        void sub(int scalar) {
            realpart -= scalar;
        }

        void div(ComplexNumber com) {
            float a = realpart;
            float b = imaginarypart;
            float c = com.realpart;
            float d = com.imaginarypart;

            realpart = (a*c + b*d) / (c*c + d*d);
            imaginarypart = (b*c - a*d) / (c*c + d*d);
        }

        void div(int scalar) {
            realpart /= scalar;
            imaginarypart /= scalar;
        }

        void mult(ComplexNumber com) {
            float a = realpart;
            float b = imaginarypart;
            float c = com.realpart;
            float d = com.imaginarypart;

            realpart = a*c - b*d;
            imaginarypart = b*c + a*d;
        }

        void mult(int scalar) {
            realpart *= scalar;
            imaginarypart *= scalar;
        }
    }
}
