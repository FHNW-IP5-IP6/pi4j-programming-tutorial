# Task 3/8: Einleitung

## MVC Pattern
Hier die [Theorie](https://pi4j.com/getting-started/javafx-mvc-template/#the-mvc-concept) zum MVC-Pattern.

## Aufgaben der MVC-Komponenten
Das MVC Pattern unterteilt das Programm in die drei Teile: Model, View und Controller.

Im Model werden die Daten der Applikation gespeichert.

In der View können auf einzelne Ereignisse wie zum Beispiel *Button pressed* Methoden aus dem Controller aufgerufen werden, 
welche danach das Model aktualisieren. Des Weiteren wird die View verwendet, um Daten vom Modell sichtbar zu machen. Zum Beispiel
könnte die View ein Button haben, welcher je nach Zustand des Models gedrückt oder nicht gedrückt dargestellt wird. Es sind auch 
mehrere Ansichten der gleichen Information möglich. So könnte der Button gedrückt oder nicht gedrückt dargestellt und zusätzlich
ein Text On/Off verwendet werden, um den Zustand nochmals zu verdeutlichen.

Der Controller stellt unterschiedliche Methoden zu Verfügung wie die Daten im Model aktualisiert werden können. Diese Methoden
können dann in der View auf ein bestimmtes Ereignis aufgerufen werden.

## GUI und PUI
Der Begriff Graphical User Interface (GUI) ist weit verbreitet und steht für eine Schnittstelle zwischen Benutzer (User) 
und Applikation. Eine LED oder ein Button sind keine grafischen, sondern physikalische Elemente. Darum wird an dieser Stelle der 
Begriff Physical User Interface (PUI) verwendet. Als Schnittstelle zum Benutzer sind im MVC Pattern beide Begriffe in 
der View angesiedelt.

![MVC-Konzept](./mvc-concept.png)