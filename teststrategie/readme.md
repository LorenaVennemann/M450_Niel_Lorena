### Aufgabe 1

| Testfall   | Kaufpreis (CHF)             | Erwarteter Rabatt |
|------------|-----------------------------|-------------------|
| Testfall 1 | < 15'000                    | Kein Rabatt       |
| Testfall 2 | 15'000 ≤ Preis < 20'000     | 5% Rabatt         |
| Testfall 3 | 20'000 ≤ Preis < 25'000     | 7% Rabatt         |
| Testfall 4 | ≥ 25'000                    | 8.5% Rabatt       |

| Testfall   | Kaufpreis (CHF) | Endpreis (CHF) |
|------------|------------------|----------------|
| Testfall 1 | 14'999           | 14'999         |
| Testfall 2 | 15'000           | 14'250         |
| Testfall 3 | 19'999           | 18'999.05      |
| Testfall 4 | 20'000           | 18'600         |
| Testfall 5 | 24'999           | 23'249.07      |
| Testfall 6 | 25'000           | 22'875         |
| Testfall 7 | 30'000           | 27'450         |

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


Codeanalyse

Main klasse ist zu gross. man könnte Code in andere Functionen auslagern.   
Klassen sind zu gross. Könnte man kleiner machen.  
Nicht einfach //TO DO oder andere Dinge in den Code schreiben sondern machen oder fixen
