In diesem Task wird das [RaspiFX-Template](https://github.com/DieterHolz/RaspPiFX-Template-Project) vorgestellt, 
welches für FX-Anwendungen mit PI4J verwendet werden kann. Das Template sollte bei jedem IP12-Projekt als Plattform 
genützt werden.

## Remote Ausführung
In diesem Task wurde eine Running-Config hinterlegt. Diese kann wie hier im Bild aufgezeigt ausgewählt werden:
![RunningConfig](./RunningConfig.png)
Mit der richtigen ausgewählten Running-Config, wie auf dem Bild gezeigt, kann das Programm gestartet werden. 
Die Applikation wird auf das Raspberry Pi geladen und automatisch ausgeführt.
Folgende bekannte Probleme können auftraten:
Benutzername und Passwort des Raspberry Pi stimmen nicht mit der Running-Config überein -> Pw auf Pi oder in Running-Config anpassen.
Im gleichen Netzwerk gibt es mehr als ein Pi mit dem Namen Crowpi.local -> IP-Addresse anstelle von Namen in der Running-Config verwenden.

## RaspiFX Template
Wie man das Template benützt, ist im ReadMe des [RaspiFX-Templates](https://github.com/DieterHolz/RaspPiFX-Template-Project)
beschrieben. Das Template beinhaltet 3 verschiedene Applikationen, die MultiControllerApp, die TemplateApp und die 
TemplatePUIApp. Für das Tutorial verwenden wir das Template Physical User Interface (PUI).

## Aufgabe
Versuche, diese App auf dem Raspberry PI zum Laufen zu bringen. Dazu hier als Hilfestellung das Schema und ein Foto, wie 
die Komponenten mit dem Raspberry PI verdrahtet werden müssen.
![Layout](./Layout.png)
![Breadboard](./Breadboard.png)
Die Aufgabe ist erfüllt, wenn per Knopfdruck die LED ein- und ausgeschaltet werden kann.

<div class="hint">
Dieser Task muss über die Remote-Ausführung gestartet werden. Per Check wird nur geprüft, ob der Code kompiliert. Dies 
ist immer der Fall, wenn nichts am Code geändert wurde. Wenn die Ausführung erfolgreich war, kann per Check der nächste 
Task begonnen werden.
</div>