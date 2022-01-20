package chapter1;

/**
 * Assume you have a method isSubstring which checkes if one world is substring of another
 * Given two strings , s1 and s2 , write a method to check if s2 is a rotation of s1, using only one
 * call to isSubstring ( e.g. "waterbottle" is a rotation of "erbottlewat")
 *
 */
public class Question8 {

    public boolean isRotation(String s1 , String s2)
    {
        /*
         * s1+s1 contains s2
         * s1 and s2 have the same number of chars
         */
        String combined = s1 + s1 ;
        int[] charCounts = new int[26];
        for(char ch : s1.toCharArray())
        {
            charCounts[ch -'a']++;
        }

        for(char ch : s2.toCharArray())
        {
            charCounts[ch -'a']--;
        }

        for(int index = 0  ; index < charCounts.length ; index++)
        {
            if(charCounts[index] != 0)
            {
                return false ;
            }
        }
        if(!combined.contains(s2) )
        {
            return false ;
        }

        return true ;
    }

    /**
     * if s2 is a substring of s1
     * @param s1
     * @param s2
     * @return
     */
    protected boolean isSubstring(String s1 , String s2)
    {
        return s1.contains(s2);
    }
}
