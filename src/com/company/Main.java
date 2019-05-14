package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("ITA00051", "Mediolanum");
        Bank bank1 = new Bank("IMT372260", "Intesa");
        Register register = new Register();
        register.addBanks(bank);
        Account account1 = new Account("ITA009");
        Account account2 = new Account("ITA0024");
        account1.setCredit(100);
        account2.setCredit(200);
        bank.addAccount(account1);
        bank.addAccount(account2);
        register.transfer(50,"IL2364", "IT1029");
        System.out.println(register.getBanks("ITA00051"));
        System.out.println(bank.getUser("IT1029"));
        System.out.println(account1.getCredit());
    }
}
