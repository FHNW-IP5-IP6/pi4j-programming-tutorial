# Task 4/8: View
In dieser Aufgabe geht es darum, die View in einer ModelViewController-App zu schreiben.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner view.components eingefügt.
---

## Aufgabe
Die View soll vervollständigt werden. Das Model und der Kontroller sind in diesem Task noch absichtlich ausgeblendet.

### Programmierung
- Deklaration von SimpleButton
- Initialisation von SimpleButton.
- Implementation den Shutdown.
- Verbindung der Komponenten-Interaktion mit dem Kontroller.
- Ausgabe des Strings "You pressed the button x times." auf der Konsole bei Model-Änderungen.

---
> **_Hinweise:_**
> Die Aufgabe kann nur in der Klasse View gelöst werden.
> 
> Der Kontroller besitzt die Funktion *pressButton()*. Die Funktion vergrössert die Variable *counter* im Model.
> 
> Es gibt die Funktion *onChangeOf()*, welche einen Listener in der View registriert auf die spezifizierte Variable des Models.
---

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes muss der Button mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*SimpleButton*](https://pi4j.com/examples/components/simplebutton/) zeigt eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *ModelViewController-View* hinterlegt. Die App wird sich selbst schliessen, wenn der Button Zehnmal 
gedrückt wurde.