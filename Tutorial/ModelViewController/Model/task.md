# Task 6/8: Model
In dieser Aufgabe geht es darum, das Model in der ModelViewController-App zu schreiben.
Neu soll statt einer LED und einem Button direkt ein LedButton verwendet werden.

---
> **_Hinweis:_**
>
> Die Klassen *LedButton*, *SimpleButton* und *SimpleLed* wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner view.components eingefügt.
---

## Aufgabe
Erstelle eine neue Variable *message* vom Typ String im Model.
Erweitere den Kontroller so, dass die Message im Model gespeichert wird.
Die View muss entsprechend angepasst werden. Die Message soll weiterhin ausgegeben werden, doch neu direkt über die Variable.

### Programmierung
- Im Model:
  - Erstelle ein Observable vom Typ String mit dem Namen "message".
- In der View:
  - Deklariere den LedButton.
  - Initialisiere den LedButton.
  - Implementiere den Shutdown.
  - Verbinde die Komponenteninteraktionen mit dem Kontroller.
- Kontroller
  - Auf das Drücken des Buttons: Aktualisiere das Model mit der neuen Message.
- Gib den String der Message des Models aus, sobald sich dieser ändert.
- Setze den Zustand der LED um, sobald sich das Model ändert.

---
> **_Hinweise:_**
> Die Aufgabe erfordert Änderungen im Model, der View und dem Kontroller.
---

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes muss der LEDButton mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*LedButton*](https://pi4j.com/examples/components/ledbutton/) zeigt eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *ModelViewController-Model* hinterlegt.