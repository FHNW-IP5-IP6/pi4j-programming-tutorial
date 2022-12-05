# Task 5/8: Kontroller
In dieser Aufgabe geht es darum, den Kontroller in der ModelViewController-App zu schreiben und die 
View mit einer LED zu erweitern.

---
> **_Hinweis:_**
>
> Die Klassen *SimpleButton* und *SimpleLed* wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner view.components eingefügt.
---

## Aufgabe
Die View und der Kontroller sollen implementiert werden.

### Programmierung
*View*
- Deklaration von SimpleLed.
- Initialisation von SimpleLed.
- Registration des Event *onUp* des Buttons auf die Funktion *ledOff* des Kontrollers.
- Ein Listener auf die variable *LedGlows* des Models soll die LED steuern.

*Kontroller*
- Auf das Drücken des Buttons: die LED soll leuchten nach update des Models.
- Auf das Beenden des Drückens des Buttons: die LED soll nicht mehr leuchten nach update des Models.

---
> **_Hinweise:_**
> Die Aufgabe erfordert Änderungen in der View und dem Kontroller.
> 
> Es existiert im Model neu die Variable *LedGlows*. Sobald diese auf *True* gesetzt ist, soll auch die LED leuchten.
> Wenn der Button nicht mehr gedrückt wird, soll die LED nicht mehr leuchten.
---

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes müssen die LED und der Button mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*SimpleButton*](https://pi4j.com/examples/components/simplebutton/) und [*SimpleLed*](https://pi4j.com/examples/components/simpleled/) 
zeigen eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *ModelViewController-Kontroller* hinterlegt.