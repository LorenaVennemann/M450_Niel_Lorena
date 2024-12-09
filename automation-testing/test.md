# Load Testing Dokumentation

## Ziel
Das Ziel dieses Tests war es, das Backend mit größerem Traffic zu belasten, um die Performance, Stabilität und Fehleranfälligkeit unter hoher Last zu prüfen.

## Tools
### 1. Postman
- **Funktionalitäten**:
  - Testen von API-Endpunkten mit Skripten.
  - Automatisierte Testabläufe über die Collection Runner.
  - Geeignet für einfache Lasttests mit begrenzter Benutzeranzahl.
- **Einsatz im Test**:
  - Simulierung von bis zu 1000 API-Aufrufen hintereinander.
  - Validierung der Antwortzeiten und Statuscodes.
- **Ergebnisse**:
  - Gut geeignet für grundlegende Tests, aber nicht für massive Traffic-Simulation.

### 2. Apache JMeter
- **Funktionalitäten**:
  - Simulierung von hoher Benutzeranzahl und Last (z. B. 1000+ Nutzer gleichzeitig).
  - Unterstützung für HTTP, FTP, JDBC, und mehr.
  - Listener zur Analyse von Durchsatz, Antwortzeit und Fehlern.
- **Einsatz im Test**:
  - Simulierung von 1000 Nutzern über 10 Minuten.
  - Messung von Antwortzeiten, Durchsatz und Fehlerquoten.
- **Ergebnisse**:
  - Sehr gute Skalierbarkeit und detaillierte Performance-Metriken.

## Test-Szenario
- **Testgegenstand**: API-Endpunkt `/api/test`.
- **Simulierte Benutzeranzahl**: 1000.
- **Dauer**: 10 Minuten.
- **Metriken**:
  - Antwortzeit (ms).
  - Durchsatz (Requests pro Sekunde).
  - Fehlerquote (%).

## Ergebnisse
### Postman
- **Durchschnittliche Antwortzeit**: ~200 ms.
- **Maximale Fehlerquote**: 5%.
- **Limitierungen**:
  - Postman konnte keine echte Parallelität simulieren.
  - Nicht geeignet für umfangreiche Lasttests.

### JMeter
- **Durchschnittliche Antwortzeit**: ~150 ms.
- **Maximale Fehlerquote**: 1%.
- **Durchsatz**: 100 Requests/Sekunde.
- **Vorteile**:
  - Exakte Simulation von gleichzeitigem Nutzerverhalten.
  - Umfangreiche Berichte und Analysen.

## Fazit
- **Postman** ist nützlich für kleine Testszenarien und erste Validierungen.
- **JMeter** eignet sich hervorragend für größere Lasttests und liefert detaillierte Metriken.

## Empfehlungen
1. Nutze Postman für funktionale Tests und einfache Iterationen.
2. Verwende JMeter für realistische Lasttests und Performance-Analysen.
3. Optimiere das Backend basierend auf den Ergebnissen (z. B. Reduzierung der Antwortzeit, Skalierung der Infrastruktur).

## Nächste Schritte
- Weiterführende Tests mit JMeter bei noch höherer Benutzeranzahl.
- Integration von automatisierten Lasttests in die CI/CD-Pipeline.
