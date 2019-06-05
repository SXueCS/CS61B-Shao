import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;

public class TestOffByN {
    @Test
    public void testOffByN() {

    }
    static OffByN testOffBy5 = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertTrue(testOffBy5.equalChars('a', 'f'));
        assertFalse(testOffBy5.equalChars('a', 'a'));
        assertFalse(testOffBy5.equalChars('a', 'b'));
    }
}
