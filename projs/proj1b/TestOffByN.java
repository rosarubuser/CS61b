import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static public CharacterComparator obN;

    @Test
    public void testEqualChars() {
        obN = new OffByN(3);
        assertTrue(obN.equalChars('d', 'a'));
        assertTrue(obN.equalChars('a', 'd'));
        assertFalse(obN.equalChars('z', 'd'));
    }
}
