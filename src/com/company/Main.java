package com.company;

import java.util.Scanner;

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

    private double loanAmount = 0;
    private double interestRate = 0;
    private double loanTerm = 0;

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

        Main main = new Main(loan, interest, term);

        System.out.println(main.getInterestRate());
        System.out.println(main.getLoanAmount());
        System.out.println(main.getLoanTerm());

        main.mortgageCalculation();
    }

    private void mortgageCalculation() {


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
        System.out.println(pows);
        //System.out.println(pows2);
        System.out.println(top);
        System.out.println(bottom);

        System.out.println(P);
        System.out.println(N);
        System.out.println(r);
        System.out.println(c);
    }

    /**
     * Method to scan next int
     *
     */
    private static double scanDouble() {
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }


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

    //--------------------------------------------------------------
}
