import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main (String[] args){
        /*int principal = 100_000;
        float ratePercent = 3.92F;
        float rateDecimal = ratePercent/12/100;
        int period = 30;
        int periodMonth = period*12;*/


        Scanner scanner = new Scanner (System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float ratePercent = scanner.nextFloat();

        System.out.print("Period: ");
        int period = scanner.nextInt();
        

        float rateDecimal = ratePercent/12/100;
        int periodMonth = period*12;

        float monthlyMortgage = (float)(principal*((rateDecimal*(Math.pow(1+rateDecimal, periodMonth))) / (Math.pow(1+rateDecimal, periodMonth)-1)));

        System.out.println(monthlyMortgage);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        String resultPrincipal = currency.format(monthlyMortgage);
        
        System.out.println("Monthly payment: "+ resultPrincipal);


  
        //Principal: 100000, Annual Interest rate: 3.92/12/100 -0.0392  , Period/Years 30*12  , Mortgage: $472.81
  
    }
    
}
