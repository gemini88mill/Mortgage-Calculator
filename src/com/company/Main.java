package com.company;

import java.util.Scanner;

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

    private int loanAmount = 0;
    private int interestRate = 0;
    private int loanTerm = 0;

    public static void main(String[] args) {
        int term = 0, interest = 0, loan = 0;

        collectUI(loan, interest, term);


    }

    private static void collectUI(int loan, int interest, int term) {

        System.out.println("Loan Amount: ");
        loan = scanInt();
        System.out.println("interest rate: ");
        interest = scanInt();
        System.out.println("Loan Term: ");
        term = scanInt();

        Main main = new Main(loan, interest, term);

        System.out.println(main.getInterestRate());
        System.out.println(main.getLoanAmount());
        System.out.println(main.getLoanTerm());
    }

    /**
     * Method to scan next int
     *
     */
    private static int scanInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }


    //------------------Constructor----------------------------------

    public Main(int loanAmount, int interestRate, int loanTerm) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    //---------------------------------------------------------------

    //---------------Getters and Setters-----------------------------

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    //--------------------------------------------------------------
}
