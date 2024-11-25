package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Bank;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {
    /**
     * Tested die Initialisierung eines Kontos.
     */

    Bank bank;
    Account account;

    @BeforeEach
    public void setUp() { // Code zur Initialisierung der Datenbankverbindung
        bank = new Bank();
        bank.setAccount(bank.getAccount("P-1000"));
    }

    @Test
    public void testInit() {
        assertEquals(0, bank.getAccount().getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        bank.deposit("P-1000", 25122008, 10000);
        assertEquals(10000, bank.getAccount("P-1000").getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        bank.withdraw("P-1000", 25122008, 100);
        assertEquals(-100, bank.getAccount("P-1000").getBalance());
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
    public void testReferences() {

    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        Boolean true1 = bank.getAccount("P-1000").canTransact(100);
        bank.deposit("P-1000", 300, 10000);
        Boolean false1 = bank.getAccount("P-1000").canTransact(200);
        Boolean true2 = bank.getAccount("P-1000").canTransact(500);
        assertEquals(true, true1);
        assertEquals(true, true2);
        assertEquals(false, false1);
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            bank.withdraw("P-1000", 25122008, 100);
            bank.getAccount("P-1000").print();

            String expectedOutput = "Kontoauszug 'P-1000'\n" +
                    "Datum          Betrag      Saldo\n" +
                    "09.05.71753      -0.00      -0.00";

            String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setOut(originalOut);
        }
    }


    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            bank.withdraw("P-1000", 1731924407, 100);
            bank.getAccount("P-1000").print(2024, 10);

            String expectedOutput = "Kontoauszug 'P-1000' Monat: 10.2024\n"+
            "Datum          Betrag      Saldo";

            String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setOut(originalOut);
        }
    }

}
