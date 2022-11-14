Mit einem Event Handler kann ein Softwareentwickler genau steuern, was im Programm geschehen soll, wenn ein bestimmtes
Ereignis eintritt. Die auslösenden Events können dabei unterschiedlichen Ursprungs sein, oft werden sie aber durch 
die Interaktion des Anwenders ausgelöst.

Im Hardwarekatalog werden ebenfalls Event Handler eingesetzt. So wird zum Beispiel bei *SimpleButton* ein Event ausgelöst,
wenn der Button gedrückt wird oder wenn er wieder losgelassen wird.

Welcher Event das Drücken des Buttons auslöst, ist von seiner Programmierung abhängig. Die Klasse *SimpleButton* bietet
ein Handler für den Event *Button ist gedrückt* und für *Button ist wieder los gelassen*. Mit diesen Handlers können dem 
Objekt applikationsspezifische Aufgaben übergeben werden, ohne den Code in *SimpleButton* selber anpassen zu müssen.

Im unten stehenden Code wird die Methode *userFunction* von der Klasse *User* ausgeführt, wenn der Button gedrückt wird.

```
button.onDown(() -> user.userFunction());
```

---
> **_Hinweis:_**
>
> mit **()->** wird ein neuer Thread gestartet in welchem die Methode user.userFunction() läuft. Die genaue 
> Funktion muss an dieser Stelle noch nicht verstanden werden. Es gilt einfach der Syntax:
> 
> onDown( () -> *hier kann eine Funktion aufgerufen werden* );
---