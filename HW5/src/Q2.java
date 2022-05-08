import java.util.InputMismatchException;
import java.util.Scanner;

public class Q2 {
    public double FastPower(double x) {
        if (x==0) {
            return 1;
        }
        if (x%2!=0) {
            return 2*FastPower(x-1);
        }
        else {
            return Math.pow(FastPower(x / 2), 2);
        }
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input a number no less than 0, negative number will terminate the code: ");
            try {
                double input = scanner.nextDouble();
                if (input < 0) {
                    break;
                }
                System.out.println(q2.FastPower(input));
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                scanner.next();
            }
        }
        System.out.println("The function has been terminated!");
    }
}
