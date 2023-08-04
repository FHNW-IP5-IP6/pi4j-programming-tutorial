# Task 5/8: Kontroller
In dieser Aufgabe geht es darum, den Controller einer ModelViewController-App zu vervollständigen und die View mit einer LED zu erweitern.


## Aufgabe
Um die Aufgabe zu erfüllen, müssen die Klassen `Controller` und `View` angepasst werden.
> **_Hinweise:_**
> Es existiert im Model neu das Attribut `active`. Wenn das Model im Zustand 'active' ist, soll die LED leuchten und im Zustand 'inactive' dunkel bleiben.

### Programmierung
`Controller`
- Bei 'activate': aktualisiere im Model den Status von `active` und erhöhe  `counter` um 1.
- Bei `deactivate`: setze den Wert von `active` entsprechend.

<div class="hint">
  Die Attribute des Models können mit 'getValue()' und 'setValue()' abgefragt oder geändert werden.
</div>

`ControllerTest`
- vervollständige den JUnit-Test

`View`
- Deklaration von `SimpleLed`.
- Initialisierung von `SimpleLed`.
- Aufruf der Methode `activate()` des Controllers beim Event `onUp()` des Buttons.
- Ein/Ausschalten der LED bei Änderung des Model-Attributes `active`.


### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes müssen die LED und der Button mit dem Raspberry Pi verbunden werden. Das elektrische Layout von
[SimpleButton](https://pi4j.com/examples/components/simplebutton/) und [SimpleLed](https://pi4j.com/examples/components/simpleled/) 
zeigen eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Raspberry Pi ausgeführt zu werden. Dazu ist eine Running-Config *ModelViewController-Kontroller* hinterlegt.