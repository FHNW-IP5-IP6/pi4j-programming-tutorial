Klassen können, in anderen Klassen, wiederverwendet oder referenziert werden.
Lies dazu die Theorie in Woche Acht des FHNW Modules OOP1 [hier](https://gitlab.fhnw.ch/2022hs-oop1/docs/-/blob/main/woche-08/Datenkapselung%20und%20verkn%C3%BCpfte%20Objekte.pdf)

## Objekt Referenzierung

Es ist möglich, eine neue Klasse zu schreiben, welche die Methoden und Attribute von anderen Klassen verwendet und in einem
einzelnen Objekt zusammenfasst. Dazu muss als Attribut der neuen Klasse ein Objekt der referenzierten Klasse mitgegeben, 
und die Methoden der neuen Klasse müssen die Methoden der referenzierten Klasse entsprechen aufrufen. So kann beispielsweise 
in der Hardware-Welt ein LED-Button, bestehend aus einem Button und einer LED, als eigene Komponente aufgebaut werden.
Von der Hardware sieht es so aus, dass ein PIN des Raspberry PI den Input des Buttons auswertet, während ein anderer PIN 
den Output auf die LED der gleichen Komponente steuert.