# Task 4/8: Implementaion Klassenmodifizierung
In dieser Aufgabe geht es darum, aus einer vorhandenen Klasse [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
(aus dem Hardwarekatalog) eine neue Klasse Switch zu erstellen. Ein Button hat die Zustände *Eingeschaltet*, *Ausgeschaltet*
und *aktuell eingeschaltet*. Der Switch soll nur noch die beiden Zustände *Eingeschaltet* und *Ausgeschaltet* haben.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---

## Aufgabe
### Programmierung
- Kopiere den Inhalt der Klasse *SimpleButton* in die Klasse Switch
- Lösche alle Kommentare
- Lösche alle Attribute, die etwas mit *WhilePressed* zu tun haben
- Lösche alle Methoden, die *WhilePressed* direkt referenzieren

---
> **_Hinweis:_**
> Die Aufgabe kann nur in der Klasse Switch gelöst werden. Vergiss nicht, die Konstruktoren sollten nicht mehr SimpleButton,
> sondern Switch heissen. Auch im Konstruktor hat es noch WhilePressed Referenzen.
---

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der 
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen. 

### Aufbau
Als Nächstes muss der Switch mit dem Raspberry Pi richtig verbunden werden. Nutze dazu die
Dokumentation [*SimpleButton*](https://pi4j.com/examples/components/simplebutton/)
des Hardwarekataloges auf der Pi4J Webseite. Es kann ein Switch oder ein Button verwendet werden.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *KomponenteErstellen-ImplementationKlassenmodifizierung* hinterlegt.