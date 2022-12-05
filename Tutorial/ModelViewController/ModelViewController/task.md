# Task 3/8: Einleitung

## MVC Pattern
Hier die [Theorie](https://pi4j.com/getting-started/javafx-mvc-template/#the-mvc-concept) zum MVC-Pattern.

## Aufgaben der MVC-Komponenten
Das MVC Pattern unterteilt das Programm in die drei Teile Model, View und Controller.

Im Model werden die Daten der Applikation gespeichert.

Die View macht die Daten sichtbar, zum Beispiel in Form einer Tabelle oder eines Diagrams. Es sind auch mehrere Ansichten 
derselben Information möglich.

Der Controller verarbeitet Signale von der View oder von anderen externen Quellen und ruft normalerweise Methoden auf, 
um das Modell anzupassen.

## GUI und PUI
Der Begriff Graphical User Interface (GUI) ist weit verbreitet und steht für eine Schnittstelle zwischen Benutzer (User) 
und Applikation. Eine LED oder ein Button sind keine grafischen, sondern physikalische Elemente. Darum wird an dieser Stelle der 
Begriff Physical User Interface (PUI) verwendet. Als Schnittstelle zum Benutzer sind im MVC Pattern beide Begriffe in 
der View angesiedelt.

![MVC-Konzept](src/mvc-concept.png)