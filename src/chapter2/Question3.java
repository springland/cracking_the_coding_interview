package chapter2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list give only access to that node
 * Example the node c from the linked list  a->b->c->d->e
 * Result: Nothing is returned, but the new linked list looks like a->b->d->e
 */
public class Question3 {

    // cannot delete the tail node
    public void deleteNode(Node node)
    {

        Node prev = node;
        while (node.next != null) {
            node.data = node.next.data;
            prev = node ;
            node = node.next ;
        }
        prev.next = null;
    }

    @Test
    public void test1()
    {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);

        deleteNode(head);

        assertEquals(head.data , 2);
        assertEquals(head.next.data , 3);
        assertNull(head.next.next );


    }

    @Test
    public void test2()
    {
        Node head = new Node(1);
        Node node = new Node(2);
        node.appendToTail(3);;
        head.next = node ;

        deleteNode(node);

        assertEquals(head.data , 1);
        assertEquals(head.next.data , 3);
        assertNull(head.next.next );


    }

}
