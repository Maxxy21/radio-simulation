public class Main {
    public static void main(String[] args) {
        Radio meinRadio = new Radio();

        System.out.println("Anfänglicher Status:");
        meinRadio.displayStatus();

        System.out.println("\nRadio einschalten:");
        meinRadio.turnOn();

        System.out.println("\nLautstärke direkt auf 55 einstellen:");
        meinRadio.setVolume(55);

        System.out.println("\nWechseln Sie in den AM-Modus und stellen Sie die Frequenz auf 1000 kHz ein:");
        meinRadio.switchToAM();
        meinRadio.setFrequency(1050);

        System.out.println("\nLautstärke verringern:");
        meinRadio.decreaseVolume();

        System.out.println("\nRadio stummschalten:");
        meinRadio.mute();

        System.out.println("\nVersuchen Sie, die Lautstärke zu erhöhen, wenn sie gedämpft sind (die Dämpfung sollte aufgehoben werden):");
        meinRadio.increaseVolume();

        System.out.println("\nWechseln Sie zurück in den FM-Modus und stellen Sie die Frequenz auf 96,5 MHz ein:");
        meinRadio.switchToFM();
        meinRadio.setFrequency(96.5);

        System.out.println("\nLautstärke verringern:");
        meinRadio.decreaseVolume();

        System.out.println("\nEndstatus:");
        meinRadio.displayStatus();

        System.out.println("\nRadio ausschalten:");
        meinRadio.turnOff();
    }
}
