package pl.edu.wszib.order;

public class PositionSamples {
    public static Position sample() {
        return new Position(1, ItemSamples.sample());
    }

    public static Position sampleWithPrice(String inPrice) {
        return new Position(1, ItemSamples.sample(inPrice));
    }

    public static Position sampleWithQuantity(int quantity) {
        return new Position(quantity, ItemSamples.sample());
    }
}
