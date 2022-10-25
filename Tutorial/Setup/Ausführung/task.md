In diesem Task wird das [RaspiFX-Template](https://github.com/DieterHolz/RaspPiFX-Template-Project) vorgestellt.
Dies ist ein Template, welches für FX-Anwendungen mit PI4J verwendet werden kann. Es implementiert bereits einen 
Launcher, welcher das Programm interaktiv startet, und über [Maven](https://maven.apache.org/) wird die Applikation 
gebaut und ausgeführt, je nach Konfiguration auf der eigenen Workstation oder direkt auf einem Remote-Gerät, wie bspw. 
dem Raspberry PI.

## Remote Ausführung
In diesem Task wurde eine Running-Config hinterlegt. Diese kann wie hier im Bild aufgezeigt ausgewählt werden:
![RunningConfig](./RunningConfig.png)
Mit dieser Konfiguration ausgewählt, kann die Ausführung nun gestartet werden.
(Falls es zu Fehlern kommen sollte, muss die Konfiguration angepasst werden. Bspw. kann es vorkommen, dass der 
Benutzername oder das Passwort des eigenen Raspberry PI nicht übereinstimmt mit der Konfiguration. Oder vielleicht 
gibt es im gleichen Netzwerk mehrere Devices mit dem Hostnamen "Crowpi.local", dann müsste dort die IP eingetragen werden.)

Dies hier ist ein Edu-Task. Das bedeutet, dass hier der Code getestet wird. Jedoch wird hier noch nicht gefordert, dass 
eigener Code erzeugt wird, sondern es wird geprüft, ob das Device richtig bereitgestellt ist, und das Programm laufen könnte.

## RaspiFX Template
Wie man das Template benützt, ist im ReadMe des [RaspiFX-Templates](https://github.com/DieterHolz/RaspPiFX-Template-Project)
beschrieben. Das Template beinhaltet 3 verschiedene Applikationen, die MultiControllerApp, die TemplateApp und die 
TemplatePUIApp. PUI steht hier für Physical User Interface, bspw. beinhaltet dies Sensoren und Aktuatoren auf dem Raspberry PI.
In diesem Tutorial wird das Template der PUI-App verwendet. Die Struktur ist hier in diesem Task bereits aufgebaut. 
Die App implementiert das MVC-Pattern, dies wird in einer späteren Lektion eingeführt.

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