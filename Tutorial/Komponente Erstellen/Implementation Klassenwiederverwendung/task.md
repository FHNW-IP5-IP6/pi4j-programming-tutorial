In dieser Aufgabe geht es darum, aus den vorhandenen Klassen [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
und [SimpleLED](https://pi4j.com/examples/components/simpleled/) aus dem Hardwarekatalog eine neue Klasse Switch zu erstellen.
Die neue Komponente soll die zwei vorhandenen Objekte mit ihren Methoden als eine eigene neue Komponente zusammenfügen.

---
> **_Hinweis:_**
>
> Die Klassen *SimpleButton* und *SimpleLED* wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt. Eigener Code muss nur noch in der Klasse LEDButton geschrieben werden.
---

# Aufgabe
## Programmierung
- Erstelle die Attribute, welche die Objekte *SimpleButton* und *SimpleLED* referenzieren
- Instanziiere die Attribute mit den Objekten
- Schreibe die unten erwähnten Methoden. Verwende dazu die Methoden der instanziierten *SimpleLED*.
  - LEDsetState(boolean)
  - LEDsetStateOn()
  - LEDsetStateOff()
  - LEDtoggleState()
  - LEDgetDigitalOutput()
- Schreibe die unten erwähnten Methoden. Verwende dazu die Methoden des instanziierten *SimpleButton*.
  - btngetState()
  - btnisDown()
  - btnisUp()
  - btngetDigitalInput()
  - btnonDown(Runnable)
  - btnonUp(Runnable)
  - btnwhilePressed(Runnable)
  - btndeRegisterAll()
  - btngetOnUp()
  - btngetOnDown()
  - btngetWhilePressed()

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links. Ist der Test
erfolgreich, kannst du mit der Vorbereitung der Hardware beginnen. Ist der Test nicht
erfolgreich, versuche den Fehler zu beheben. Nutze dazu allfällige Hints oder schau in
der Lösung nach.

## Aufbau
Als Nächstes muss der LEDButton mit dem Raspberry Pi richtig verbunden werden. Nutze dazu die
Dokumentation [*LEDButton*](https://pi4j.com/examples/components/ledbutton/)
des Hardwarekataloges auf der Pi4J Webseite.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *KomponenteErstellen-ImplementationKlassenwiederverwendung* hinterlegt.