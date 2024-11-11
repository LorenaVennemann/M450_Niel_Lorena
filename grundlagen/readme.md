Aufgabe 1
Unit-Tests:

Beschreibung: Testen einzelne Komponenten oder Module eines Programms.

Durchführung: In der Regel automatisiert mit Testframeworks wie JUnit für Java. Jeder Test prüft eine Funktion oder Methode auf erwartetes Verhalten.

Integrationstests:

Beschreibung: Testen das Zusammenspiel mehrerer Komponenten oder Systeme.

Durchführung: Kombination verschiedener Module wird getestet, um sicherzustellen, dass sie zusammenarbeiten. Tools wie Selenium können hier verwendet werden.

End-to-End-Tests (E2E):

Beschreibung: Testen das gesamte System, vom Anfang bis zum Ende, in einer realistischen Umgebung.

Durchführung: Simulieren reale Benutzeraktionen, um sicherzustellen, dass das gesamte System wie erwartet funktioniert. Tools wie Cypress oder Puppeteer werden häufig eingesetzt.

Aufgabe 2: 
Beispiel eines Software-Fehlers:

Beschreibung: Ein Software-Fehler tritt auf, wenn das Programm nicht wie erwartet funktioniert. Zum Beispiel könnte eine Funktion in einer Banking-App falsche Kontostände anzeigen.

Hoher Schaden: Ein solcher Fehler könnte zu finanziellen Verlusten und Vertrauensverlust bei Kunden führen.

Beispiel eines Software-Mangels:

Beschreibung: Ein Software-Mangel bezieht sich auf Anforderungen, die nicht erfüllt werden. Zum Beispiel könnte eine App wichtige Sicherheitsfunktionen missen.

Hoher Schaden: Ein Sicherheitsmangel könnte zu Datenlecks und schweren Datenschutzverletzungen führen.

Aufgabe 3:
Beispielcode:
java
public class PriceCalculation {
    public double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;
        
        if (extras >= 5) {
            addon_discount = 15;
        } else if (extras >= 3) {
            addon_discount = 10;
        } else {
            addon_discount = 0;
        }
        
        result = baseprice / 100.0 * (100 - discount) + specialprice + extraprice / 100.0 * (100 - addon_discount);
        
        return result;
    }
}

public class PriceCalculationTest {
    public boolean test_calculate_price() {
        PriceCalculation calc = new PriceCalculation();
        double price;
        boolean test_ok = true;
        
        // Beispiel-Tests
        price = calc.calculatePrice(1000, 200, 300, 3, 5);
        if (price != 1235.0) test_ok = false;
        
        price = calc.calculatePrice(1000, 200, 300, 5, 5);
        if (price != 1215.0) test_ok = false;
        
        return test_ok;
    }
    
    public static void main(String[] args) {
        PriceCalculationTest test = new PriceCalculationTest();
        if (test.test_calculate_price()) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Tests failed.");
        }
    }
}

Bonus: 
Der Fehler im ursprünglichen Code liegt in der Bedingung für den addon_discount. Das richtige if-else-Konstrukt sollte prüfen, ob extras >= 5 zuerst und dann extras >= 3. Zudem soll der Händlerrabatt nicht überschrieben werden.