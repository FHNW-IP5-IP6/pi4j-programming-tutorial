# Task 6/8: Implementation Klassenwiederverwendung
In dieser Aufgabe geht es darum, aus den vorhandenen Klassen [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
und [SimpleLed](https://pi4j.com/examples/components/simpleled/) (aus dem Hardwarekatalog) eine neue Klasse `LedButton` selbst zu erstellen.
Die neue Komponente soll die zwei vorhandenen Objekte mit ihren Methoden zu einer neuen Komponente zusammenfügen.

---
> **_Hinweis:_**
>
> Die Klassen `SimpleButton` und `SimpleLed` wurden bereits aus dem Hardwarekatalog kopiert und in den Ordner src eingefügt. Eigener Code muss nur noch in der Klasse `LedButton` geschrieben werden.
---

## Aufgabe
### Programmierung
## `Main.java`
Bearbeite die TODOs in `Main.java`. Dadurch soll eine Demo-Applikation des neuen `LedButton`entstehen.

## `LedButton.java`
- Deklariere zwei Attribute `led` und `button` vom Typ `SimpleLed` und `SimpleButton`
- Initialisiere die beiden Attribute im Konstruktor von `LedButton`
- Schreibe die unten erwähnten Methoden. Verwende dazu die Methoden von `SimpleLed`.
  - ledOn()
  - ledOff()
  - ledToggle()
- Schreibe die unten erwähnten Methoden. Verwende dazu die Methoden von `SimpleButton`.
  - isDown()
  - isUp()
  - onDown(Runnable)
  - onUp(Runnable)
  - whilePressed(Runnable)
  - reset()

## `LedButtonTest.java`
- Vervollständige den TestCase `LedButtonTest`.
- Überlege welche Funktionalität sinnvollerweise getestet werden sollte
- Damit getestet werden kann werden zwei weitere Methoden in `LedButton` benötigt
  - `mockLed()`
  - `mockButton()`
  - Welchen Rückgabetyp müssen diese Methoden jeweils haben?

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
Running-Config *Klassenmodifizierung-ImplementationKlassenwiederverwendung* hinterlegt.