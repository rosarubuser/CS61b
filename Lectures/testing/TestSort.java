import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    /** test the sort method of the Sort class */
    @Test
    public void testSort() {
        String[] input = {"i", "hava", "an", "egg"};
        String[] expected = {"an", "egg", "hava", "i"};
        Sort.sort(input);   // sort in place
        /*for (int i = 0; i < input.length; i += 1) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position " + i + ", expected : " + expected[i] + ", but got " + input[i] + ".");
                break;
            }
        }*/
        // The above code is equivalent to:
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input1 = {"i", "have", "an", "egg"};
        int expected1 = 2;

        int actual1 = Sort.findSmallest(input1, 0);
        org.junit.Assert.assertEquals(expected1, actual1);

        String[] input2 = {"this", "is", "a", "pig"};
        int expected2 = 3;

        int actual2 = Sort.findSmallest(input2, 3);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 3;
        String[] expected = {"egg", "have", "an", "i"};

        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}