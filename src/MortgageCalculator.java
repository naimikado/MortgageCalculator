import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/* Example:
*  Principal: 100000
*  Annual Interest rate: 3.92 (/12/100 = -0.0392)  
*  Period/Years 30  (*12)
*  Monthly Mortgage: $472.81 
*  ---------------------------------
*  Additional instructions Pt.2:
*  Add range to all fields
*  Add percent formatting to interest rate
*  When correct range is not entered, loop until correct range is entered, print instructions on valid numbers
*/

public class MortgageCalculator {
    public static void main (String[] args){
        int principal;
        float ratePercent;
        int period;

        Scanner scanner = new Scanner (System.in);

        while (true) {
            try {
                System.out.print("Principal (£1K - £1M): ");
                principal = scanner.nextInt();
                if (principal >= 1000 && principal <= 1000000)
                    break;
                else
                    System.out.println("Please enter a value between 1,000 and 1,000,000.");
            }
            catch (InputMismatchException e ) {
                System.err.println("Please only use whole numbers in the range of 1000 - 1000000.");
                /*When input is not an expected type, the loop would run infinitely due to the scanner type on ln 27.
                To fix that, scanner.next() parses the invalid user input and repeats the loop with a corrected position. */
                scanner.next();
            }
        }   

        while (true) {
            try {
                System.out.print("Annual Interest Rate: ");
                ratePercent = scanner.nextFloat();
                if (ratePercent > 0 && ratePercent <= 10)
                break;
                 else
                System.out.println("Please enter a value greater than 0 and less than or equal to 10.");
            }
            catch (InputMismatchException e ) {
                System.err.println("Please only use whole or decimal numbers ranging 1,00 - 10,00 in the format XX,XX .");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.print("Period (Years): ");
                period = scanner.nextInt();
            if (period >= 1 && period <= 50)
                break;
            else
                System.out.println("Please enter a value greater than 1 and less than or equal to 50.");
            }
            catch (InputMismatchException e ) {
                System.err.println("Please only use whole numbers in the range of 1 - 50.");
                scanner.next();
            }
        }

        float rateDecimal = ratePercent/12/100;
        int periodMonth = period*12;

        float monthlyMortgage = (float)(principal*((rateDecimal*(Math.pow(1+rateDecimal, periodMonth))) / (Math.pow(1+rateDecimal, periodMonth)-1)));

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        String resultPrincipal = currency.format(monthlyMortgage);
        
        System.out.println("Monthly payment: "+ resultPrincipal);

    
    }
    
}
