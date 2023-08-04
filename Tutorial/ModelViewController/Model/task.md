# Task 6/8: Model
In dieser Aufgabe geht es darum, das Model in der ModelViewController-App zu erweitern.
Neu soll statt einer LED und einem Button direkt ein LedButton verwendet werden.

> **_Hinweis:_**
>
> Die Klassen `LedButton`, `SimpleButton` und `SimpleLed` wurden bereits aus dem Hardwarekatalog kopiert und
> in den Ordner view.components eingefügt.

## Aufgabe
Um die Aufgabe zu erfüllen, müssen die Klassen `Model`, `Controller`, `ControllerTest` und `View` angepasst werden.

### Programmierung
- `Model`
  - Erweiterung um ein ObservableValue vom Typ String mit dem Namen `message`.
- `View`
  - Deklaration eines `LedButton`.
  - Initialisation des `LedButton`.
  - Implementation des Shutdown.
  - Verbindung der Komponenten-Interaktion mit dem Controller.
  - Per Aktualisierung des Models soll die neue Message ausgegeben werden und die LED gesteuert werden.
- Controller
  - bei `activate`: Die aktuelle Message soll im Model gespeichert werden.

### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können allfällige Hints oder ein Blick in die Lösung helfen.

### Aufbau
Als Nächstes muss der LEDButton mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[LedButton](https://pi4j.com/examples/components/ledbutton/) zeigt eine mögliche Lösung.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Raspberry Pi ausgeführt zu werden. Dazu ist eine Running-Config *ModelViewController-Model* hinterlegt.