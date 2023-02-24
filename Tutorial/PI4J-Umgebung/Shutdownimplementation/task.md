# Task 8/10: Shutdown Implementation
In dieser Aufgabe geht es darum, den Context und den Shutdown einer kleinen Applikation mit den minimal benötigten 
Providern selbst zu schreiben. Das Gerüst ist eine Applikation, welche die Interaktion mit einem simplen Button ermöglicht.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleButton* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---
# Aufgabe
## Programmierung
- Erstelle den Context.
- Deregistriere die Funktionen auf dem Button.
- Fahre den Kontext herunter.

---
> **_Hinweis:_**
> Die Aufgabe kann nur in der Klasse Main.java gelöst werden. Die Platzhalter zeigen die Stelle im Code an, die 
> anpassungen benötigen. Im SimpleButton ist ersichtlich, was für I/O Funktionalitäten die Klasse braucht.
---
## Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

## Aufbau
Als Nächstes muss die LED mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*SimpleButton*](https://pi4j.com/examples/components/simplebutton/) zeigt eine mögliche Lösung.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Raspberry Pi ausgeführt zu werden. Dazu ist eine
Running-Config *Einführung-PI4J-Shutdownimplementation* hinterlegt.