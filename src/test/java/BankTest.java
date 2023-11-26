import org.example.*;

public class BankTest {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank();

            BankAccount account1 = bank.createAccount("John Doe", 1000);
            BankAccount account2 = bank.createAccount("Jane Doe", 500);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            account1.deposit(200);
            System.out.println(account1.getAccountSummary());

            account1.withdraw(150);
            System.out.println(account1.getAccountSummary());

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

        } catch (InsufficientFundsException | NegativeAmountException |
                 AccountNotFoundException e) {
            e.printStackTrace();
        }
    }
}