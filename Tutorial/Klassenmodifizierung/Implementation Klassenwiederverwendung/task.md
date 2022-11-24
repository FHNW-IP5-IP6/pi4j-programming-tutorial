# Task 6/8: Implementation Klassenwiederverwendung
In dieser Aufgabe geht es darum, aus den vorhandenen Klassen [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
und [SimpleLED](https://pi4j.com/examples/components/simpleled/) (aus dem Hardwarekatalog) eine neue Klasse Switch zu erstellen.
Die neue Komponente soll die zwei vorhandenen Objekte mit ihren Methoden als eine eigene neue Komponente zusammenfügen.

---
> **_Hinweis:_**
>
> Die Klassen *SimpleButton* und *SimpleLED* wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt. Eigener Code muss nur noch in der Klasse LedButton geschrieben werden.
---

## Aufgabe
### Programmierung
- Deklariere zwei Objekte led und button mit SimpleLed und SimpleButton
- Initialisiere dei beiden Objekte im Konstruktor von LedButton
- Schreibe die unten erwähnten Methoden. Verwende dazu die Methoden von *led*.
  - ledSetState(boolean)
  - ledSetStateOn()
  - ledSetStateOff()
  - ledToggleState()
  - ledGetDigitalOutput()
- Schreibe die unten erwähnten Methoden. Verwende dazu die Methoden des instanziierten *SimpleButton*.
  - btnGetState()
  - btnIsDown()
  - btnIsUp()
  - btnGetDigitalInput()
  - btnOnDown(Runnable)
  - btnOnUp(Runnable)
  - btnWhilePressed(Runnable)
  - btnDeRegisterAll()
  - btnGetOnUp()
  - btnGetOnDown()
  - btnGetWhilePressed()

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes muss der LedButton mit dem Raspberry Pi richtig verbunden werden. Nutze dazu die
Dokumentation [*LedButton*](https://pi4j.com/examples/components/ledbutton/)
des Hardwarekataloges auf der Pi4J Webseite.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *KomponenteErstellen-ImplementationKlassenwiederverwendung* hinterlegt.