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
### Wichtige Testfälle für die Autovermietungsplattform | ID | Beschreibung | Erwartetes Resultat | Effektives Resultat | Status | Mögliche Ursache | |-----|-----------------------------------------------|------------------------------------------------------|----------------------------------------------|--------|---------------------------------------------| | 1 | Programm startet korrekt | Nach dem Aufruf des Programms auf der Konsole öffnet sich ein Fenster | Programm stürzt ab mit Fehler X00234 | Fehler | Zugriff auf DB-Server evtl. nicht möglich | | 2 | Benutzer kann Fahrzeug suchen | Benutzer kann Fahrzeuge nach Marke, Modell und Preis filtern | Fahrzeuge werden nicht korrekt gefiltert | Fehler | Problem mit der Suchfunktion | | 3 | Buchung eines Fahrzeugs | Benutzer kann ein Fahrzeug für einen bestimmten Zeitraum buchen | Buchung schlägt fehl | Fehler | Fehler in der Buchungsmethode | | 4 | Fahrzeugauswahl | Benutzer kann zwischen verschiedenen Fahrzeugen wählen | Fahrzeuge werden nicht korrekt angezeigt | Fehler | Problem mit der Fahrzeugdatenbank | | 5 | Zahlungsvorgang | Benutzer kann die Buchung über eine sichere Zahlungsmethode bezahlen | Zahlungsvorgang schlägt fehl | Fehler | Fehler in der
