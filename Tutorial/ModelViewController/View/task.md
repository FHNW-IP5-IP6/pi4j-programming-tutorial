# Task 4/8: View
In dieser Aufgabe geht es in einem ersten Schritt darum, nur die View in einer ModelViewController-App zu vervollständigen. Model und Controller sind gegeben und müssen nicht verändert werden.


## Aufgabe
Das PUI besteht ausschliesslich aus einem Taster (einem `SimpleButton`). Es soll bei jedem Tastendruck ein Zähler hochgezählt werden und nach 10-maligem Drücken die Applikation beendet werden.

Dazu muss die Klasse `View` vervollständigt werden. Die Klassen `Model`und `Controller` sind vollständig vorhanden.

### Programmierung von  `View`
- Deklaration von `SimpleButton`
- Initialisierung von `SimpleButton` auf dem PIN 26.
- Implementation des Shutdowns.
- Verbindung der Komponenten-Interaktion (Button wird gedrückt) mit dem Controller.
- Ausgabe des Strings "You pressed the button x times." auf der Konsole bei Model-Änderungen.

<div class="hint">
  Die Methode `onDown()` des Button-Objektes kann benutzt werden, um die Funktion `increaseCounter` des Controllers aufzurufen.
</div>

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes muss der Taster mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[SimpleButton](https://pi4j.com/examples/components/simplebutton/) zeigt eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *ModelViewController-View* hinterlegt. Die App wird sich selbst schliessen, wenn der Taster zehnmal 
gedrückt wurde.