Dieser Task beinhaltet eine kurze Zusammenfassung, was in dieser Lektion alles gelehrt wurde.

## Hardwarekatalog
Für die Unterstützung in den Projekten IP12 steht den Studierenden der Hardwarekatalog zur Verfügung. Er stellt eine
Auswahl von viel verwendeten Komponenten in den vergangenen Projekten dar und bietet Hilfe in der Montage und Ansteuerung
der Komponente.

Zu jeder Komponente gibt es eine passende Javaklasse, welche ein einfaches Interface für die Ansteuerung bereitstellt.
Zudem stellt der Katalog den Code für eine einfache Beispielapplikation zu Verfügung.

<!-- TODO Zweites Kapitel fehlt, Event Handler -->

## Raspberry PI Pins
Es gibt viele verschiedene Wege, die PINs zu nummerieren. PI4J verwendet hier vorzugshaft die BCM-Nummerierung.
Aufgrund dieser kann dann entsprechend im Code angegeben werden, an welchem GPIO die Komponente hängt.

## Raspberry PI Ein- und Ausgänge
Es gibt verschiedene Funktionen für die GPIO. Bspw. digitale Inputs / Outputs, I2C, SPI oder PWM. Jede davon kann auf
verschiedene Komponenten angewendet werden.