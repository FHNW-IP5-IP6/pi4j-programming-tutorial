# Task 3/10: Einleitung
Diese Lektion soll in die PI4J Umgebung einführen, was ein Context ist, wie man diesen richtig initialisiert,
was Provider sind und wie diese verwendet werden, und weshalb ein Context immer richtig heruntergefahren werden sollte.

## PI4J Context
Lies dir die [Theorie](https://pi4j.com/documentation/create-context/) durch.

## Fallbeispiel
Im Beispiel des SourceCodes wird selbst ein Context zusammengestellt, welcher alle verschiedenen GPIO-Handlers vom 
Provider PiGPIO verwendet. Dies könnte auch abgekürzt werden, und nur die Komponenten verwendet werden, die für die 
Applikation wirklich gebraucht werden.