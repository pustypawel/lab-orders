package pl.edu.wszib;

import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class TddTest {

    @Test
    public void shouldBeAbleToAddPositionToOrder() {
        // given: we have an empty Order
        Order order = new Order();
        // and: and we have simple Order Position
        Position position = PositionSamples.sample();

        // when: we try to add position to order
        order.addPosition(position);

        // then: we expect that order should have one position
        assertEquals("Zamówienie powinno mieć 1 pozycję", 1, order.positionsCount());
    }

    @Test
    public void shouldBeAbleToAddTheSamePositionMultipleTimes() {
        // given: we have an empty Order
        Order order = new Order();
        // and: and we have simple Order Position
        Position position = PositionSamples.sample();

        // when: we try to add position to order
        order.addPosition(position);
        // and: we try to add the same position again
        order.addPosition(position);

        // then: we expect that order should have one position
        assertEquals("Zamówienie powinno mieć 2 pozycję", 2, order.positionsCount());
    }

    @Test
    public void shouldBeAbleToRemoveExistingPositionFromOrder() {
        // given: we have an empty Order
        Order order = new Order();
        // and: and we have simple Order Position
        Position position = PositionSamples.sample();
        // and: and the order has position
        order.addPosition(position);

        // when: we try to remove position
        order.removePosition(1);

        // then: we expect that order shouldn't have any position
        assertEquals("Zamówienie powinno nie mieć pozycji", 0, order.positionsCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotBeAbleToRemovePositionWhichDoesNotExistInOrder() {
        // given: we have an empty Order
        Order order = new Order();
        // and: and we have simple Order Position which is not part of Order
        Position position = PositionSamples.sample();

        // when: we try to remove position
        order.removePosition(1);

        // then: exception should be thrown
    }

    @Test
    public void shouldBeAbleToCalculateOrderSum() {
        // given: we have an empty Order
        Order order = new Order();
        // and: and we have couple of positions
        Position position1 = PositionSamples.sampleWithPrice("10.50");
        Position position2 = PositionSamples.sampleWithPrice("20.50");
        order.addPosition(position1);
        order.addPosition(position2);

        // when: we calculate order sum
        BigDecimal sum = order.calculateSum();

        // then: sum should be correct
        assertEquals("Niepoprawna suma zamówienia", new BigDecimal(31).setScale(2, RoundingMode.HALF_UP), sum);
    }

    @Test
    @Ignore
    public void shouldBeAbleCloseOrder() {
        fail();
    }

    @Test
    @Ignore
    public void shouldNotBeAbleToAddPositionToClosedOrder() {
        fail();
    }

    @Test
    @Ignore
    public void shouldNotBeAbleToRemovePositionToClosedOrder() {
        fail();
    }
}