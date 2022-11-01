In diesem Task wird das [RaspiFX-Template](https://github.com/DieterHolz/RaspPiFX-Template-Project) vorgestellt, 
welches für FX-Anwendungen mit PI4J verwendet werden kann. Das Template sollte bei jedem IP12-Projekt als Plattform 
genützt werden.

## Remote Ausführung
In diesem Task wurde eine Running-Config hinterlegt. Diese kann wie hier im Bild aufgezeigt ausgewählt werden:
![RunningConfig](./RunningConfig.png)

Mit der richtigen ausgewählten Running-Config, wie auf dem Bild gezeigt, kann das Programm gestartet werden. 
Die Applikation wird auf das Raspberry Pi geladen und automatisch ausgeführt. 
Folgende bekannte Probleme können auftraten:
- Benutzername und Passwort des Raspberry Pi stimmen nicht mit der Running-Config überein -> Pw auf Pi oder in Running-Config anpassen.
- Im gleichen Netzwerk gibt es mehr als ein Pi mit dem Namen Crowpi.local -> IP-Addresse anstelle von Namen in der Running-Config verwenden.

## RaspiFX Template
Wie man das Template benützt, ist im ReadMe des [RaspiFX-Templates](https://github.com/DieterHolz/RaspPiFX-Template-Project)
beschrieben. Das Template beinhaltet 3 verschiedene Applikationen, die MultiControllerApp, die TemplateApp und die 
TemplatePUIApp. Für das Tutorial verwenden wir das Template Physical User Interface (PUI).

# Aufgabe

## Programmierung
Versuche, diese App auf dem Raspberry PI zum Laufen zu bringen.
Die Aufgabe ist erfüllt, wenn per Knopfdruck die LED ein- und ausgeschaltet werden kann.

## Check Programmierung
Überprüfe die Programmierung mit dem *Check* Button unten links. Ist der Test 
erfolgreich, kannst du mit der Vorbereitung der Hardware beginnen. Ist der Test nicht 
erfolgreich, versuche den Fehler zu beheben. Nutze dazu allfällige Hints oder schau in 
der Lösung nach.

## Aufbau
![Layout](./Layout.png)
![Breadboard](./Breadboard.png)

## Remote Ausführung
Die Applikation ist nun bereit, um auf dem Pi ausgeführt zu werden. Dazu ist eine
Running-Config *Setup-Ausführung* hinterlegt.