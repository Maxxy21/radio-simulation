/**
 * Stellt ein einfaches Radio dar, mit Funktionen wie Ein-/Ausschalten,
 * Lautstärkeregelung und Frequenzeinstellung.
 *
 * @author Maxwell Aboagye
 */
public class Radio {

    private static final int MAX_VOLUME = 10;
    private static final int MIN_VOLUME = 0;
    private static final double MIN_FREQUENCY = 88.0;
    private static final double MAX_FREQUENCY = 108.0;

    private boolean isOn;
    private int volume;
    private double frequency;


    /**
     * Standardkonstruktor, der ein Radio im ausgeschalteten Zustand initialisiert,
     * mit einer Standardlautstärke und frequenz.
     */
    public Radio() {
        this.isOn = false;
        this.volume = 0;
        this.frequency = 88.0;
    }


    private void ensureRadioIsOn() {
        if (!isOn) {
            System.out.println("Operation nicht möglich, Radio ist AUS");
            throw new IllegalStateException("Radio ist AUS");
        }
    }

    /**
     * Schaltet das Radio ein.
     * Wenn das Radio bereits eingeschaltet ist, wird eine entsprechende Nachricht angezeigt.
     */
    public void turnOn() {
        if (isOn) {
            System.out.println("Radio ist bereits EIN");
            return;
        }
        isOn = true;
        System.out.println("Radio ist EIN");
    }

    /**
     * Schaltet das Radio aus.
     * Wenn das Radio bereits ausgeschaltet ist, wird eine entsprechende Nachricht angezeigt.
     */
    public void turnOff() {
        if (!isOn) {
            System.out.println("Radio ist bereits AUS");
            return;
        }
        isOn = false;
        System.out.println("Radio ist AUS");
    }

    /**
     * Erhöht die Lautstärke um eine Einheit, wenn möglich.
     * Druckt relevante Nachrichten basierend auf dem Zustand des Radios und der aktuellen Lautstärke.
     */
    public void increaseVolume() {
        ensureRadioIsOn();
        if (volume < MAX_VOLUME) {
            volume++;
            System.out.println("Lautstärke: " + volume);
        } else {
            System.out.println("Maximale Lautstärke erreicht");
        }
    }

    /**
     * Verringert die Lautstärke um eine Einheit, wenn möglich.
     * Druckt relevante Meldungen basierend auf dem Zustand des Radios und der aktuellen Lautstärke.
     */

    public void decreaseVolume() {
        ensureRadioIsOn();
        if (volume > MIN_VOLUME) {
            volume--;
            System.out.println("Lautstärke: " + volume);
        } else {
            System.out.println("Minimale Lautstärke erreicht");
        }
    }


    /**
     * Setzt die Frequenz des Radios auf den angegebenen Wert.
     *
     * @param frequency Die gewünschte Frequenz, die zwischen {@link #MIN_FREQUENCY} und {@link #MAX_FREQUENCY}  liegen sollte.
     */
    public void setFrequency(double frequency) {
        ensureRadioIsOn();
        if (frequency < MIN_FREQUENCY || frequency > MAX_FREQUENCY) {
            System.out.println("Frequenz muss zwischen " + MIN_FREQUENCY + " und " + MAX_FREQUENCY + " liegen");
            return;
        }
        this.frequency = frequency;
        System.out.println("Frequenz eingestellt auf: " + frequency + " MHz");
    }
}
