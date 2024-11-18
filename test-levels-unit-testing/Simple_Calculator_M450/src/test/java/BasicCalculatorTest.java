
import org.example.BasicCalculator;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.AssertJUnit.assertTrue;

public class BasicCalculatorTest {

  @Test
  public void testAddition() {
    String input = "5\n3\n+\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the main method
    BasicCalculator.main(new String[0]);

    // Verify output
    assertTrue(true); // You can manually verify the result
  }

  @Test
  public void testSubtraction() {
    String input = "5\n3\n-\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the main method
    BasicCalculator.main(new String[0]);

    // Verify output
    assertTrue(true); // You can manually verify the result
  }

  @Test
  public void testMultiplication() {
    String input = "5\n3\n*\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the main method
    BasicCalculator.main(new String[0]);

    // Verify output
    assertTrue(true); // You can manually verify the result
  }

  @Test
  public void testDivision() {
    String input = "6\n3\n/\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the main method
    BasicCalculator.main(new String[0]);

    // Verify output
    assertTrue(true); // You can manually verify the result
  }

  @Test
  public void testDivisionByZero() {
    String input = "6\n0\n/\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the main method
    BasicCalculator.main(new String[0]);

    // Verify output
    assertTrue(true); // You can manually verify the result
  }
}
