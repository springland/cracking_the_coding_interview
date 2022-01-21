package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implementing a MyQueue class which implement a queue using two Stacks
 *
 * This is to implement a first in first out queue
 * with enqueue and dequeue method
 */
public class Question5 {

    Stack  enqueuStack = new Stack();

    Stack  dequeueStack = new Stack() ;

    public void  enqueue(Object value)
    {
        enqueuStack.push(value);
    }

    public Object dequeue()
    {
        if(dequeueStack.peek() == null)
        {
            // dequeuStack is empty
            while(enqueuStack.peek() != null)
            {
                Object value = enqueuStack.pop();
                dequeueStack.push(value);
            }
        }
        return dequeueStack.pop();
    }


    @Test
    public void test()
    {
        for(int index = 1 ; index < 5 ; index ++)
        {
            enqueue(index);
        }

        for(int index = 1 ; index < 3 ; index++)
        {
            assertEquals(dequeue() , index);
        }

        for(int index = 5 ; index < 10 ; index++)
        {
            enqueue(index);
        }

        for(int index = 3 ; index < 10 ; index++)
        {
            assertEquals(dequeue() , index);
        }

    }
}
