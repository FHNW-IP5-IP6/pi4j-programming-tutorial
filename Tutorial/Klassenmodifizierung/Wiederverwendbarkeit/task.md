# Task 5/8: Wiederverwendbarkeit
Klassen können in anderen Klassen wiederverwendet werden. 

## Klassen wiederverwenden
Eine effektive Methode, eine neue Klasse für ein Bauteil zu schreiben, ist zu klären, ob es Klassen gibt, welche einzelne
Grundfunktionalitäten des Bauteiles bereits abdecken. Wird eine Klasse `LedButton` benötigt, liegt es nahe, Methoden aus den 
Klassen `SimpleLed` und `SimpleButton` zu verwenden, um die gewünschten Methoden zu realisieren.

Um zum Beispiel die LED von `LedButton` mit einer Methode `ledOn()` einzuschalten muss in dieser Methode nur die 
Methode von `SimpleLed` `on()` aufgerufen werden.