package chapter2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Implement an algorithm to find the kth to the latest of a singly linked list
 */
public class Question2 {

    public Node findKth(Node head , int k)
    {
        Node kth = null;
        Node tail = head ;
        int index = 0;
        while(tail != null && index < k )
        {
            index++;
            tail = tail.next ;
        }

        if(index < k)
        {
            // Not enough records
            return null;
        }

        kth = head ;
        while(tail != null)
        {
            tail = tail.next ;
            kth = kth.next ;
        }
        return kth ;
    }

    @Test
    public void test()
    {
        Node head = new Node(5);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);

        Node node = findKth(head , 2);
        assertEquals(2 , node.data  );

        node = findKth(head , 1);
        assertEquals(1 , node.data);

        node = findKth(head , 5);
        assertEquals(5 , node.data);

        node = findKth(head , 6);
        assertNull(node);
    }

}
