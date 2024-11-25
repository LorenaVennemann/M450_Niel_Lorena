package ch.schule.bank.junit5;

import ch.schule.Bank;
import ch.schule.SavingsAccount;
import ch.schule.PromoYouthSavingsAccount;
import ch.schule.SalaryAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse 'Bank'.
 *
 * @author XXXX
 * @version 1.0
 */
public class BankTests {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateSavingsAccount() {
        String id = bank.createSavingsAccount();
        assertEquals("S-1000", id);
        assertNotNull(bank.getAccount(id));
        assertTrue(bank.getAccount(id) instanceof SavingsAccount);
    }

    @Test
    public void testCreatePromoYouthSavingsAccount() {
        String id = bank.createPromoYouthSavingsAccount();
        assertEquals("Y-1000", id);
        assertNotNull(bank.getAccount(id));
        assertTrue(bank.getAccount(id) instanceof PromoYouthSavingsAccount);
    }

    @Test
    public void testCreateSalaryAccount() {
        String id = bank.createSalaryAccount(-1000);
        assertEquals("P-1000", id);
        assertNotNull(bank.getAccount(id));
        assertTrue(bank.getAccount(id) instanceof SalaryAccount);
    }

    @Test
    public void testCreateSalaryAccountInvalidCreditLimit() {
        String id = bank.createSalaryAccount(1000);
        assertNull(id);
    }

    @Test
    public void testGetBalance() {
        bank.createSavingsAccount();
        bank.createPromoYouthSavingsAccount();
        bank.createSalaryAccount(-1000);
        assertEquals(0, bank.getBalance());
    }

    @Test
    public void testGetBalanceById() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20231125, 1000);
        assertEquals(1000, bank.getBalance(id));
    }

    @Test
    public void testDeposit() {
        String id = bank.createSavingsAccount();
        boolean result = bank.deposit(id, 20231125, 1000);
        assertTrue(result);
        assertEquals(1000, bank.getBalance(id));
    }

    @Test
    public void testDepositInvalidAccount() {
        boolean result = bank.deposit("invalid", 20231125, 1000);
        assertFalse(result);
    }

    @Test
    public void testWithdraw() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20231125, 1000);
        boolean result = bank.withdraw(id, 20231125, 500);
        assertTrue(result);
        assertEquals(500, bank.getBalance(id));
    }

    @Test
    public void testWithdrawInvalidAccount() {
        boolean result = bank.withdraw("invalid", 20231125, 500);
        assertFalse(result);
    }

    @Test
    public void testPrint() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20231125, 1000);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bank.print(id);

        String expectedOutput = "Kontoauszug '" + id + "'\n" +
                "Datum          Betrag      Saldo\n" +
                "25.12.2008      1000.00      1000.00";
        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }

    @Test
    public void testPrintInvalidAccount() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bank.print("invalid");

        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
        assertEquals("", actualOutput);

        System.setOut(originalOut);
    }

    @Test
    public void testPrintMonthly() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20231125, 1000);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bank.print(id, 2023, 11);

        String expectedOutput = "Kontoauszug '" + id + "' Monat: 11.2023\n" +
                "Datum          Betrag      Saldo\n" +
                "25.12.2008      1000.00      1000.00";
        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }

    @Test
    public void testPrintTop5() {
        for (int i = 0; i < 6; i++) {
            String id = bank.createSavingsAccount();
            bank.deposit(id, 20231125, 1000 * (i + 1));
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bank.printTop5();

        String expectedOutput = "S-1005: 6000\nS-1004: 5000\nS-1003: 4000\nS-1002: 3000\nS-1001: 2000";
        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }

    @Test
    public void testPrintBottom5() {
        for (int i = 0; i < 6; i++) {
            String id = bank.createSavingsAccount();
            bank.deposit(id, 20231125, 1000 * (i + 1));
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bank.printBottom5();

        String expectedOutput = "S-1000: 1000\nS-1001: 2000\nS-1002: 3000\nS-1003: 4000\nS-1004: 5000";
        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);
    }
}
