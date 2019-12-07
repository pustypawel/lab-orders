package pl.edu.wszib;

public class PositionSamples {
    public static Position sample() {
        return new Position(1, ItemSamples.sample());
    }

    public static Position sampleWithPrice(String inPrice) {
        return new Position(1, ItemSamples.sample(inPrice));
    }
}
