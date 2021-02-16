package creatures;

import huglife.*;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * an implementation of predator
 */
public class Clorus extends Creature{
    /**
     * color red
     */
    private int r;
    /**
     * color green
     */
    private int g;
    /**
     * color blue
     */
    private int b;
    /**
     * create a Clorus creature with energy e, the uniform name "clorus"
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * if energy is not given, give a default energy 1
     */
    public Clorus() {
        this(1);
    }

    public Color color() {
        return color(34, 0, 231);
    }

    /**
     * if clorus attack a creature, it will gain the energy of it
     */
    public void attack(Creature c) {
        energy += c.energy();
    }

    /**
     * the clorus shares half of its energy when replicated;
     * returns a new Clorus object;
     */
    public Clorus replicate () {
        energy = 0.5 * energy;
        return new Clorus(energy);
    }

    /**
     * clorus loses 0.03 energy during one move
     */
    public void move() {
        energy -= 0.03;
    }

    /**
     * colus gain 0.01 energy during one stay
     */
    public void stay() {
        energy += 0.01;
    }

    /**
     * Rules
     * 1.
     * If there are no empty squares, the Clorus will STAY.
     * even if there are Plips nearby they could attack
     * since plip squares do not count as empty squares
     * 2.
     * Otherwise, if any Plips are seen,
     * the Clorus will ATTACK one of them randomly.
     * 3.
     * Otherwise, if the Clorus has energy greater than or equal to one,
     * it will REPLICATE to a random empty square.
     * 4.
     * Otherwise, the Clorus will MOVE to a random empty square.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        for (Direction d : neighbors.keySet()) {
            if (neighbors.get(d).name().equals("empty")) {
                emptyNeighbors.add(d);
            }
        }
        Deque<Direction> plipNeighbor = new ArrayDeque<>();
        for (Direction d : neighbors.keySet()) {
            if (neighbors.get(d).name().equals("plip")) {
                plipNeighbor.add(d);
            }
        }

        if (emptyNeighbors.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (plipNeighbor.size() > 0) {
            return new Action(Action.ActionType.ATTACK,
                    HugLifeUtils.randomEntry(plipNeighbor));
        } else if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE,
                    HugLifeUtils.randomEntry(emptyNeighbors));
        } else {
            return new Action(Action.ActionType.MOVE,
                    HugLifeUtils.randomEntry(emptyNeighbors));
        }
    }


}
