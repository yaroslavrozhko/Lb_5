package org.example;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        if (initialDeposit < 0) {
            throw new NegativeAmountException("Initial deposit amount must be positive");
        }

        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException("Transfer amount must be positive");
        }

        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    private int generateAccountNumber() {
        // Логіка генерації унікального номера рахунку
        return accounts.size() + 1;
    }
}