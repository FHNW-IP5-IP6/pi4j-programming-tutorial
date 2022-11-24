# Task 7/8
Dieser Task beinhaltet eine kurze Zusammenfassung, was in dieser Lektion alles gelehrt wurde.

## Klassen / Strukturen
Klassen sind Baupläne für Objekte, welche wiederum Instanzen von Klassen sind. Objekte bestehen aus Attributen, Konstruktoren 
und Methoden. Die Struktur von Objekten sollte immer die gleiche sein, beginnend mit den Attributen, gefolgt von den Konstruktoren 
und Methoden.

## Klassen modifizieren
Klassen, vor allem auch im Umfeld von Hardware-Komponenten, können häufig kopiert und modifiziert werden, wenn beispielsweise 
ähnliche Methoden gebraucht werden.

## Klassen wiederverwenden
Vorhandene Klassen können auch gut wiederverwendet werden. Dazu wird bei den Attributen des neuen Objektes das alte 
Objekt mitgegeben, im Konstruktor wird das Objekt instanziiert, und per neuen Methoden werden die Methoden des 
referenzierten Objektes angesprochen.

## Raspberry PI Pins
Es gibt viele verschiedene Wege, die PINs zu nummerieren. PI4J verwendet hier vorzugshaft die BCM-Nummerierung. 
Aufgrund dieser kann dann entsprechend im Code angegeben werden, an welchem GPIO die Komponente hängt.

## Raspberry PI Ein- und Ausgänge
Es gibt verschiedene Funktionen für die GPIO. Bspw. digitale Inputs / Outputs, I2C, SPI oder PWM. Jede davon kann auf 
verschiedene Komponenten angewendet werden.