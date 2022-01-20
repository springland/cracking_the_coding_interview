package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Implement a method to performe basic string compression using the counts of repeated characters.
 * For example the string aabcccccaaa woule become a2b1c5a3. If the compression string would not become
 * smaller than the original string , you method should return the original string
 */
public class Question5 {

    public String compress(String src)
    {

        if(src == null || src.isEmpty())
        {
            return src ;
        }

        StringBuilder builder = new StringBuilder();

        // java string should not have 0 char
        char current = 0;
        int  count = 0;
        for(char ch : src.toCharArray())
        {
            if(ch == current)
            {
                count ++;
            }
            else
            {
                if(current != 0) {
                    builder.append(current);
                    builder.append(Integer.toString(count));
                }
                count = 1;
                current = ch ;
            }
        }

        builder.append(current);
        builder.append(Integer.toString(count));
        if(src.length() < builder.length())
        {
            return src ;
        }
        else
        {
            return builder.toString();
        }
    }


    @Test
    public void test()
    {


        String answer = null;

        answer = compress(null);
        assertNull(answer);

        answer = compress("");
        assertEquals(answer , "");

        answer = compress("ab");
        assertEquals(answer , "ab");

        answer = compress("aaabcccca" );
        assertEquals("a3b1c4a1" , answer);



    }

}
