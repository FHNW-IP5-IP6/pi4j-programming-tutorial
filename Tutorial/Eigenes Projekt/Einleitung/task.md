# Task 2/7: Einleitung

## JavaFX Template
Hier die [Theorie](https://pi4j.com/getting-started/javafx-mvc-template/) zum JavaFX-Template.

## 3 Templates
Das JavaFx-Template besteht aus 3 verschiedenen Apps, sowie dem Verzeichnis für Komponenten.

### MultiControllerApp
Die *MultiControllerApp* bietet die Möglichkeit mehrere Controller in der gleichen Applikation zu steuern. Sie stellt eine 
PUI und eine GUI Klasse zu Verfügung. Es können also gleichzeitig Hardwarebauteile und grafische Objekte umgesetzt werden.
Die *MultiControllerApp* ist eine App, um aufzuzeigen, wie mit mehreren Controllern gearbeitet werden könnte. 

### TemplateApp
Die *TemplateApp* ist eine App, welche aus einem einzelnen Controller besteht und implementationen für ein GUI und ein PUI 
bereitstellt. Dieses Template sollte genutzt werden, wenn die Funktionalität der App klein ist, aber ein GUI für den 
Benutzer bereitgestellt wird, welches zum Beispiel durch die PUI-Komponenten gesteuert wird.

### TemplatePUIApp
Die *TemplatePUIApp* ist, die vom Umfang her, kleinste App. Sie besteht aus einem einzelnen Controller und implementiert 
nur ein PUI. Die Applikation benötigt keien JavaFX Komponenten, sondern nur Hardware Bauteile. Die Visualisierung wird dabei 
ausschliesslich durch Hardwarekomponenten realisiert. 