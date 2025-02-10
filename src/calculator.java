import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class calculator {
    public static void main (String[] args) {

        /*
        Inputs:
            principal
            Annual Interest Rate
            Period (Years)
        Output:
            Mortgage as USD

        Mortgage calculation:
        Mortgage = M
        Principal = P
        Monthly interest (Annual/100/12) = r
        Number of payments (months) = n
            M = P * ( (r * (1+r)^n) / ( (1+r)^n - 1) )
        */

        //classes we'll use
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

        //constants
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        //gather and store inputs
        System.out.print("Principal:\t");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate:\t");
        float interestRate = scanner.nextFloat() / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years):\t");
        int numberOfPayments = scanner.nextInt() * MONTHS_IN_YEAR;

        // (1+r)^2 is in both divisor and dividend so lets make a variable of that
        double interestSquared = Math.pow(1+interestRate,numberOfPayments);

        //use the squared variable to calculate dividend and divisor
        double dividend = interestRate * interestSquared;
        double divisor = interestSquared - 1;

        //get mortgage by multiplying principal with quotient
        double mortgage = principal * (dividend / divisor);
        System.out.println("Mortgage:\t" + currency.format(mortgage));
    }
}
