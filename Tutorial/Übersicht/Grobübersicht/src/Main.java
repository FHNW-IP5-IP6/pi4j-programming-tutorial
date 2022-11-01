public class Main {
   public static void main(String[] args) {
      // Leere Klasse, Schaue die Infos in der rechten Übersicht an

      //TODO Delete after usage
      /*
      final var piGpio = PiGpio.newNativeInstance();
        var pi4j = Pi4J.newContextBuilder()
                .noAutoDetect()
                .add(new RaspberryPiPlatform() {
                    @Override
                    protected String[] getProviders() {
                        return new String[]{};
                    }
                })
                .add(PiGpioDigitalInputProvider.newInstance(piGpio),
                        PiGpioDigitalOutputProvider.newInstance(piGpio),
                        PiGpioPwmProvider.newInstance(piGpio),
                        PiGpioSerialProvider.newInstance(piGpio),
                        PiGpioSpiProvider.newInstance(piGpio),
                        LinuxFsI2CProvider.newInstance()
                )
                .build();
        // Run the application
        var app = new LCDDisplay_App();
        app.execute(pi4j);
        // Clean up
        pi4j.shutdown();
       */
   }
}