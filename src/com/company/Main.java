package com.company;

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

       // System.out.println("hello world");




        System.out.println("Please input your ");
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
