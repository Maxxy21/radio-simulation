public class Main {
    public static void main(String[] args) {
        Radio meinRadio = new Radio();

        meinRadio.turnOn();
        meinRadio.increaseVolume();
        meinRadio.setFrequency(95.5);
        meinRadio.decreaseVolume();
        meinRadio.turnOff();
    }
}
