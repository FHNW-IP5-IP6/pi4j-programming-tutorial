# Task 9/10: Zusammenfassung
Dieser Task beinhaltet eine kurze Zusammenfassung, was in dieser Lektion alles abgedeckt wurde.

## PI4J Context
Der Kontext ist ein unveränderliches Laufzeitobjekt, das den konfigurierten Zustand enthält und den Lebenszyklus einer 
Pi4J-Instanz verwaltet. Er enthält alle geladenen Plugins, Anbieter, Plattformen, I/O-Instanzregistrierung, 
Umgebungskonfiguration und Laufzeitobjekte, einschließlich Executor-Thread-Pools, I/O-Ereignis-Listener usw.

## PI4J Provider
Provider sind erweiterbare Servicemodule, die für die konkrete Implementierung eines bestimmten I/O-Typs verantwortlich 
sind. Mehrere Anbieter für denselben I/O-Typ können gleichzeitig in einen Pi4J-Kontext geladen werden. Beispielsweise 
könnten ein „RaspberryPi-DigitalInputProvider“ und ein „GertBoard-DigitalInputProvider“ beide geladen werden, und beide 
gleichzeitig digitale Eingänge bereitstellen.

## Shutdown
Es ist wichtig, den Kontext jeweils wieder richtig herunterzufahren. So können Probleme mit Überladungen und nachträglichen 
Funktionsaufrufen vermieden werden.