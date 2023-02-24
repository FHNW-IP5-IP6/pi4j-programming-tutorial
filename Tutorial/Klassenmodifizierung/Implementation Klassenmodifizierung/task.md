# Task 4/8: Implementaion Klassenmodifizierung
In dieser Aufgabe geht es darum, aus der vorhandenen Klasse [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
(aus dem Hardwarekatalog) eine neue Klasse *Switch* zu erstellen. Ein Button hat die Zustände *Eingeschaltet*, *Ausgeschaltet*
und *aktuell eingeschaltet*. Der Switch soll nur noch die beiden Zustände *Eingeschaltet* und *Ausgeschaltet* haben.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---

## Aufgabe
Erstelle die Klasse Switch und teste diese auf dem Raspberry Pi.

### Programmierung
- Kopiere den Inhalt der Klasse *SimpleButton* in die Klasse Switch
- Lösche alle Kommentare
- Lösche alle Attribute und Methoden, die etwas mit *WhilePressed* zu tun haben
- Deklariere, Initialisiere und registriere Funktionen für den Switch
- Deregistriere alle Funktionen des Switches

---
> **_Hinweis:_**
> Die Aufgabe soll in den Klassen Main und Switch gelöst werden. Vergiss nicht, die Konstruktoren sollten nicht mehr SimpleButton,
> sondern Switch heissen. Auch im Konstruktor hat es noch WhilePressed Referenzen.
---

<div class="hint">
Der Name switch ist bereits von Java Funktionen belegt. Somit muss ein anderer Name für den Switch beim deklarieren 
gewählt werden.
</div>

<div class="hint">
Die Main.java könnte wie folgt aussehen:
<pre style="background-color: #eee;border: 1px solid #999;display: block;padding: 2px;">
// Run the application
System.out.println("Application is running");

// Create a new Switch component
Switch obj = new Switch(pi4j, PIN.D26, false);

// Register functions to the States of the switch
obj.onDown(() -> System.out.println("XXX"));
obj.onUp(() -> System.out.println("YYY"));

// Running the App for 15 Seconds
sleep(15000);

// DeRegistering functions before shutting down
obj.deRegisterAll();

// End of application
System.out.println("Application is done");
</pre>
</div>


### Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der 
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen. 

### Aufbau
Als Nächstes muss der Switch mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von 
[*SimpleButton*](https://pi4j.com/examples/components/simplebutton/) zeigt eine mögliche Lösung. 
Für den Testaufbau können als Hardwarekomponente Schalter oder Taster verwendet werden.

### Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *Klassenmodifizierung-ImplementationKlassenmodifizierung* hinterlegt.