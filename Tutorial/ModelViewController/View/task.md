# Task 4/8: View
In dieser Aufgabe geht es darum, aus einer vorhandenen Klasse [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
(aus dem Hardwarekatalog) eine neue Klasse *Switch* zu erstellen. Ein Button hat die Zustände *Eingeschaltet*, *Ausgeschaltet*
und *aktuell eingeschaltet*. Der Switch soll nur noch die beiden Zustände *Eingeschaltet* und *Ausgeschaltet* haben.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---

## Aufgabe
Erstelle die Klasse Switch und teste diese auf dem Raspberry Pi.

### Programmierung
- Kopiere den Inhalt der Klasse *SimpleButton* in die Klasse Switch
- Lösche alle Kommentare
- Lösche alle Attribute und Methoden, die etwas mit *WhilePressed* zu tun haben

---
> **_Hinweis:_**
> Die Aufgabe kann nur in der Klasse View gelöst werden. Vergiss nicht, die Konstruktoren sollten nicht mehr SimpleButton,
> sondern Switch heissen. Auch im Konstruktor hat es noch WhilePressed Referenzen.
---

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes muss der Switch mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*SimpleButton*](https://pi4j.com/examples/components/simplebutton/) zeigt eine mögliche Lösung.
Für den Testaufbau können als Hardwarekomponente Schalter oder Taster verwendet werden.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *KomponenteErstellen-ImplementationKlassenmodifizierung* hinterlegt.