package pl.edu.wszib;

import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

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

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToAddPositionToClosedOrder() {
        // given: we have an Order
        Order order = OrderSample.sample();
        // when: we close the order
        order.close();
        // then: we won't be able to modify the order
        order.addPosition(PositionSamples.sample());
        // exception should be thrown
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToRemovePositionToClosedOrder() {
        // given: we have an Order
        Order order = OrderSample.sample();
        // when: we close the order
        order.close();
        // then: we won't be able to modify the order
        order.removePosition(2);
        // exception should be thrown
    }

    @Test
    public void shouldBeAbleToIncreasePositionQuantity() {
        // given: have have and Order which 1 position which has quantity = 1
        Order order = OrderSample.sampleWithQuantity(1);
        // when: we increase position quantity
        order.increasePositionQuantity(1);
        // then: position quantity should be 2
        Integer positionQuantity = order.getPositionQuantity(1);
        assertEquals(2, positionQuantity.intValue());
    }

    @Test
    public void shouldBeAbleToDecreasePositionQuantity() {
        // given: have have and Order which 1 position which has quantity = 2
        Order order = OrderSample.sampleWithQuantity(2);
        // when: we decrease position quantity
        order.decreasePositionQuantity(1);
        // then: position quantity should be 1
        Integer positionQuantity = order.getPositionQuantity(1);
        assertEquals(1, positionQuantity.intValue());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotBeAbleToDecreasePositionQuantityTo0() {
        // given: have have and Order which 1 position which has quantity = 1
        Order order = OrderSample.sampleWithQuantity(1);
        // when: we decrease position quantity
        order.decreasePositionQuantity(1);
        // then: we won't be able to decrease position quantity and exception should be thrown
    }

    @Test
    public void shouldBeAbleToSetPositionQuantity() {
        // given: have have and Order which 1 position which has quantity = 2
        Order order = OrderSample.sampleWithQuantity(2);
        Integer newQuantity = 10;
        // when: we set position quantity
        order.setPositionQuantity(1, newQuantity);
        // then: position quantity should be equal to newQuantity
        Integer positionQuantity = order.getPositionQuantity(1);
        assertEquals(newQuantity, positionQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotBeAbleToSetPositionQuantityLessThan1() {
        // given: have have and Order which 1 position which has quantity = 2
        Order order = OrderSample.sampleWithQuantity(2);
        Integer newQuantity = 0;
        // when: we set position quantity
        order.setPositionQuantity(1, newQuantity);
        // then: exception should be thrown
    }

    // TODO add new functions to our system
}
