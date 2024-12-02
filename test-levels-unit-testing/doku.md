# JUnit Features

JUnit ist ein weit verbreitetes Framework für Unit-Tests in Java. Hier sind einige der gängigsten Features von JUnit, zusammen mit kurzen Anwendungsfällen und Beispielen.

## 1. @Test Annotation
Die `@Test` Annotation kennzeichnet eine Methode als Testmethode.

### Anwendungsfall
Eine Methode testen, um sicherzustellen, dass sie die erwarteten Ergebnisse liefert.

### Beispiel
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}
