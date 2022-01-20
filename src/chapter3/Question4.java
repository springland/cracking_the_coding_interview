package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * In the classic problem of Tower of Hanoi , you have 3 towers and N disks of different size
 * which can slide onto any tower.  The puzzle starts with disks sorted in ascending order
 * of size from top to bottom , You have the following constraints
 *   1. Only one disk can be moved at a time
 *   2. A disk is slid off the top of one tower to another
 *   3. A disk can only be placed on the top of a larger disk
 *
 *   Write a program to move the disks from first towner to the last tower using stacks
 */
public class Question4 {


    public void hanoi(Stack src , Stack middle , Stack target)
    {

        // pop the  disk from src
        if(src.peek() == null)
        {

        }

        // move the disk

        // push the disk to target
    }

    @Test
    public void test()
    {
        Stack a = new Stack("A");
        Stack b = new Stack("B");
        Stack c = new Stack("C");
       for(int index = 4 ; index >= 0 ; index--)
       {
           a.push(index);
       }

       hanoi(a , b , c);
       for(int index = 0 ; index <5 ; index++)
       {
           assertEquals(c.pop() , index);
       }
    }
}
