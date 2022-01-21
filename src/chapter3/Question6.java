package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a program to sort a Stack in ascending order. You may use addition stacks to hold items.
 * but you may not copy the elements into any other data structure such as array. The stack supports the following
 * operations: push , pop , peek , isEmpty
 */
public class Question6 {

    // Assume stack has Integer values
    // sort it in assending order

    public void sort(Stack stack)
    {
        Stack descending = new Stack();

        while(!stack.isEmpty())
        {
            Integer value = (Integer)stack.pop();
            if(descending.isEmpty())
            {
                descending.push(value);
            }
            else
            {
                Integer largest = (Integer)descending.peek().getData();
                if(value.compareTo(largest) >= 0)
                {
                    descending.push(value);
                }
                else
                {
                    Stack temp = new Stack();
                    while(!descending.isEmpty() && ((Integer) descending.peek().getData()).compareTo(value) > 0)
                    {
                        temp.push(descending.pop());
                    }
                    descending.push(value);
                    while(!temp.isEmpty())
                    {
                        descending.push(temp.pop());
                    }
                }
            }

        }

        while(!descending.isEmpty())
        {
            stack.push(descending.pop());
        }
    }


    @Test
    public void test()
    {
        Stack stack = new Stack();
        int size = 10 ;
        for(int index = 0 ; index < size ; index++)
        {
            stack.push(index);
        }

        sort(stack);

        for(int index = 0 ; index < size ; index++)
        {
            assertEquals(stack.pop() , index);
        }
    }
}
