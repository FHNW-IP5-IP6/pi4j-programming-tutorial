# Task 5/8: Kontroller
In dieser Aufgabe geht es darum, den Kontroller in einer ModelViewController-App zu schreiben.
Auch soll die View noch zusätzlich mit einer SimpleLED erweitert werden.

---
> **_Hinweis:_**
>
> Die Klassen *SimpleButton* und *SimpleLed* wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner view.components eingefügt.
---

## Aufgabe
Vervollständige die View. Erweitere den Kontroller so, dass die LED ein und ausgeschaltet wird.

### Programmierung
- Deklariere die SimpleLed.
- Initialisiere die SimpleLed.
- Registriere auf das Event *onUp* des Buttons die Funktion *ledOff* des Konstruktors.
- Auf das Drücken des Buttons: Aktualisiere das Model, dass die LED leuchten soll.
- Auf das Beenden des Drückens des Buttons: Aktualisiere das Model, dass die LED nicht mehr leuchten soll.
- Setze einen Listener auf das Model, dass die LED steuert.

---
> **_Hinweise:_**
> Die Aufgabe erfordert Änderungen in der View und dem Kontroller.
> 
> Es existiert im Model neu die Variable "LedGlows". Sobald diese auf "True" gesetzt ist, soll auch die LED leuchten.
> Wenn der Button nicht mehr gedrückt wird, soll die LED auch nicht mehr leuchten.
---

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes müssen die LED und der Button mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*LedButton*](https://pi4j.com/examples/components/ledbutton/) zeigt eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *ModelViewController-Kontroller* hinterlegt.