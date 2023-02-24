# Task 4/10: Standardcontext
In dieser Aufgabe geht es darum, den Context einer kleinen Applikation mit den minimal benötigten Providern selbst zu schreiben.
Das Gerüst ist eine Applikation, welche die Interaktion mit einer simplen LED ermöglicht.

---
> **_Hinweis:_**
>
> Die Klasse *SimpleLed* wurde bereits aus dem Hardwarekatalog kopiert und
> in den Ordner src eingefügt.
---
# Aufgabe
## Programmierung
- Erstelle den Context.

---
> **_Hinweis:_**
> Die Aufgabe kann nur in der Klasse Main.java gelöst werden. Der Platzhalter zeigt an, wo. In der SimpleLed ist ersichtlich,
> was für I/O Funktionalitäten die Klasse braucht.
---
## Check Programmierung
Die Programmierung lässt sich mit dem Button *Check* überprüfen. Nach erfolgreich abgeschlossenem Test kann mit der
Erstellung der Hardware begonnen werden. Ist der Test nicht erfolgreich, muss zuerst der Fehler behoben werden. Dabei können
allfällige Hints oder ein Blick in die Lösung helfen.

## Aufbau
Als Nächstes muss die LED mit dem Raspberry Pi richtig verbunden werden. Das elektrische Layout von
[*SimpleLed*](https://pi4j.com/examples/components/simpleled/) zeigt eine mögliche Lösung.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *Einführung-PI4J-Standardcontext* hinterlegt.