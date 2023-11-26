package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException("Withdrawal amount must be positive");
        }

        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds to withdraw");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\nAccount Name: " + accountName + "\nBalance: " + balance;
    }
}
