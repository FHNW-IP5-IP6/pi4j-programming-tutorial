Das Ziel dieses Tasks ist die Erweiterung der Template-Applikation mit einer weiteren Komponente aus dem Katalog.
Dazu wurde bereits eine Klasse unter catalog.components vorbereitet. Dort kann der Code der Komponente hineinkopiert werden.

## Aufbau
Das Model beinhaltet einen Platzhalter, wo der "momentane" Text für das LCD gespeichert werden sollte.

Sobald sich nun das Model aktualisiert, sollte dies per Binding auch auf dem LCD passieren. Dazu hat es einen Platzhalter 
im view. Auch wird dort die Komponente initialisiert. Selbst für dies sind Platzhalter vorgesehen.

Nun muss noch der Kontroller angepasst werden, dass sich jeweils das Model ändert. Auch für das wurden wieder Platzhalter 
implementiert.

## Aufgabe
Implementiere das zusätzliche LCDDisplay. Im Code hat es überall Platzhalter, wo Code geschrieben werden muss.

<div class="hint">
Wenn die Applikation erweitert wurde, sollte auch die Komponente am Raspberry PI angeschlossen werden. Dazu kann per 
PI4J-Webseite geschaut werden, wie ein LCD-Display ans Raspberry PI angehängt wird.
Danach sollte noch die Run-Config gestartet werden, damit der Code auch auf dem Raspberry PI ausgeführt wird.
</div>