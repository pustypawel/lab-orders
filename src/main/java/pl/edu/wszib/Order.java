package pl.edu.wszib;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Position> positions = new ArrayList<>();

    public void addPosition(Position position) {
        positions.add(position);
    }

    public int positionsCount() {
        return positions.size();
    }

    public void removePosition(int line) {
        validateLine(line);
        positions.remove(line - 1);
    }

    private void validateLine(int line) {
        if (line <= 0) {
            throw new IllegalArgumentException("line should be grader than 0. line = " + line);
        }
        if (line > positions.size()) {
            throw new IllegalArgumentException("line should be less than " + positions.size() + ". line = " + line);
        }
    }

    public BigDecimal calculateSum() {
        BigDecimal sum = new BigDecimal(0);
        for (Position position : positions) {
            Item item = position.getItem();
            BigDecimal price = item.getPrice();
            Integer quantity = position.getQuantity();
            sum = sum.add(price.multiply(new BigDecimal(quantity)));
        }
        return sum;
    }
}
