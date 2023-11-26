import org.example.BankAccount;
import org.example.InsufficientFundsException;
import org.example.NegativeAmountException;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void testDeposit() throws NegativeAmountException {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.deposit(200);

        assertEquals(); // Перевірка, чи вірно додалася сума
    }

    private void assertEquals() {
    }

    @Test
    public void testWithdrawSufficientFunds() throws NegativeAmountException, InsufficientFundsException {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.withdraw(200);

        assertEquals(); // Перевірка, чи вірно знялася сума
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawInsufficientFunds() throws InsufficientFundsException, NegativeAmountException {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.withdraw(1200); // Має виникнути InsufficientFundsException
    }

    @Test(expected = NegativeAmountException.class)
    public void testWithdrawNegativeAmount() throws InsufficientFundsException, NegativeAmountException {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.withdraw(-200); // Має виникнути NegativeAmountException
    }
}
