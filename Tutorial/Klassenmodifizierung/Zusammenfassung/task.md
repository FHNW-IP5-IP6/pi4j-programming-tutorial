# Task 7/8: Zusammenfassung
Dieser Task beinhaltet eine kurze Zusammenfassung, was in dieser Lektion alles gelehrt wurde.

## Klassen / Strukturen
Klassen sind Baupläne für Objekte. Objekte bestehen aus Attributen, Konstruktoren und Methoden. Die Struktur von Objekten 
sollte immer die gleiche sein, beginnend mit den Attributen, gefolgt von den Konstruktoren und Methoden.

## Klassen modifizieren / wiederverwenden
Für neue Klassen können häufig Codeelemente aus bestehenden Klassen kopiert und angepasst werden. Diese Technik führt zu 
einem Schnellen Ergebnis aber auch zu viel dupliziertem Code was sich wiederum auf Qualität des Codes auswirkt. Eine
bessere Lösung ist dabei bestehende Klassen in einer neuen Klasse wiederzuverwenden. Somit können neue Klassen auf die 
speziellen Eigenschaften von Bauteilen zugeschnitten werden ohne die Applikation mit unnötigem Code zu vergrössern.

## Raspberry PI Pins
Es gibt viele verschiedene Wege, die PINs zu nummerieren. PI4J verwendet hier vorzugshaft die BCM-Nummerierung. 
Aufgrund dieser kann dann entsprechend im Code angegeben werden, an welchem GPIO die Komponente hängt.

## Raspberry PI Ein- und Ausgänge
Es gibt verschiedene Funktionen für die GPIO. Bspw. digitale Inputs / Outputs, I2C, SPI oder PWM. Jede davon kann auf 
verschiedene Komponenten angewendet werden.