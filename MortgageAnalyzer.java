

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageAnalyzer {

    public static void main(String[] args) {

        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        Scanner userInput = new Scanner(System.in);

        System.out.print("Amount of Loan: ");
        int loanamount = userInput.nextInt();

        System.out.print("Annual Interest Rate: ");
        float monthlyInterestRate = ((userInput.nextFloat() / PERCENT) / MONTHS_IN_YEAR);
        System.out.println("Monthly Interest Rate: " + monthlyInterestRate);

        System.out.print("Duration of Loan in years: ");
        short duration= (short) (userInput.nextShort() * MONTHS_IN_YEAR); // stores 'period' in months
        System.out.println("Duration of Loan in months: " + duration);

        userInput.close();

        double monthlypayment = (loanamount * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, duration)))
                / ((Math.pow(1 + monthlyInterestRate,duration)) - 1));


        System.out.println("Monthly Payment: " + NumberFormat.getCurrencyInstance().format(monthlypayment));
        int numberOfPayments = duration;

        double totalInterestPaid = numberOfPayments * monthlypayment - loanamount;
        System.out.println("Total interest paid:" + NumberFormat.getCurrencyInstance().format(totalInterestPaid));;
    }
