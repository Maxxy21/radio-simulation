/**
 * Stellt ein einfaches Radio dar, mit Funktionen wie Ein-/Ausschalten,
 * Lautstärkeregelung und Frequenzeinstellung.
 *
 * @author Maxwell Aboagye
 */
public class Radio {

    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;
    private static final double MIN_FREQUENCY_FM = 88.0;
    private static final double MAX_FREQUENCY_FM = 108.0;
    private static final double MIN_FREQUENCY_AM = 530.0;
    private static final double MAX_FREQUENCY_AM = 1700.0;


    private boolean isOn;
    private int volume;
    private double frequency;
    private boolean isMuted;
    private Mode currentMode;

    private enum Mode {
        AM, FM
    }


    /**
     * Standardkonstruktor, der ein Radio im ausgeschalteten Zustand initialisiert,
     * mit einer Standardlautstärke und frequenz.
     */
    public Radio() {
        this.isOn = false;
        this.volume = 0;
        this.frequency = 88.0;
        this.isMuted = false;
        this.currentMode = Mode.FM; // FM ist der Standardmodus
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
        if (isMuted) {
            unmute();
        }
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
        if (isMuted) {
            unmute();
        }
        if (volume > MIN_VOLUME) {
            volume--;
            System.out.println("Lautstärke: " + volume);
        } else {
            System.out.println("Minimale Lautstärke erreicht");
        }
    }

    /**
     * Setzt die Lautstärke des Radios auf den angegebenen Wert.
     *
     * @param volume Die gewünschte Lautstärke, die zwischen {@link #MIN_VOLUME} und {@link #MAX_VOLUME} liegen sollte.
     */
    public void setVolume(int volume) {
        ensureRadioIsOn();
        if (volume < MIN_VOLUME || volume > MAX_VOLUME) {
            System.out.println("Lautstärke muss zwischen " + MIN_VOLUME + " und " + MAX_VOLUME + " liegen");
            return;
        }
        this.volume = volume;
        System.out.println("Lautstärke eingestellt auf: " + volume);
    }


    /**
     * Setzt die Frequenz des Radios auf den angegebenen Wert.
     *
     * @param frequency Die gewünschte Frequenz, die zwischen MIN_FREQUENCY_FM und MAX_FREQUENCY liegen sollte.
     */
    public void setFrequency(double frequency) {
        ensureRadioIsOn();

        double minFreq = (currentMode == Mode.AM) ? MIN_FREQUENCY_AM : MIN_FREQUENCY_FM;
        double maxFreq = (currentMode == Mode.AM) ? MAX_FREQUENCY_AM : MAX_FREQUENCY_FM;

        if (frequency < minFreq || frequency > maxFreq) {
            System.out.println("Frequenz muss zwischen " + minFreq + " und " + maxFreq + " liegen");
            return;
        }
        this.frequency = frequency;

        if (currentMode == Mode.AM) {
            System.out.println("Frequenz eingestellt auf: " + frequency + " kHz");
        } else {
            System.out.println("Frequenz eingestellt auf: " + frequency + " MHz");
        }
    }

    /**
     * Macht das Radio stumm, wenn es nicht stumm ist.
     */
    public void mute() {
        ensureRadioIsOn();
        isMuted = true;
        System.out.println("Lautstärke ist gedämpft");
    }

    /**
     * Hebt die Stummschaltung des Radios auf, wenn es stumm ist.
     */
    public void unmute() {
        ensureRadioIsOn();
        isMuted = false;
        System.out.println("Lautstärke ist ungedämpft");
    }

    /**
     * Schaltet das Radio in den AM-Modus.
     * Wenn das Radio bereits im AM-Modus ist, wird eine entsprechende Nachricht angezeigt.
     */
    public void switchToAM() {
        ensureRadioIsOn();
        currentMode = Mode.AM;
        System.out.println("Umgeschaltet auf AM-Modus");
    }

    /**
     * Schaltet das Radio in den FM-Modus.
     * Wenn das Radio bereits im FM-Modus ist, wird eine entsprechende Nachricht angezeigt.
     */
    public void switchToFM() {
        ensureRadioIsOn();
        currentMode = Mode.FM;
        System.out.println("Umgeschaltet auf FM-Modus");
    }

    /**
     * Gibt den aktuellen Status des Radios aus.
     */
    public void displayStatus() {
        System.out.println("Radio-Status: " + (isOn ? "AN" : "AUS"));
        System.out.println("Modus: " + currentMode);
        System.out.println("Lautstärke: " + volume);
        System.out.println("Gedämpft: " + (isMuted ? "Ja" : "Nein"));
        if (isOn) {
            if (currentMode == Mode.AM) {
                System.out.println("Frequenz: " + frequency + " kHz");
            } else if (currentMode == Mode.FM) {
                System.out.println("Frequenz: " + frequency + " MHz");
            }
        }
    }
}

