package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList <Account> accounts = new ArrayList<>();
    private String id, name;
    private double credit=10000;
    private double commission= 2;

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public void addCredit(double credit) {
        this.credit = this.credit + credit;
    }

    public Bank(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getCommission() {
        return commission;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getCredit() {
        return credit;
    }

    public Account getUser(String iban){
        for (int i=0; i<this.accounts.size(); i++){
            if (iban.equals(this.accounts.get(i).getIban()))
                return this.accounts.get(i);
        }
        return null;
    }

    public double getTotalCredit(){
        double totalCredit=0;
        for(int i=0; i< this.accounts.size(); i++){
            totalCredit = this.credit + this.accounts.get(i).getCredit();
        }
        return totalCredit;
    }

    @Override
    public String toString() {
        String s= "", s1= "";
        for (int i=0; i< this.accounts.size(); i++){
            s= "Iban: " + this.accounts.get(i).getIban() + "Credit: " + this.accounts.get(i).getCredit();
        }
        s1= "Bank: " + "\nId: " + id + "\nName: " + name + "\nCredit: " + credit;
        return s + s1;
    }
}
