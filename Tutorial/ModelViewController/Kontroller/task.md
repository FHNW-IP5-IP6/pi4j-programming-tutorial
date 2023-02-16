# Task 5/8: Kontroller
In dieser Aufgabe geht es darum, den Kontroller in der ModelViewController-App zu schreiben und die 
View mit einer LED zu erweitern.
> **_Hinweis:_**
>
> Die Klassen *SimpleButton* und *SimpleLed* wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner view.components eingefügt.

## Aufgabe
Um die Aufgabe zu erfüllen, müssen die Klassen *Controller.java* und *View.java* angepasst werden.
> **_Hinweise:_**
> Es existiert im Model neu die Variable *LedGlows*. Diese soll den Zustand der LED wiedergeben. TRUE bedeutet, die LED
> leuchtet und FALSE bedeutet, die LED ist dunkel.

### Programmierung
*Kontroller*
- Auf das Ereignis Button gedrückt: aktualisiere im Model den Status von *ledGlows*.
- Auf das Ereignis Button nicht mehr gedrückt: aktualisiere im Model den Status von *ledGlows*.

<div class="hint">
  Die Variablen des Models können mit <i>GetValue</i> und <i>SetValue</i> abgefragt oder geändert werden.
</div>

*View*
- Deklaration von SimpleLed.
- Initialisation von SimpleLed.
- Registration der Funktion *ledOff* vom Kontroller beim Event *onUp* des Buttons.
- Mit *LedGlows* des Models die LED steuern.

<div class="hint">
  Für die Registration von <i>ledOff</i> und die Ansteuerung der LED kann fast die gleiche Syntax wie für <i>pressButton</i>
oder die Ausgabe des Counters verwendet werden.
</div>


### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes müssen die LED und der Button mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*SimpleButton*](https://pi4j.com/examples/components/simplebutton/) und [*SimpleLed*](https://pi4j.com/examples/components/simpleled/) 
zeigen eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Raspberry Pi ausgeführt zu werden. Dazu ist eine
Running-Config *ModelViewController-Kontroller* hinterlegt.