/**
 * Created by anton on 2016-11-28.
 */
public class PRGUppg1 {

    public static void main(String[] args) {
        del1(9);
        del2();
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

    private static void del2() {

    }

    private static void del3() {

    }


}
