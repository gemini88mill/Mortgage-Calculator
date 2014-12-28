package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.pow;


public class Main {

    /**
     * Mortgage Calculator
     * @author Raphael Miller (gemini88mill)
     *
     * Program designed to give data on how long it will take to to
     * pay off your mortgage. As if you didnt already feel the cold
     * uncomprimising hands of debt clutching you in a meloncholy
     * embrace :)
     *
     * Mortgage Calculator – Calculate the monthly payments of a
     * fixed term mortgage over given Nth terms at a given interest rate.
     * Also figure out how long it will take the user to pay back the loan.
     *
     * @param args
     */


    //-------- Global Variables -----------------------------------------

    private double loanAmount = 0;
    private double interestRate = 0;
    private double loanTerm = 0;
    private String startDate;
    private double monthlyPayment;
    private String paymentFormatted;
    private String loanFormatted;
    private String endDate;

    //------------------------------------------------------------------

    public static void main(String[] args) {
        double term = 0, interest = 0, loan = 0;
        collectUI(loan, interest, term);
    }

    private static void collectUI(double loan, double interest, double term) {

        System.out.println("Loan Amount: ");
        loan = scanDouble();
        System.out.println("interest rate: ");
        interest = scanDouble();
        System.out.println("Loan Term: ");
        term = scanDouble();
        System.out.println("Start Date: (MM/YYYY)");

        Main main = new Main(loan, interest, term);

        main.setStartDate(scanString());
        double monthlyPayment = main.mortgageCalculation();

        main.setMonthlyPayment(monthlyPayment);

        main.cutoffDeci(main.getMonthlyPayment());
        main.cutoffLoan(main.getLoanAmount());

        main.calculateEndDate(main.getStartDate());

        main.printResult();
    }

    private void calculateEndDate(String startDate) {
        SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(format.parse(startDate));
            calendar.add(Calendar.YEAR, (int) getLoanTerm());

            Date date = calendar.getTime();
            setEndDate(format.format(date));

            //System.out.println(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private void printResult(){

        System.out.println("Interest Rate: "+ getInterestRate() + "%");
        System.out.println("Loan Amount: $" + getLoanFormatted());
        System.out.println("Length of Loan Term: " + getLoanTerm() + " Months");
        System.out.println("Monthly Payment: $" + getPaymentFormatted());
        System.out.println("Payment Start Date: " + getStartDate());
        System.out.println("Payment End Date: " + getEndDate());
    }

    //-------------Formatters--------------------------------------------

    private void cutoffLoan(double loanAmount) {
        DecimalFormat df = new DecimalFormat("#.00");
        String formatted = df.format(loanAmount);

        setLoanFormatted(formatted);
    }

    private void cutoffDeci(double monthlyPayemnt) {
        DecimalFormat df = new DecimalFormat("#.00");
        String formatted = df.format(monthlyPayemnt);

        setPaymentFormatted(formatted);
    }

    //------------------------------------------------------------------

    private double mortgageCalculation() {


        double P = getLoanAmount();
        double N = (getLoanTerm() * 12);
        double r = (getInterestRate() * 0.01 / 12);
        double c = 0;
        double pows;
        //double pows2;
        double top;
        double bottom;
        pows = pow((1+r), N);


        top = P * r * pows;
        bottom = pows - 1;

        c = top / bottom;

        return c;
    }

    /**
     * Method to scan next int
     *
     */

    //-------------Scanner Methods------------------------------------

    private static double scanDouble() {
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    private static String scanString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    //---------------------------------------------------------------


    //------------------Constructor----------------------------------

    public Main(double loanAmount, double interestRate, double loanTerm) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    //---------------------------------------------------------------

    //---------------Getters and Setters-----------------------------

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public double getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPaymentFormatted() {
        return paymentFormatted;
    }

    public void setPaymentFormatted(String paymentFormatted) {
        this.paymentFormatted = paymentFormatted;
    }

    public String getLoanFormatted() {
        return loanFormatted;
    }

    public void setLoanFormatted(String loanFormatted) {
        this.loanFormatted = loanFormatted;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    //--------------------------------------------------------------
}
