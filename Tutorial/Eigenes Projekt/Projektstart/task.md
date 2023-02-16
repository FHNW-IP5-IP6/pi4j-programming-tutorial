# Task 3/7: Projektstart

## Simon Says
Simon Says soll als Memory-Spiel realisiert werden. Simon wird durch einen Computer dargestellt und schaltet 4 LEDs in
unterschiedlicher Reihenfolge ein und aus. Der Spieler muss nun versuchen, die Reihenfolge wiederzugeben, so wie diese von Simon
vorausgesagt wurde.

Eine mögliche Variante des Spiels ist im Editor umgesetzt. Mit dem Button *Run* kann die Demonstration gestartet werden.

## Hardware Ansatz
Diese Lektion beschäftigt sich damit, solch ein *Simon says* selbst zu implementieren und zu designen. Die wichtigsten Aufgaben 
dabei sind:
- elektrische Schema entwerfen
- passende Bauteile definieren
- Applikation programmieren
- Applikation testen

Die Musterlösung besteht aus 4 *LedButtons* welche in einer vom Computer zufälligen Reihenfolge aufleuchten. Diese Reihenfolge
muss danach durch die Spieler exakt wiedergegeben werden. Zu Beginn einer neuen Sequenz soll jeweils auf der Console eine 
Meldung abgesetzt werden, und dann die Sequenz von Simon starten.

Falls die Sequenz durch die Spieler in der richtigen Reihenfolge gedrückt wird, so wird auf der Console eine Erfolgsmeldung ausgegeben. 
Falls in der Sequenz eine falsche Eingabe kommt, wird sofort abgebrochen und eine Fehlermeldung ausgegeben. 
Dann kann wieder von Vorne angefangen werden.

## Ausführung
Falls das *SimonSays* per Klick auf Run nicht ausführbar ist, muss hier wieder die RunConfiguration auf das eigene Setup 
angepasst werden. Diese RunConfiguration heisst *EigenesProjekt-Projektstart* und sieht etwas anders aus als wie gewohnt.