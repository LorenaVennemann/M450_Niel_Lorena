package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests {

	private PromoYouthSavingsAccount account;

	@BeforeEach
	public void setUp() {
		account = new PromoYouthSavingsAccount("12345");
	}

	@Test
	public void testDepositSuccess() {
		boolean result = account.deposit(20231125, 1000);
		assertTrue(result, "Einzahlung sollte erfolgreich sein");
		assertEquals(1010, account.getBalance(), "Der Kontostand sollte 1010 sein (1000 + 1% Bonus)");
	}

	@Test
	public void testDepositNegativeAmount() {
		boolean result = account.deposit(20231125, -100);
		assertFalse(result, "Einzahlung eines negativen Betrags sollte fehlschlagen");
		assertEquals(0, account.getBalance(), "Der Kontostand sollte unverändert bei 0 sein");
	}

	@Test
	public void testDepositZeroAmount() {
		boolean result = account.deposit(20231125, 0);
		assertTrue(result, "Einzahlung von 0 sollte erfolgreich sein");
		assertEquals(0, account.getBalance(), "Der Kontostand sollte unverändert bei 0 sein");
	}
}
