# Pi4J Programming Tutorial

Learn how to implement awesome Raspberry Pi projects based on Pi4J, the library that provides a friendly object-oriented API for Java Programmers to access the full I/O capabilities of the Raspberry Pi platform.

Dieses Repository ist ein Leitfaden und Tutorial in deutscher Sprache, um in die Programmierung und speziell die APIs der Java-Library Pi4J einzuführen. Damit dieses Tutorial gestartet werden kann, muss in IntelliJ [JetBrains Academy](https://plugins.jetbrains.com/plugin/10081-jetbrains-academy) installiert werden.

## Installation des Raspberry Pis

Verwenden Sie das [Pi4J-Basic-OS](https://pi4j-download.com/latest.php?flavor=basic) Image, um die SD-Card des Raspberry Pis zu bespielen. Dieses Image enthält alle für die Entwicklung mit Pi4J notwendigen Installationen und Konfigurationen.

Für eine Beschreibung siehe [Pi4J Operating System](https://pi4j.com/pi4j-os/).

## Installation auf dem Developer Computer

Wenn IntelliJ geöffnet ist, kann über die Webseite [JetBrains Academy](https://plugins.jetbrains.com/plugin/10081-jetbrains-academy) direkt das Plugin auf die IDE installiert werden.

Das Plugin kann auch direkt in der IDE installiert werden. Dazu kann per `File → Settings → Plugins` (`IntelliJ IDEA → Preferences → Plugins` auf MacOS) das Plugin installiert werden, so wie hier aufgezeigt:
![JetBrains Academy Plugin](images/Edutools-Plugin.png)

Das zweite Plugin, welches installiert werden muss, ist [Embedded Linux JVM Debugger for Raspberry PI](https://plugins.jetbrains.com/plugin/18849-embedded-linux-jvm-debugger-for-raspberry-pi):
![Embedded Linux JVM Debugger for Raspberry PI](images/Raspi-JVM.png)


## Tutorial starten mit Kursdatei

Auf dem Welcome Screen von IntelliJ kann, bei *My Courses* über die drei Punkte, die Kursdatei geöffnet werden.

![Welcome to IntelliJ IDEA](images/WelcomeToIntellijIDEA.png)

Bevor der Kurs mit dem *Start* Button gestartet werden kann, muss zuerst bei den Settings überprüft werden, dass mindestens JDK Version 17 ausgewählt ist.

![Start Course](images/StartCourse.png)

Die Kursdatei als *Trust Project* öffnen

![Trust Project](images/TrustProject.png)

Der Kurs ist nun mit der Hautpseite geöffnet.

## Kurs aus diesem Projekt heraus starten

Es ist auch möglich lediglich das Tutorial als 'Preview' zu starten, der vom aktuellen Stand dieses Projekts generiert wird.

Um den Kurs-Preview zu starten, muss per Rechtsklick auf oberster Ebene im Kurs das Menu "Course Creator → Create Course Preview" ausgewählt werden.

![EduTools Kursstart](images/EduTools-Kursstart.png)

Durch diese Aktion öffnet sich ein zweiter IntelliJ Editor, der das Tutorial in der Lernform beinhaltet. Hier bitte warten, bis Gradle das Projekt fertiggestellt hat.
