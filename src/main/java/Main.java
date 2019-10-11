import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("enter a number");
        Scanner sc = new Scanner(System.in);
        Converter con = new Converter();
        BigInteger as = new BigInteger(sc.nextLine());
        System.out.println(con.digitToString(as));
    }
}
