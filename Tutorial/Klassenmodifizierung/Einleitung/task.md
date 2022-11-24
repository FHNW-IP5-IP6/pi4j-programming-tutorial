# Task 3/8

Diese Lektion soll eine Einführung in Klassen und Strukturen in Java geben. Wie diese für projektspezifische Anpassungen 
modifiziert werden können und wie eine neue Klasse aus bereits bestehenden Klassen erstellt werden kann.

## Klassen und Strukturen
Lies dir die [Theorie](https://gitlab.fhnw.ch/2022hs-oop1/docs/-/blob/main/woche-06/Klassen.pdf) durch.

## Raspberry PI PIN's
Der GPIO ist der grundlegendste, aber dennoch zugänglichste Aspekt des Raspberry Pi. GPIO-Pins sind digital, was bedeutet, 
dass sie zwei Zustände haben können, aus oder an. Sie können eine Richtung zum Empfangen oder Senden von Strom haben 
(Eingang bzw. Ausgang) und wir können den Zustand und die Richtung der Pins steuern. Die Betriebsspannung der GPIO-Pins 
beträgt 3,3 V bei einer maximalen Stromaufnahme von 16 mA. Dies bedeutet, dass wir eine oder zwei LEDs sicher von einem 
einzelnen GPIO-Pin über einen Widerstand mit Strom versorgen können. Aber für alles, was mehr Strom benötigt, zum 
Beispiel einen Gleichstrommotor, müssen wir externe Komponenten verwenden, um sicherzustellen, dass wir den GPIO nicht 
beschädigen.

Die Pin-Nummerierung von Broadcom (BCM) (auch bekannt als GPIO-Pin-Nummerierung) scheint für den durchschnittlichen 
Benutzer chaotisch zu sein. Das BCM-Pin-Mapping bezieht sich auf die GPIO-Pins, die direkt mit dem System on a Chip (SoC) 
des Raspberry Pi verbunden wurden. Im Wesentlichen haben wir direkte Verbindungen zum Gehirn unseres Pi, um Sensoren und 
Komponenten für die Verwendung in unseren Projekten zu verbinden.

Die meisten Raspberry Pi-Tutorials verwenden die BCM-Nummerierung, da diese das offiziell unterstützte 
Pin-Nummerierungsschema der Raspberry Pi Foundation ist. Es empfiehlt sich daher, mit der Verwendung und dem Erlernen 
des BCM-Pin-Nummerierungsschemas zu beginnen, da es Ihnen mit der Zeit in Fleisch und Blut übergehen wird. Beachten Sie 
auch, dass sich die Pin-Nummerierung von BCM und GPIO auf dasselbe Schema bezieht. So ist zum Beispiel GPIO17 dasselbe 
wie BCM17.
[Weitere Informationen](https://pi4j.com/documentation/pin-numbering/)

## Raspberry PI Ein- und Ausgänge
Bestimmte GPIO-Pins haben auch alternative Funktionen, die es ihnen ermöglichen, mit verschiedenen Arten von Geräten zu
kommunizieren, die die I2C-, SPI- oder UART-Protokolle verwenden. Zum Beispiel sind GPIO3 und GPIO4 auch SDA- und SCL-I2C-Pins,
die verwendet werden, um Geräte mit dem I2C-Protokoll zu verbinden.
Lies dir die [Theorie](https://pi4j.com/documentation/io-examples/) durch.

### Digital Output
Ein digitaler Output übersetzt ein Falsch / Wahr (oder 0 / 1) in einen Ausgangswert von 0V oder 3,3V. Das 
bedeutet, dass jede Art von Gerät, das mit maximal 3,3V arbeitet, ein- oder ausgeschalten werden kann. Das einfachste 
Beispiel ist eine LED. Es muss immer geprüft werden, welches die richtige Eingangsspannung für das Gerät ist!

### Digital Input
Ähnlich wie ein Digital Output-PIN übersetzt ein digitaler Eingang einen Eingangswert von 0V oder 3,3V in den Wert 
Falsch / Wahr. Das bedeutet, dass jede Art von Gerät, das zwischen 3,3V und 0V umschalten kann, einen Eingangswert für 
den Raspberry Pi erzeugen kann. Hier ist das einfachste Beispiel eine Umschalttaste. Wenn andere Komponenten 
verwendet werden, muss immer geprüft werden, welche Spannung das Gerät liefert. Oder wenn ein Power-Pin vom Raspberry Pi 
selbst verwendet wird, ist es ratsam einen 3,3V-Pin und keinen 5V-Pin zu verwenden.

### PWM (Pulse Width Modulation)
Die Abkürzung PWM steht für „Pulse Width Modulation“ und wird im Deutschen auch oft als Pulsweitenmodulation bezeichnet. 
Diese Technologie dient unter anderem zur Steuerung von Servomotoren und wird beispielsweise auch für die Lüfter eines 
normalen Computers verwendet. Mit PWM ist es möglich, eine Komponente wie einen Motor, nicht mehr rein binär, also Aus 
(0 % Leistung) oder An (100 % Leistung), sondern nahezu beliebig zu steuern. Die Funktionalität von PWM funktioniert so, 
dass die Komponente innerhalb einer bestimmten Zeit immer wieder aus- und wieder eingeschaltet wird. Auf dem 
Raspberry Pi sind zwei verschiedene PWM-Typen verfügbar, nämlich eine Software- und eine Hardware-Implementierung. 
Beide bieten grundsätzlich die gleichen Möglichkeiten, allerdings kann die Softwareversion keine präzisen oder besonders 
schnellen Frequenzen erreichen.

### I²C
I²C (gesprochen als I-Quadrat-C) ist ein Bus, der ursprünglich von Philips erfunden wurde. Er ist als klassischer 
Master-Slave-Bus ausgelegt. Eine Datenübertragung wird immer von einem Master initiiert. Es kann auch in einem 
Multi-Master-System aufgebaut werden. I²C wird über zwei Signalleitungen (Datenleitung und Taktleitung) angeschlossen. 
Die Übertragungsrate des Busses kann je nach Taktrate zwischen 0,1 Mbit/s bis 3,4 Mbit/s liegen. Wird nur eine 
unidirektionale Verbindung benötigt, wären sogar 5,0 Mbit/s möglich. Dabei gilt: Je höher die Taktrate, desto 
störanfälliger wird das Gesamtsystem. Auch die geringe Betriebsspannung von nur 3,3V trägt nicht zur Störfestigkeit bei.

### SPI (Serial Peripheral Interface)
Das SPI ist ein Bussystem, das die Kommunikation zwischen einem Hauptgerät (genannt „Master“) und einem oder mehreren 
sekundären Geräten (genannt „Slave“) ermöglicht. Eine direkte Kommunikation zwischen allen Teilnehmern ist hier nicht 
möglich, viel mehr kann der Master jederzeit wählen, mit welchem Slave er Daten austauschen möchte. Um nur einen Slave 
anzusprechen, werden insgesamt 3 Signalleitungen benötigt, von denen Zwei zur bidirektionalen Datenübertragung und eine 
als Taktgeber zur seriellen Übertragung verwendet werden. Sollen weitere Slaves angesprochen werden, werden je nach 
gewünschter Topologie zusätzliche Signalleitungen benötigt.