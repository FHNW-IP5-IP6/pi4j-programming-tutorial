## PI4J Provider
Lies dir die [Theorie](https://pi4j.com/documentation/providers/) durch.

## Verfügbare Provider
- PiGpio
  - Pro
    - Most performant at this moment, natively
    - Can be used remotely
  - Contra
    - Needs to run as sudo
- LinuxFS
  - Pro
    - Generic for any SoC supporting LinuxFS
    - Doesn’t need sudo
  - Contra
    - Latency (? - still to be tested)