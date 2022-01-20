package chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Imagine a (literal) stack of plates if the stack gets too high , it might topple.
 * Therefore , in real life , we would likly start a new stack when the previous
 * stack exceed some threshold . Implement a data structure SetOfStacks that minmics this.
 * SetOfStacks should be composed of several stacks and should create a new Stack once the previous one exceeds Capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should beheave identically to a single stack
 * (that is pop should return same value as it wouild if there were just a single stack )
 *
 * FOLLOW UP
 * Implement a function popAt(int index) which performces a pop operation on a specific stack
 */
public class Question3 {

    class SetOfStacks{

         int threshold = 0;
         SetOfStacks(int threshold)
         {
             this.threshold = threshold;
         }

         LinkedList<Stack> stacks = new LinkedList<>();


         public void push(Object value)
         {
             if(stacks.isEmpty())
             {
                 stacks.add(new Stack());
             }

             Stack stack = stacks.getLast();
             if(stack.getSize() == threshold)
             {
                 stack = new Stack();
                 stacks.add(stack);
             }
             stack.push(value);
         }


         public Object pop()
         {
             if(stacks.isEmpty())
             {
                 return null;
             }

             Stack stack = stacks.getLast();
             Object value = stack.pop();
             if(stack.getSize() == 0)
             {
                 stacks.removeLast();
             }

             return value ;

         }
    }

    @Test
    public void test()
    {
        SetOfStacks  stacks = new SetOfStacks(3);

        for(int index = 0 ; index < 10 ; index++)
        {
            stacks.push(index);
        }
        for(int index = 9 ; index >= 0 ; index--)
        {
            assertEquals(stacks.pop() , index);
        }

        assertNull(stacks.pop());
    }
}
