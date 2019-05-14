package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Register {
    public ArrayList <Bank> banks = new ArrayList <> ();

    public void addBanks(Bank banks) {
        this.banks.add(banks);
    }

    public Bank getBanks(String id) {
        for (Bank bank : this.banks) {
            if (id.equals(bank.getId())) {
                return bank;
            }
        }
        return null;
    }

    private Bank getBankByIban(String iban){
        String bankName;
        bankName = iban.substring(0,5);
        for (Bank bank : this.banks) {
            if (bankName.equals(bank.getId())) {
                return this.getBanks(bankName);
            }
        }
        return null;
    }

    public Account getUser(String iban){
        String bankName;
        bankName = iban.substring(0,5);
        for (Bank bank : this.banks) {
            if (bankName.equals(bank.getId())) {
                Bank b = this.getBanks(bankName);
                return b.getUser(iban);
            }
        }
        return null;
    }

    public void transfer(double money, String receivingIban, String senderIban) {
        Account sendingUser = this.getUser(senderIban);
        Account receivingUser = this.getUser(receivingIban);
        Bank bankSender = this.getBankByIban(senderIban);
        Bank bankReceiving = this.getBankByIban(receivingIban);
        if (bankSender!=null && bankReceiving!=null){
            if (bankSender.getId().equals(bankReceiving.getId())){
                sendingUser.removeCredit(money);
            } else {
                sendingUser.removeCredit(money+bankSender.getCommission());
                bankSender.addCredit(bankSender.getCommission());
            }
            receivingUser.addCredit(money);
        }

    }
}
