package chapter1;


import java.util.HashSet;

/**
    Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?
 */
public class Question1 {


    public  boolean containsUniqueCharsOnlyByUsingSet(String str)
    {

        if(str == null)
        {
            return true ;
        }

        HashSet<Character> charSet = new HashSet<>();

        for(char ch : str.toCharArray())
        {
            if(!charSet.add(ch))
            {
                return false ;
            }
        }

        return true ;
    }


    public boolean containsUniqueCharsOnly(String str)
    {

        // There is an assumption that it contains lower case alphabetic only
        boolean[] flags  = new boolean[26] ;

        if(str == null)
        {
            return true ;
        }

        for(char ch : str.toCharArray())
        {
            int index = ch - 'a';
            if(flags[index])
            {
                return false ;
            }
            flags[index] = true ;
        }
        return true ;

    }
}
