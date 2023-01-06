# Task 2/2: Ausführung
In diesem Task wird eine kleine Applikation mit PI4J aufgezeigt, welche auf dem Raspberry PI ausgeführt werden soll.
Was die Applikation genau macht, wird in einer späteren Lektion genauer erklärt.

## Remote Ausführung
In diesem Task wurde eine Running-Config hinterlegt. Diese kann wie hier im Bild aufgezeigt ausgewählt werden:

<img src="SetupAusfuehrungRunConfig.png" alt="Run Configuration" width="400"/>

Mit der richtigen ausgewählten Running-Config, kann das Programm gestartet werden.
Die Applikation wird auf das Raspberry Pi geladen und automatisch ausgeführt.
Folgende bekannte Probleme können auftreten:
- Benutzername und Passwort des Raspberry Pi stimmen nicht mit der Running-Config überein -> PW auf Pi oder in Running-Config anpassen.
- Im gleichen Netzwerk gibt es mehr als ein Pi mit dem Namen Crowpi.local oder keinen -> IP-Adresse anstelle von Namen in der Running-Config verwenden.

# Aufgabe

## Programmierung
Im Code auf der linken Seite wird zuerst der Pi4J Context erstellt. Danach wird auf der Konsole die beiden Strings:
"Application is running" und "Application is done" ausgegeben, bevor das Programm wieder endet.

---
> **_Hinweis:_** Der Code wird zu einem späteren Zeitpunkt genau erklärt und muss hier nicht verstanden werden.
---

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *Setup-Ausführung* hinterlegt.

Konnte die Applikation erfolgreich auf dem Raspberry Pi ausgeführt werden kann mit dem Button *Next* zum nächsten Task
gewechselt werden.