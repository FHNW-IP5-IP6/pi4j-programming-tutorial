# Task 3/10: Projektstart

## Simon Says
Simon Says ist ein Memory-Spiel. Es gibt 2 Spieler, Simon und der Anwender. Simon gibt eine Sequenz vor, beispielsweise 
von Symbolen oder Farben. Der Anwender muss dann versuchen, die Sequenz möglichst genau zu imitieren. Somit kann auch 
ausgewertet werden, wie viel Anteil von der Sequenz durch den Anwender richtig imitiert werden konnte.

Um das zu verdeutlichen, wurde im Editor ein *Simon says* implementiert, welches hier per *Run* gespielt werden kann.

## Hardware Ansatz
Diese Lektion beschäftigt sich damit, solch ein *Simon says* selbst zu implementieren und zu designen. Dazu gehört auch, 
selbst ein Schema zu entwerfen und dieses mit dem Code abzustimmen. Es gibt eine Musterlösung. Diese verwendet 4 *LedButtons*. 
Diese *LedButtons* werden zuerst in einer Reihenfolge aufleuchten, und dann muss der Benutzer diese Reihenfolge drücken. 
Zu Beginn einer neuen Sequenz soll jeweils auf der Console eine Meldung abgesetzt werden, und dann die Sequenz von Simon 
angezeigt werden.
Falls die Sequenz in der richtigen Reihenfolge gedrückt wird, so wird auf der Console eine Erfolgsmeldung ausgegeben. 
Falls in der Sequenz eine falsche Eingabe kommt, soll sofort abgebrochen werden und eine Fehlermeldung ausgegeben werden. 
Dann kann wieder von Vorne angefangen werden.