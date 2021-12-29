package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question2Test {
    Question2  solution = new Question2();

    @Test
    public void testReverse()
    {
        assertNull(solution.reverse(null));
        assertEquals(solution.reverse("abcd") , "dcba" );
        assertEquals(solution.reverse("abc") , "cba" );
    }
}
