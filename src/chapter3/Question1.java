package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Describe how do you use a single array to implement 3 stacks
 */
public class Question1 {

    // we can create one stack from top , one stack from bottom
    // and the third stack in the middle

    public static final int STACK_SIZE = 10 ;

    protected int[] data = new int[STACK_SIZE];


    int     stack1Index = -1 ;

    int     stack2Index = STACK_SIZE ;

    int     stack3Index = STACK_SIZE/2 ;
    int     stack3Size = 0;

    int totalStackSize = 0;
    public void push( int stackId , int value )
    {
        if(totalStackSize < STACK_SIZE) {
            switch (stackId) {
                case 1:
                    if(stack1Index == stack3Index -1)
                    {
                        offsetStack3(1);
                    }
                    data[++stack1Index] = value ;

                    break;
                case 2:
                    if(stack2Index == stack3Index + stack3Size)
                    {
                        if(stack3Size > 0) {
                            offsetStack3(-1);
                        }
                    }
                    data[--stack2Index] = value ;
                    break;
                case 3:
                    if(stack3Index + stack3Size == stack2Index)
                    {
                        offsetStack3(-1);
                    }
                    data[stack3Index + stack3Size] = value ;
                    stack3Size++;
                    break;
            }
            totalStackSize++;
        }
        else
        {
            throw new IllegalStateException("Stack is full");
        }
    }

    protected void offsetStack3(int offset)
    {
        if(offset > 0) {
            for (int index = stack3Size -1; index>= 0; index--) {
                data[offset + index + stack3Index] = data[index+ stack3Index];
            }
        }
        else
        {
            for (int index = 0; index < stack3Size; index++) {
                try {
                    data[offset + stack3Index + index] = data[stack3Index + index];
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }

        }

        stack3Index += offset ;
    }
    public int pop(int stackId )
    {
        int value = 0;
        switch(stackId)
        {
            case 1:
                if(stack1Index >= 0)
                {
                    value =  data[stack1Index--] ;
                }
                else
                {
                    throw new IllegalStateException("Stack 1 is empty");
                }
                break;
            case 2:
                if(stack2Index <STACK_SIZE)
                {
                    value =  data[stack2Index++] ;
                }
                else
                {
                    throw new IllegalStateException("Stack 2 is empty");
                }
                break;
            case 3:

                if(stack3Size > 0)
                {
                    value = data[stack3Index + stack3Size-1];
                    stack3Size --;
                }
                else
                {
                    throw new IllegalStateException("Stack3 is empty");
                }
                break ;
        }
        totalStackSize -- ;
        return value ;
    }


    @Test
    public void testStack1()
    {
       for(int index = 0 ; index < STACK_SIZE ; index++)
       {
           push(1 , index);
       }

       for(int index = STACK_SIZE-1 ; index >= 0 ; index--)
       {
           int value = pop(1 );
           assertEquals(value , index);
       }
    }

    @Test
    public void testStack2()
    {
        for(int index = 0 ; index < STACK_SIZE ; index++)
        {
            push(2 , index);
        }

        for(int index = STACK_SIZE-1 ; index >= 0 ; index--)
        {
            int value = pop(2 );
            assertEquals(value , index);
        }

    }

    @Test
    public void testStack3()
    {
        for(int index = 0 ; index < STACK_SIZE ; index++)
        {
            push(3 , index);
        }

        for(int index = STACK_SIZE-1 ; index >= 0 ; index--)
        {
            int value = pop(3 );
            assertEquals(value , index);
        }

    }

    @Test
    public void testAll()
    {
        push(1 , 1);
        push(1 , 2);
        push(1 , 3);
        push(1 , 4);
        push(3 , 5);
        push(3 , 6);
        push(3 , 7);
        push(2 , 8);
        push(2 , 9);
        push(2 , 10);

        assertEquals(pop(1) , 4);
        push(2 , 11);
        assertEquals(pop(3) , 7);
        assertEquals(pop(2) , 11);

    }

}
