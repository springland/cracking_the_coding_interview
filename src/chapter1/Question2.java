package chapter1;

/**
 *  Implement a function void reverse(char * str) in C or C++ reverse a null terminated string
 */
public class Question2 {

    public String reverse(String str)
    {
        if(str == null)
        {
            return str ;
        }

        char[] chars = str.toCharArray();
        for(int index = 0 ; index < chars.length/2 ; index++)
        {
            char ch = chars[index];
            chars[index] = chars[chars.length-index-1];
            chars[chars.length-index-1] = ch ;
        }

        return new String(chars);
    }


}
