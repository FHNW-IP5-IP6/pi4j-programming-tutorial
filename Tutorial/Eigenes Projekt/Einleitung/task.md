# Task 2/9: Einleitung

## JavaFX Template
Hier die [Theorie](https://pi4j.com/getting-started/javafx-mvc-template/) zum JavaFX-Template.

## 3 Templates
Das JavaFx-Template besteht aus 3 verschiedenen Apps, sowie dem Verzeichnis für Komponenten.

### MultiControllerApp
Die *MultiControllerApp* ist eine App, um aufzuzeigen, wie mit mehreren Controllern gearbeitet werden könnte.
Sie beinhaltet auch ein PUI und GUI zugleich, soll heissen, die App ist die Vollkommenste. Wenn aber im Vorhinein schon 
klar ist, dass kein GUI gebraucht wird, und die Funktionalität der App im kleineren Rahmen ist, dann braucht es nicht 
unbedingt dieses Template.

### TemplateApp
Die *TemplateApp* ist eine App, welche aus einem einzelnen Controller besteht und implementationen für ein GUI und ein PUI 
bereitstellt. Dieses Template sollte genutzt werden, wenn die Funktionialität der App klein ist, aber ein GUI für den 
Benutzer bereitgestellt wird, welches durch die PUI-Komponenten gesteuert wird.

### TemplatePUIApp
Die *TemplatePUIApp* ist somit die vom Umfang her kleinste App. Sie besteht aus einem einzelnen Controller, und implementiert 
nur ein PUI. Das bedeutet, dass hier nichts mit JavaFX gemacht werden muss, sondern es gibt nur direkte Hardware, die 
angesteuert wird. Dieses Template sollte genutzt werden, wenn kein GUI gebraucht wird. Dies ist bspw. der Fall, wenn die 
Visualisierung direkt über andere Hardware gelöst wird.