# Simon Says
In dieser Aufgabe geht es darum ein eigenes Simon Says zu erstellen. Die wichtigsten Funktionen der Applikation sind hier 
nochmals kurz erwähnt:
- Start der Applikation durch einen Button
- Simon gibt eine Farbfolge vor und der Spieler muss diese wiedergeben können
- Wird eine Farbfolge erfolgreich wiedergegeben, ist die nächste Farbfolge um eine Farbe länger
- Bei einem Fehler wird das Spiel beendet, mit einem Taster kann danach ein neues Spiel gestartet werden

## Model
In einem ersten Schritt geht es darum im Model die benötigten Variablen zu definieren.

Als Hilfestellung sind alle Variablen aufgelsitet, welche in der Musterlösung verwendet werden.
<div class="hint">
 <I>level</I> vom Typ Integer -> mit jedem Level wird eine LED mehr angezeigt<br>
 <I>startNumberOfLed</I> vom Typ Integer -> Offset um zu definieren wie viele LED bei Level 1 leuchten sollen<br>
 <I>led0IsGlowing</I> vom Typ Boolean -> Zustand von LED<br>
 <I>led1IsGlowing</I> vom Typ Boolean -> Zustand von LED<br>
 <I>led2IsGlowing</I> vom Typ Boolean -> Zustand von LED<br>
 <I>led3IsGlowing</I> vom Typ Boolean -> Zustand von LED<br>
 <I>sequence</I> vom Typ ArrayList -> Die aktuelle LED Reihenfolge welch es zu lösen gilt<br>
 <I>numberOfPressedLed</I> vom Typ Integer -> Zeigt wie viele LED im aktuelle Level bereits betätigt wurden<br>
 <I>message</I> vom Typ String -> String um Mitteilungen an den Spieler über die Kommandozeile auszugeben<br>
</div>

## Kontroller
Als nächstes müssen im Kontroller sämtliche Methoden erstellt werden welche benötigt werden, um das Modell zu aktualisieren.

Ein möglicher Lösungsansatz ist es das Spiel in zwei Teile, Sequenz zeigen und Sequenz abfragen, zu unterteilen. 

### Sequenz zeigen
Zuerst soll eine zufällige Sequenz generiert werden.
<div class="hint">
//creat random sequence<br>
for (int i = 0; i < get(model.sequence).size(); i++){<br>
    Random random = new Random();<br>
    get(model.sequence).set(i, random.nextInt(4));<br>
}<br>
</div>
Danach sollen die LED entsprechend ein und ausgeschalten werden.

 <div class="hint">
   for (int i = 0; i < (get(model.startNumberOfLed)+get(model.level)-1); i++){<br>
            int currentLed = get(model.sequence).get(i);<br>
            if (currentLed == 0){<br>
                setValue(model.led0IsGlowing,true);<br>
                sleep(1000);<br>
                setValue(model.led0IsGlowing,false);<br>
                sleep(500);<br>
            }else if (currentLed == 1){<br>
                setValue(model.led1IsGlowing,true);<br>
                sleep(1000);<br>
                setValue(model.led1IsGlowing,false);<br>
                sleep(500);<br>
            }else if (currentLed == 2){<br>
                setValue(model.led2IsGlowing,true);<br>
                sleep(1000);<br>
                setValue(model.led2IsGlowing,false);<br>
                sleep(500);<br>
            }else if (currentLed == 3){<br>
                setValue(model.led3IsGlowing,true);<br>
                sleep(1000);<br>
                setValue(model.led3IsGlowing,false);<br>
                sleep(100);<br>
            }<br>
        }<br>
 </div>

### Sequenz abfragen
Bei jedem Button der gedrückt wird muss natürlich kontrolliert werden, ob die Sequenz noch stimmt. Doch es müssen noch weitere
Fragen geklärt werden:
- läuft das Spiel bereits
- ist das nächste Level erreicht
- ist das Spiel beendet

Überprüfe ob das Spiel bereits läuft
<div class="hint">
//if level is 0 start new game<br>
if(get(model.level) == 0){<br>
    newGame();<br>
//game is running<br>
}else{<br>
    //do something<br>
}<br>
</div>

Überprüfe ob die richtige Sequenz eingehalten wird

<div class="hint">
//check if right button is pressed<br>
if(btnNumber == get(model.sequence).get(get(model.numberOfPressedLed))){<br>
    increase(model.numberOfPressedLed);<br>
    sleep(100);<br>
    setValue(model.message, "Your " + get(model.numberOfPressedLed) +" button was button number "+ btnNumber + ". This was right.");<br>
}else{<br>
    setValue(model.message, "You pressed the wrong button. press any button to restart the game");<br>
    setValue(model.level,0);<br>
    return;<br>
}<br>
</div>

Überprüfe ob das Level oder das Spiel beendet ist
<div class="hint">
//check if level is completed<br>
if(get(model.numberOfPressedLed) >= get(model.startNumberOfLed)+get(model.level)-1){<br>
    setValue(model.message, "You have completed level" + get(model.level));<br>
    increase(model.level);<br>
    //check if game is completed<br>
    if(get(model.level)+get(model.startNumberOfLed) > get(model.sequence).size()){<br>
        setValue(model.message, "You have finished the game, press any button to restart the game");<br>
        setValue(model.level,0);<br>
        return;<br>
    }<br>
    showNewSequence();<br>
    setValue(model.numberOfPressedLed, 0);<br>
}<br>
</div>

## View
In der View geht es nun noch darum die LED Buttons richtig zu implementieren. Dies wurde bereits in den vorangehenden 
Aufgaben ausreichend besprochen.

Hier ist nochmals eine Hilfsstellung für die ModelToUIBindigns
<div class="hint">
onChangeOf(model.led0IsGlowing).execute((oldValue, newValue) -> {<br>
    ledButtons[0].ledSetState(newValue);<br>
});<br>
<br>
onChangeOf(model.led1IsGlowing).execute((oldValue, newValue) -> {<br>
    ledButtons[1].ledSetState(newValue);<br>
});<br>
<br>
onChangeOf(model.led2IsGlowing).execute((oldValue, newValue) -> {<br>
    ledButtons[2].ledSetState(newValue);<br>
});<br>
<br>
onChangeOf(model.led3IsGlowing).execute((oldValue, newValue) -> {<br>
    ledButtons[3].ledSetState(newValue);<br>
});<br>
<br>
onChangeOf(model.message).execute(((oldValue, newValue) -> System.out.println(newValue)));<br>
</div>
