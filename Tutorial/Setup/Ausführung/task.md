# Task 2/2: Ausführung
In diesem Task wird das [RaspiFX-Template](https://github.com/DieterHolz/RaspPiFX-Template-Project) vorgestellt,
welches für FX-Anwendungen mit PI4J verwendet werden kann. Das Template sollte bei jedem IP12-Projekt als Plattform
genützt werden.

## Remote Ausführung
In diesem Task wurde eine Running-Config hinterlegt. Diese kann wie hier im Bild aufgezeigt ausgewählt werden:

<img src="SetupAusfuehrungRunConfig.png" alt="Run Configuration" width="400"/>

Mit der richtigen ausgewählten Running-Config, wie auf dem Bild gezeigt, kann das Programm gestartet werden.
Die Applikation wird auf das Raspberry Pi geladen und automatisch ausgeführt.
Folgende bekannte Probleme können auftreten:
- Benutzername und Passwort des Raspberry Pi stimmen nicht mit der Running-Config überein -> PW auf Pi oder in Running-Config anpassen.
- Im gleichen Netzwerk gibt es mehr als ein Pi mit dem Namen Crowpi.local oder keinen -> IP-Adresse anstelle von Namen in der Running-Config verwenden.

# Aufgabe

## Programmierung
Versuche, diese App auf dem Raspberry PI zum Laufen zu bringen.

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links.

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *Setup-Ausführung* hinterlegt.