# Task 7/10: Shutdown

## Shutdown
Das Beenden / Zerstören des Kontexts stoppt und gibt alle Ressourcen, Threads, Listener und bereitgestellten I/O-Instanzen 
frei, die vom Kontext gehalten werden. Dies ist nützlich, wenn bspw. mehrere Kontexte für mehrere Komponenten 
aufgebaut werden, und sich diese nicht in den Weg kommen. So kann jeweils ein Kontext heruntergefahren werden, bevor 
der andere instanziiert / gestartet wird.