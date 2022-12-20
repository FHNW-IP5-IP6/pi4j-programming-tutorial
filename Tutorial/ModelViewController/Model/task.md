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
Alle Komponenten des MVC-Pattern sollen implementiert werden. Dies beinhaltet Änderungen an der View, dem Model und dem 
Kontroller.

### Programmierung
- Im Model:
  - Ein Observable vom Typ String mit dem Namen *message* soll erstellt werden.
- In der View:
  - Deklaration von LedButton.
  - Initialisation von LedButton.
  - Implementation des Shutdown.
  - Verbindung der Komponenten-Interaktion mit dem Kontroller.
  - Per Aktualisierung des Models soll der neue String ausgegeben werden.
  - Per Aktualisierung des Models soll die LED gesteuert werden.
- Kontroller
  - Auf das Drücken des Buttons: Ein neuer String soll in das Model gespeichert werden.

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