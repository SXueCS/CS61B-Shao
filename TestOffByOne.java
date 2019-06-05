import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator obo = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue(obo.equalChars('a', 'b'));
        assertFalse(obo.equalChars('a', 'a'));
    }
}
