### Aufgabe 1

| Testfall   | Kaufpreis (CHF)             | Erwarteter Rabatt |
|------------|-----------------------------|-------------------|
| Testfall 1 | < 15'000                    | Kein Rabatt       |
| Testfall 2 | 15'000 ≤ Preis < 20'000     | 5% Rabatt         |
| Testfall 3 | 20'000 ≤ Preis < 25'000     | 7% Rabatt         |
| Testfall 4 | ≥ 25'000                    | 8.5% Rabatt       |

| Testfall   | Kaufpreis (CHF) | Erwarteter Rabatt |
|------------|------------------|-------------------|
| Testfall 1 | 14'999           | Kein Rabatt       |
| Testfall 2 | 15'000           | 5% Rabatt         |
| Testfall 3 | 19'999           | 5% Rabatt         |
| Testfall 4 | 20'000           | 7% Rabatt         |
| Testfall 5 | 24'999           | 7% Rabatt         |
| Testfall 6 | 25'000           | 8.5% Rabatt       |
| Testfall 7 | 30'000           | 8.5% Rabatt       |

### Aufgabe 2
### Wichtige Testfälle für die Autovermietungsplattform 

| ID         | Beschreibung                  | Erwartetes_Result | Effektives_Resultat| Status           | Mögliche Ursache  |
|------------|-------------------------------|-------------------   |--------------------|------------------|------------------ |
|     1      | Benutzer kann Fahrzeug suchen | Benutzer kann Fahrzeuge nach Marke, Modell und Preis filtern.      |  Benutzer kann Fahrzeuge nach Modell und Preis filtern, jedoch nicht nach Marke.          | false           | Filter wurde nicht gefunden       |
|     2      | Benutzer kann die Webseite aufrufen                      | Benutzer kann die geladene Webseite besichtigen         | Bentuzer sieht die Webseite      | true          | -      |
|     3      | Benutzer kann Fahrzeug wählen                      | Benutzer kann zwischen mehreren Fahrzeugen aussuchen.         | Bentuzer kann zwischen verschiedenen Autos aussuchen         | true         | -     |
|     4      | Zusätzliche Optionen                      | Benutzer kann zusäztliche Optionen wählen         | Benuter kann die Optionen aussuchen       | true           | -   |
|     5      | Zahlungsmethode                        | Benutzer kann mit einer sicheren Zahlungsmethode bezahlen        | Zahlungsmethoden sind sicher        | true         | -       |

### Aufgabe 3

## Black-Box Testfälle

| Testfall          | Beschreibung       |
|-------------------|--------------------|
| Geld abheben      |                    |
| Geld einzahlen    |                    |
| Konto erstellen   |                    |
| Konto löschen     |                    |

## Geeignete Funktionen für White Test Fälle

Theoretisch sind für alle Funktionen White Test Fälle, mithilfe von Mock-Daten, möglich. Jedoch haben viele Funktionen in diesem Code große Abhängigkeiten mit anderen Funktionen oder Klassen.  

Klassen mit eher weniger Abhängigkeiten:

| Klasse            | Beschreibung       |
|-------------------|--------------------|
| printAccountsList |                    |
| deleteAccount     |                    |
| createAccount     |                    |
