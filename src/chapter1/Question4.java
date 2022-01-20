package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a method to replace all spaces in string with %20, you may assume that the string has enough space at the end of the string
 * to hold the additional characters,  and that you are give the true length of the string ( Note: if implementing in java
 * ,please use character array so that you can performance this operation in place)
 * Example
 * Input : "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 */
public class Question4 {

    public int replaceSpaceBackward(char[] chars , int length)
    {
        if(chars == null || length <= 0)
        {
            return 0 ;
        }

        int spaceCount = 0 ;
        for(int index = 0 ; index < length ; index++)
        {
            if(chars[index] == ' ')
            {
                spaceCount++;
            }
        }

        int endIndex = length + spaceCount*2-1;
        for(int index = length-1 ; index >= 0 ; index--)
        {
            if(chars[index] == ' ')
            {
                chars[endIndex--] = '0';
                chars[endIndex--] = '2' ;
                chars[endIndex--] = '%' ;
            }
            else
            {
                chars[endIndex--] = chars[index];
            }
        }
        return length + spaceCount*2 ;
    }

    public int replaceSpaceForward(char[] chars , int length)
    {
        // without counting space

        int endIndex = length -1 ;
        int index = 0;
        while(index <= endIndex)
        {
            if(chars[index] == ' ')
            {
                offset(chars , index , endIndex , 2);
                endIndex += 2;
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index] = '0';
                length += 2;
            }
            index++ ;
        }
        return length ;

    }

    /**
     * Offset characters in chars from startIndex to endIndex ( inclusive) with offset
     * @param chars
     * @param startIndex
     * @param endIndex
     * @param offset
     */
    protected void offset(char[] chars , int startIndex , int endIndex , int offset)
    {
        for(int index = endIndex ; index >= startIndex ; index--)
        {
            chars[index+offset] = chars[index];
        }
        return  ;
    }


    @Test
    public void testBackward()
    {
        Question4  question = new Question4();
        char[]  str = new char[] {'a' , ' ' , ' ' , 'd' , 'e' ,' ', 'f' ,' ',' ',' ',' ',' ',' ' , 'a' , 'b'};
        int length = question.replaceSpaceBackward(str ,7 );
        char[] expected = new char[] {'a' ,'%',  '2' , '0' , '%',  '2' , '0' , 'd' , 'e' , '%',  '2' , '0' ,'f'};

        assertEquals(length , 13);
        assertArrayEquals(expected , str , length);
        length = question.replaceSpaceBackward(null , 0);
        assertEquals(length , 0);

        str = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' , ' '};
        length = question.replaceSpaceBackward(str ,3 );
        expected = new char[] {'%',  '2' , '0' , '%',  '2' , '0' , '%' , '2' , '0'};
        assertEquals(length , 9);
        assertArrayEquals(expected , str , length);

    }


    @Test
    public void testForward()
    {
        Question4  question = new Question4();
        char[]  str = new char[] {'a' , ' ' , ' ' , 'd' , 'e' ,' ', 'f' ,' ',' ',' ',' ',' ',' ' , 'a' , 'b'};
        int length = question.replaceSpaceForward(str ,7 );
        char[] expected = new char[] {'a' ,'%',  '2' , '0' , '%',  '2' , '0' , 'd' , 'e' , '%',  '2' , '0' ,'f'};

        assertEquals(length , 13);
        assertArrayEquals(expected , str , length);
        length = question.replaceSpaceForward(null , 0);
        assertEquals(length , 0);

        str = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' , ' '};
        length = question.replaceSpaceForward(str ,3 );
        expected = new char[] {'%',  '2' , '0' , '%',  '2' , '0' , '%' , '2' , '0'};
        assertEquals(length , 9);
        assertArrayEquals(expected , str , length);

    }

    protected boolean assertArrayEquals(char[] expected , char[] actual ,int length )
    {
        for(int index = 0 ; index < length ; index++)
        {
            if(expected[index] != actual[index])
            {
                return false ;
            }
        }
        return true ;
    }

}
