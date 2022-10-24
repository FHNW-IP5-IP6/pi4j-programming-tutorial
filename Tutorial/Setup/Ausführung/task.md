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