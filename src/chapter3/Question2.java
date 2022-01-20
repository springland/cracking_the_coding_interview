package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * How would you design a stack which , in addition to push and pop , also has a function
 * min which returns the minmum element ; push , pop and min should
 * all operation in O(1)
 *
 */
public class Question2 {

    public static final int STACK_SIZE = 10 ;
    protected int [] dataStack = new int[STACK_SIZE]  ;

    protected int [] minStack = new int[STACK_SIZE] ;

    protected int stackIndex = -1 ;

    public void push(int value)
    {
        if(stackIndex == STACK_SIZE -1)
        {
            throw new IllegalStateException("Stack is full");
        }

        dataStack[++stackIndex] = value ;
        if(stackIndex > 0)
        {
            if(minStack[stackIndex-1] < value)
            {
                minStack[stackIndex] = minStack[stackIndex-1] ;
            }
            else
            {
                minStack[stackIndex] = value ;
            }
        }
        else
        {
            minStack[stackIndex] = value;
        }

    }

    public int pop()
    {
        if(stackIndex < 0)
        {
            throw new IllegalStateException("Stack is empty");
        }

        return dataStack[stackIndex--];

    }

    public int min()
    {
        if(stackIndex < 0)
        {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack[stackIndex];
    }


    @Test
    public void test()
    {
        push(4);
        push(5);
        push(6);
        assertEquals(min() , 4);
        push(3);
        assertEquals(min() , 3);
        push(2);
        assertEquals(min() , 2);
        pop();
        assertEquals(min() , 3);
        pop();
        assertEquals(min() , 4);
        pop();
        assertEquals(min() , 4);
        pop();
        assertEquals(min() , 4);
        pop();
        assertEquals(stackIndex , -1);




    }
}
