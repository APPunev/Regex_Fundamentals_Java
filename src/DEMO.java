import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class DEMO {
    public static void main (String[] args) throws java.lang.Exception  {
        Scanner sc = new Scanner(System.in);

        BigInteger num = BigInteger.valueOf(Integer.parseInt(sc.nextLine()));

        int n = num.intValue();

        if (n == 0) {
            System.out.println("0");
        }else if (n == 1) {
            System.out.println("1");
        }else if (n == 2) {
            System.out.println("1 1");
        }else if (n == 3) {
            System.out.println("1 1 2");
        }else{
            printResult(num);
        }
    }

    private static void printResult(BigInteger num) {

        System.out.println("1 1 2 ");
        for (int i = 3; i <= num.intValue(); i++) {

            System.out.print(num);
        }
    }
}