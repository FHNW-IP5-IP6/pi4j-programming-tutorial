# Task 7/9: Implementation LED
In dieser Aufgabe geht es darum eine LED anzusteuern. Dazu wird die Klasse [SimpleLed](https://pi4j.com/examples/components/simpleled/)
aus dem Hardwarekatalog verwendet.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleLed* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---

# Aufgabe
## Programmierung
- Deklariere das Objekt *led* vom Typ SimpleLed
- Initialisiere das Objekt *led*. Verwende dazu den Pin 19 (PWM Pin) auf dem Raspberry Pi
- Schalte die LED ein
- Blinklicht
  - Schalte die LED fünfmal ein und aus
  - Nutze dazu die Methode *toggleState* von SimpleLed in einem *for-loop*
  - Nutze die Methode *sleep()* um jedes Mal 1s zu warten, bis die LED den Zustand wechselt
- Schalte die LED aus

---
> **_Hinweis:_**
>
> Die Aufgabe kann zwischen den Zeilen **Start coding space** und **End coding space** gelöst werden.
> Was oberhalb und unterhalb dieser Zeilen steht wird benötigt, dass die Applikation funktioniert.
> Die genaue Bedeutung wird zu einem späteren Zeitpunkt erklärt.
---

<div class="hint">
Eine Beispielanwendung ist bei der Komponente <a href="https://pi4j.com/examples/components/simpleled/">SimpleLed</a>
auf der Pi4J Webseite programmiert.
</div>

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links. Ist der Test
erfolgreich, kannst du mit der Vorbereitung der Hardware beginnen. Ist der Test nicht
erfolgreich, versuche den Fehler zu beheben. Nutze dazu allfällige Hints oder schau in
der Lösung nach.

## Aufbau
Als Nächstes muss die LED mit dem Raspberry Pi richtig verbunden werden. Nutze dazu die
Dokumentation [*SimpleLed*](https://pi4j.com/examples/components/simpleled/)
des Hardwarekataloges auf der Pi4J Webseite.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *NeuesProjekt-ImplementationLED* hinterlegt.