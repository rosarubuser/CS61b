import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {
    @Test
    public void main() {
        StudentArrayDeque<Integer> checkArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctArray = new ArrayDequeSolution<>();

        for (int i = 0; i < 12; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                checkArray.addLast(i);
                correctArray.addLast(i);
                System.out.println("addLast(" + i + ")");
            } else {
                checkArray.addFirst(i);
                correctArray.addFirst(i);
                System.out.println("addFirst(" + i + ")");
            }
        }

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            int check = 0, correct = 0;
            if (numberBetweenZeroAndOne < 0.5) {
                check = checkArray.removeFirst();
                correct= correctArray.removeFirst();
                assertEquals("removeFirst()", correct, check);
            } else {
                check = checkArray.removeLast();
                correct = correctArray.removeLast();
                assertEquals("removeLast()", correct, check);
            }
        }
    }
}
