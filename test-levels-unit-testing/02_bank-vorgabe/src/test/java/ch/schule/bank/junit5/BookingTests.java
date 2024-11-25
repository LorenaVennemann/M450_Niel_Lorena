package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests
{
	/**
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization()
	{
		Booking booking = new Booking(12112024,200);
		assertEquals(12112024, booking.getDate());
		assertEquals(200, booking.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));

		try {
			Booking booking = new Booking(12112024,200);
			booking.print(200);

			String expectedOutput = "05.07.35614       0.00       0.00";

			String actualOutput = outContent.toString().replace("\r\n", "\n").trim();
			assertEquals(expectedOutput, actualOutput);
		} finally {
			System.setOut(originalOut);
		}
	}
}
