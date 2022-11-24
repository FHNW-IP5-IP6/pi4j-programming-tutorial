# Task 8/11: Implementation Button
In dieser Aufgabe geht es darum das Signal eines Buttons (gedrückt) auszuwerten. Dazu wird die Klasse [SimpleButton](https://pi4j.com/examples/components/simplebutton/)
aus dem Hardwarekatalog verwendet. Auf das Ereignis *Button gedrückt* soll sich der Zustand der LED ändern.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---

# Aufgabe
## Programmierung
- Deklariere das Objekt *button* vom Typ Simple Button
- Initialisiere das Objekt *button*. Verwende dazu den Pin 26 auf dem Raspberry Pi
- Wenn der Button gedrückt wird, soll sich der Zustand der LED ändern. Verwende dazu die Methode *toggleState* von SimpleLED
- Nachdem die Zeit von 15s abgelaufen ist (nach sleep(15000)) soll die LED ausgeschalten werden damit zum Schluss ein
definierter Zustand erreicht wird
- Als letzte Ergänzung soll der Handler wieder deregistriert werden.

---
> **_Hinweis:_**
> 
> Die Aufgabe kann zwischen den Zeilen **Start coding space** und **End coding space** gelöst werden.
> Was oberhalb und unterhalb dieser Zeilen steht wird benötigt, dass die Applikation funktioniert.
> Die genaue Bedeutung wird zu einem späteren Zeitpunkt erklärt.
---

<div class="hint">
Eine Beispielanwendung ist bei der Komponente <a href="https://pi4j.com/examples/components/simplebutton/">Simple Button</a>
auf der Pi4J Webseite programmiert.
</div>

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links. Ist der Test
erfolgreich, kannst du mit der Vorbereitung der Hardware beginnen. Ist der Test nicht
erfolgreich, versuche den Fehler zu beheben. Nutze dazu allfällige Hints oder schau in
der Lösung nach.

## Aufbau
Als Nächstes muss der Button mit dem Raspberry Pi richtig verbunden werden. Nutze dazu die
Dokumentation [*SimpleButton*](https://pi4j.com/examples/components/simplebutton/)
des Hardwarekataloges auf der Pi4J Webseite.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *NeuesProjekt-ImplementationButton* hinterlegt.