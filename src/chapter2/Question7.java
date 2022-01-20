package chapter2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Implements a function to check if a linked list is a palindrome
 * DEFINITION
 * a word, phrase, or sequence that reads the same backward as forward, e.g., madam or racecar.
 */
public class Question7 {

    public boolean isPalindrome(Node head)
    {
        boolean isPalindrome = false ;

        if(head == null || head.next == null)
        {
            return true ;
        }

        Node reverseHead = new Node(0);
        Node forward = head ;
        while(forward != null)
        {
            Node node = new Node(forward.data);
            node.next = reverseHead.next ;
            reverseHead.next = node ;
            forward = forward.next;
        }

        Node reverse = reverseHead.next;
        forward = head ;
        while(forward != null )
        {
            if(forward.data != reverse.data)
            {
                return false ;
            }
            forward = forward.next;
            reverse = reverse.next;
        }

        return true ;
    }

    @Test
    public void test()
    {
        assertTrue(isPalindrome(null));
        Node head = new Node(0);
        assertTrue(isPalindrome(head));
        head.appendToTail(0);
        assertTrue(isPalindrome(head));
        head.appendToTail(0);
        assertTrue(isPalindrome(head));
        head.appendToTail(1);
        assertFalse(isPalindrome(head));
        head.appendToTail(1);
        assertFalse(isPalindrome(head));
        head.appendToTail(0);
        head.appendToTail(0);
        head.appendToTail(0);
        assertTrue(isPalindrome(head));
    }
}
