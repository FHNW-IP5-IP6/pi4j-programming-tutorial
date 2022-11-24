# Task 5/10: Provider

## PI4J Provider
Lies dir die [Theorie](https://pi4j.com/documentation/providers/) durch.

## Verfügbare Provider
- PiGpio
  - Pro
    - Nativ die am besten performende
    - Kann per Remote ausführung genutzt werden
  - Contra
    - braucht sudo
- LinuxFS
  - Pro
    - Generisch für alle SoC, welche LinuxFS unterstützen
    - braucht kein sudo
  - Contra
    - Latenz