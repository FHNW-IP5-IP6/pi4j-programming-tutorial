# Task 4/9: Einführung Raspberry Pi
Dieser Task gibt eine kurze Einführung in die GPIO Pins des Raspberry Pi.

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