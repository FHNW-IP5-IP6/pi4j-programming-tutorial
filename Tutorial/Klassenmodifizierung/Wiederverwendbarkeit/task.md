# Task 5/8
Klassen können in anderen Klassen wiederverwendet oder referenziert werden.
Lies dazu die Theorie in Woche Acht des FHNW Moduls OOP1 [hier](https://gitlab.fhnw.ch/2022hs-oop1/docs/-/blob/main/woche-08/Datenkapselung%20und%20verkn%C3%BCpfte%20Objekte.pdf)

## Klassen wiederverwenden
Eine effektive Methode, eine neue Klasse für ein Bauteil zu schreiben ist zu klären, ob es Klassen gibt welche einzelne
Grundfunktionalitäten des Bauteiles bereits abdeckt. Wird eine Klasse LedButton benötigt, liegt es nahe Methoden aus den 
Klassen *SimpleLed* und *SimpleButton* zu verwenden. Instanziiert man in der Klasse *LedButton* zwei Objekte *led* von *SimpleLed* 
und *button* von *SimpleButton* ist bereits der Hauptteil der Programmierung für die Klasse erledigt. Um die LED von *LedButton* 
mit einer Methode *ledSetStateOn()* einzuschalten muss in dieser Methode nur die Methode von *SimpleLed* *on()* aufgerufen
werden.