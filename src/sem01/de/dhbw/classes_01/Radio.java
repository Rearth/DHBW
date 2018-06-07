package de.dhbw.java.exercise.classes_01;

public class Radio {


    private boolean on = false;
    private short volume = 5;
    private float frequency = 100.0f;

    public static void main(String[] args) {

        Radio radio = new Radio();
        System.out.println(radio);

        Radio radio1 = new Radio(true, (short) 5, 90f);
        System.out.println(radio1);
        radio1.incVolume();
        System.out.println(radio1);
        radio1.setFrequency(115f);
        System.out.println(radio1);
        radio1.turnOff();
        radio1.setVolume((short) 1);
        System.out.println(radio1);

    }

    public Radio() {}

    public Radio(boolean on, short volume, float frequency) {
        this.on = on;
        setVolume(volume);
        setFrequency(frequency);

    }

    private void setVolume(short volume) {
        if (volume < 0 || volume > 10) {
            throw new IllegalArgumentException("Number must be between 0 and 10");
        } else if (!this.on) {
            throw new IllegalStateException("Radio is not on");
        }

        this.volume = volume;
    }

    public void setFrequency(float frequency) {
        if (frequency < 85 || frequency > 110) {
            frequency = 99.0f;
        }

        this.frequency = frequency;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void incVolume() {
        this.setVolume(volume++);
    }

    public void decVolume() {
        this.setVolume(volume--);
    }

    @Override
    public String toString() {
        return "Radio{" +
                "on=" + on +
                ", volume=" + volume +
                ", frequency=" + frequency +
                '}';
    }
}
