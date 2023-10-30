# Task 6/10: Providerwahl

## Aufgabe
Welcher I/O Provider sollte laut Hardware-Katalog von LinuxFS genutzt werden, anstatt von PiGpio?

<div class="hint">
Die I2C Funktionen sollten vom Provider LinuxFSgenutzt werden, da der PiGPIO-I2C Provider nicht sauber in die Register der Komponenten schreiben kann. PiGPIO hat Probleme mit dem Timing des I2C. Dies kann zu Problemen mit dem LCD-Display führen.
</div>