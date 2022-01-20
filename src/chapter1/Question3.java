package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *  Given two strings , write a method to decide if one is a permutation of another
 */
public class Question3 {

    public boolean isPermutation(String src , String target)
    {
        // assume only has ascii code

        int[] charCounts = new int[128];

        if(src == null && target == null)
        {
            return true ;
        }

        if(src == null || target == null)
        {
            return false ;
        }
        for(char ch : src.toCharArray())
        {
            charCounts[(int)ch]++;
        }
        for(char ch : target.toCharArray())
        {
            charCounts[(int)ch]--;
        }

        for(int count : charCounts)
        {
            if(count != 0){
                return false ;
            }
        }
        return true ;
    }

    @Test
    public void testIsPermmutation()
    {

        assertTrue(isPermutation(null , null));
        assertFalse(isPermutation(null , "abc"));
        assertFalse(isPermutation("abc" , null));
        assertFalse(isPermutation("a" , "bc"));
        assertTrue(isPermutation("abca" , "cbaa"));
    }

}
