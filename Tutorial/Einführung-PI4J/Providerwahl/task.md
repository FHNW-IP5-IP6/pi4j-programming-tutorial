# Task 6/10: Providerwahl

## Aufgabe
Welcher I/O Provider sollte laut Hardware-Katalog von LinuxFS genutzt werden, anstatt von PiGPIO?

<div class="hint">
Die I2C Funktionen sollten vom Provider LinuxFS genutzt werden, da der PiGPIO-I2C Provider nicht schön in die Register 
der Komponenten schreiben kann. Dies kann zu Problemen mit dem LCD-Display führen.
</div>