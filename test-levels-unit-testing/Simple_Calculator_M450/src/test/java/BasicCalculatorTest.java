
import org.example.BasicCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasicCalculatorTest {

  @Test
  public void testAddition() {
    double result = BasicCalculator.add(5,3);
    assertEquals(8.0, result);
  }

  @Test
  public void testSubtraction() {
    double result = BasicCalculator.subtract(5,3);

    //    assertEquals(, result);
  }

  @Test
  public void testMultiplication() {
    double result = BasicCalculator.multiply(12,5);
    assertEquals(60.0, result);
  }

  @Test
  public void testDivision() {
    double result = BasicCalculator.divide(10,2);
    assertEquals(5.0, result);
  }

  @Test
  public void testDivisionByZero() {
    Assertions.assertThrows(ArithmeticException.class, ()->{
      BasicCalculator.divide(100,0);
    });
  }
  @Test
  public void testFindIndexesNoDuplicates() {
    ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList<Integer> expected = new ArrayList<>();
    assertEquals(expected, BasicCalculator.findIndexes(nums, 2)); }
}
