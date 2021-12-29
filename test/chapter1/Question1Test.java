package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question1Test {

    Question1  question1 = new Question1();
    @Test
    public void testByUsingSet()
    {
        assertTrue(question1.containsUniqueCharsOnlyByUsingSet(null));
        assertTrue(question1.containsUniqueCharsOnlyByUsingSet("abc"));
        assertFalse(question1.containsUniqueCharsOnlyByUsingSet("abad"));

    }

    @Test
    public void testUnique()
    {
        assertTrue(question1.containsUniqueCharsOnly(null));
        assertTrue(question1.containsUniqueCharsOnly("abc"));
        assertFalse(question1.containsUniqueCharsOnly("abad"));

    }
}
