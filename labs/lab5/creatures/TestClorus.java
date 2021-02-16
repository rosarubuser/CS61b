package creatures;

import huglife.*;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Color;
import java.util.HashMap;

/**
 * test the Clorus class
 */
public class TestClorus {

    @Test
    public void testBasics() {
        Clorus clorus = new Clorus(1.4);
        assertEquals(1.4, clorus.energy(), 0.001);
        assertEquals(new Color(34, 0, 231), clorus.color());
        clorus.move();
        assertEquals(1.37, clorus.energy(), 0.001);
        clorus.move();
        assertEquals(1.34, clorus.energy(), 0.001);
        clorus.stay();
        assertEquals(1.35, clorus.energy(), 0.001);
        clorus.stay();
        assertEquals(1.36, clorus.energy(), 0.001);
    }

    @Test
    public void testReplicate() {
        Clorus clorus = new Clorus(1.8);
        clorus.replicate();
        assertEquals(0.9, clorus.energy(), 0.01);
    }

    @Test
    public void testAttack(){
        Plip food = new Plip(0.3);
        Clorus predator = new Clorus(2.3);
        predator.attack(food);
        assertEquals(2.6, predator.energy(), 0.01);
    }

    @Test
    public void testChoose(){
        // No empty space, no plip seen, STAY
        Clorus clorus = new Clorus(3.2);
        HashMap<Direction, Occupant> neighbor = new HashMap<Direction, Occupant>();
        neighbor.put(Direction.TOP, new Impassible());
        neighbor.put(Direction.BOTTOM, new Impassible());
        neighbor.put(Direction.LEFT, new Impassible());
        neighbor.put(Direction.RIGHT, new Impassible());
        Action expected = new Action(Action.ActionType.STAY);
        Action actual = clorus.chooseAction(neighbor);

        assertEquals(expected, actual);

        // No empty space, one plip seen, STAY
        clorus = new Clorus(2);
        neighbor.put(Direction.TOP, new Impassible());
        neighbor.put(Direction.BOTTOM, new Impassible());
        neighbor.put(Direction.LEFT, new Plip(1.4));
        neighbor.put(Direction.RIGHT, new Impassible());

        actual = clorus.chooseAction(neighbor);

        assertEquals(expected, actual);

        // Have empty space, one plip seen, ATTACK
        clorus = new Clorus(2);
        neighbor.put(Direction.TOP, new Empty());
        neighbor.put(Direction.BOTTOM, new Impassible());
        neighbor.put(Direction.LEFT, new Plip(1.4));
        neighbor.put(Direction.RIGHT, new Impassible());

        expected = new Action(Action.ActionType.ATTACK,Direction.LEFT);
        actual = clorus.chooseAction(neighbor);

        assertEquals(expected, actual);

        // Have empty space, no plip seen, energy >= 1, REPLICATE
        clorus = new Clorus(2);
        neighbor.put(Direction.TOP, new Empty());
        neighbor.put(Direction.BOTTOM, new Impassible());
        neighbor.put(Direction.LEFT, new Impassible());
        neighbor.put(Direction.RIGHT, new Impassible());

        expected = new Action(Action.ActionType.REPLICATE,Direction.TOP);
        actual = clorus.chooseAction(neighbor);

        assertEquals(expected,actual);

        // Have empty space, no plip seen, energy < 1, MOVE
        clorus = new Clorus(0.3);
        neighbor.put(Direction.TOP, new Empty());
        neighbor.put(Direction.BOTTOM, new Impassible());
        neighbor.put(Direction.LEFT, new Impassible());
        neighbor.put(Direction.RIGHT, new Impassible());

        expected = new Action(Action.ActionType.MOVE,Direction.TOP);
        actual = clorus.chooseAction(neighbor);

        assertEquals(expected,actual);

        // Have more than empty space, no plip seen, energy < 1, MOVE
        clorus = new Clorus(0.3);
        neighbor.put(Direction.TOP, new Empty());
        neighbor.put(Direction.BOTTOM, new Empty());
        neighbor.put(Direction.LEFT, new Empty());
        neighbor.put(Direction.RIGHT, new Impassible());

        Action unexpected = new Action(Action.ActionType.STAY);
        actual = clorus.chooseAction(neighbor);

        assertNotEquals(unexpected,actual);
    }
}
