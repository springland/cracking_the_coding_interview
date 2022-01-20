package chapter2;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *  Write code to remove duplicates from an unsorted linked list
 *
 *  FOLLOW UP
 *  How would you solve this problem if temporary buffer is not allowed?
 */
public class Question1 {

    public Node removeDuplicates(Node head)
    {
        Set<Integer> existsData = new HashSet<>();

        Node dummyHead = new Node(0);
        dummyHead.next = head ;
        Node node = dummyHead ;
        while(node.next != null)
        {
            if(existsData.contains(node.next.data))
            {
                node.next = node.next.next ;
            }
            else
            {
                existsData.add(node.next.data);
                node = node.next ;
            }

        }

        return dummyHead.next ;
    }

    @Test
    public void test1()
    {

        Node node = new Node(4) ;
        node.appendToTail(4);
        node.appendToTail(5);
        node.appendToTail(4);
        node.appendToTail(6);
        node.appendToTail(5);

        Node head = removeDuplicates(node);

        int[] expected = new int[] {4 , 5, 6};
        int index = 0;
        while(head != null)
        {
            assertEquals(expected[index] , head.data);
            head = head.next;
            index++;
        }

    }

    @Test
    public void test2()
    {

        Node head = removeDuplicates(null);
        assertNull(head);
    }

    @Test
    public void test3()
    {
        Node head = removeDuplicates(new Node(3));
        assertEquals(3 , head.data);

    }


}
