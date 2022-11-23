In dieser Aufgabe geht es darum, aus einer vorhandenen Klasse [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
(aus dem Hardwarekatalog) eine neue Klasse Switch zu erstellen. Ein Switch hat die Zuständen Ein- und Ausgeschalten, 
ein Button hat noch den Zustand *aktuell eingeschaltet*.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---

# Aufgabe
## Programmierung
- Kopiere den Inhalt der Klasse *SimpleButton* in die Klasse Switch
- Lösche alle Kommentare
- Lösche alle Attribute, die etwas mit *WhilePressed* zu tun haben
- Lösche alle Methoden, die *WhilePressed* direkt referenzieren
- Lösche im Konstruktor im switch das IF-Statement mit dem *WhilePressed*

---
> **_Hinweis:_**
> Die Aufgabe kann nur in der Klasse Switch gelöst werden. Vergiss nicht, die Konstruktoren sollten nicht mehr SimpleButton,
> sondern Switch heissen.
---

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links. Ist der Test
erfolgreich, kannst du mit der Vorbereitung der Hardware beginnen. Ist der Test nicht
erfolgreich, versuche den Fehler zu beheben. Nutze dazu allfällige Hints oder schau in
der Lösung nach.

## Aufbau
Als Nächstes muss der Switch mit dem Raspberry Pi richtig verbunden werden. Nutze dazu die
Dokumentation [*SimpleButton*](https://pi4j.com/examples/components/simplebutton/)
des Hardwarekataloges auf der Pi4J Webseite. Es kann ein Switch oder ein Button verwendet werden.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *KomponenteErstellen-ImplementationKlassenmodifizierung* hinterlegt.