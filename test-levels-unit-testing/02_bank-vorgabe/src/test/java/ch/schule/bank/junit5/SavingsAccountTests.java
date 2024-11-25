package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
public class SavingsAccountTests {

	private SavingsAccount account;

	@BeforeEach
	public void setUp() {
		account = new SavingsAccount("12345");
		account.deposit(201010, 1000);
	}

	@Test
	public void testWithdrawSuccess() {
		boolean result = account.withdraw(20231125, 500);
		assertTrue(result, "Abhebung sollte erfolgreich sein");
		assertEquals(500, account.getBalance(), "Der Kontostand sollte 500 sein");
	}

	@Test
	public void testWithdrawInsufficientFunds() {
		boolean result = account.withdraw(20231125, 1500);
		assertFalse(result, "Abhebung sollte fehlschlagen");
		assertEquals(1000, account.getBalance(), "Der Kontostand sollte unverändert bei 1000 sein");
	}

	@Test
	public void testWithdrawNegativeAmount() {
		boolean result = account.withdraw(20231125, -100);
		assertFalse(result, "Abhebung eines negativen Betrags sollte fehlschlagen");
		assertEquals(1000, account.getBalance(), "Der Kontostand sollte unverändert bei 1000 sein");
	}

	@Test
	public void testWithdrawExactBalance() {
		boolean result = account.withdraw(20231125, 1000);
		assertTrue(result, "Abhebung des gesamten Guthabens sollte erfolgreich sein");
		assertEquals(0, account.getBalance(), "Der Kontostand sollte 0 sein");
	}
}
