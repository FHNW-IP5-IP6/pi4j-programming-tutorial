# Task 3/9: Hardwarekatalog

Der Hardwarekatalog stellt zu unterschiedlichen elektronischen Bauteilen wie zum
Beispiel einem LCD-Display, einem LED-Streifen oder einem Servo-Motor diverse Hilfestellungen
zur Verfügung. Er ist ein Teil von [The Pi4J Project](https://github.com/Pi4J) und lässt sich grob in zwei Teile
unterteilen.

Der erste Teil ist das Repository [Java I/O Library for Raspberry Pi](https://github.com/Pi4J/pi4j-example-components),
welches zu jedem Bauteil eine passende [Java Klasse](https://github.com/Pi4J/pi4j-example-components/tree/main/src/main/java/com/pi4j/catalog/components) zur Verfügung stellt.
Zudem gibt es zu jeder Klasse ein [Beispiel](https://github.com/Pi4J/pi4j-example-components/tree/main/src/main/java/com/pi4j/catalog/applications) welches die Implementation der
Klasse erklärt.

---
> **_Hinweis:_** Benötigte Java Klassen können aus dem Katalog kopiert und im Programm
> an der richtigen Stelle eingefügt werden.
---


Der zweite Teil des Katalogs bildet die Dokumentation auf der
[Pi4J](https://pi4j.com/) Webseite. Das Kapitel [Component Examples](https://pi4j.com/examples/components/) ist eine Auflistung sämtlicher im
Katalog umgesetzter Bauteile. Zu jedem Bauteil gibt es einen detaillierten Eintrag über
die wichtigsten Funktionen der Java Klasse, ein elektrisches Layout und den
Java-Code der Beispielapplikation.

Neben der Beschreibung der einzelnen Bauteile verlinkt die Webseite zusätzlich
auf zwei grössere Applikationen, [Photobooth](https://github.com/DieterHolz/PhotoBooth) und
[Theremin](https://github.com/DieterHolz/RaspPiTheremin), welche beide
mit Bauteilen aus dem Hardwarekatalog realisiert wurden.
