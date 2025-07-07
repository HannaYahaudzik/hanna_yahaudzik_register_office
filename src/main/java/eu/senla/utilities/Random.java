package eu.senla.utilities;

public final class Random {

    private Random() {
    }

    public static int getRandomInt(final int maxValue) {
        return (int) (Math.random() * maxValue);
    }
}
