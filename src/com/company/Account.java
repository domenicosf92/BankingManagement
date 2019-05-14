package com.company;

public class Account {
    private String iban;
    private double credit=0;

    public Account(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void addCredit(double credit){
        this.credit = this.credit + credit;
    }

    public void removeCredit(double credit){
        this.credit = this.credit - credit;
    }

    @Override
    public String toString() {
        return "Account: " + "\nIban: " + iban + "\nCredit: " + credit;
    }
}
