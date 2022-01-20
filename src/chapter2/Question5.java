package chapter2;

/**
 *  You have two numbers represented by a linked list , where each node contains a
 *  single digit , the digits are sorted in reverse order , such that the 1's digit is ta
 *  the head of the list , write a function that adds the two numbers and returns the sum as
 *  a linked list
 *  Example
 *  Input ( 7->1->6) + (5->9->2) . This is 617 + 295
 *  Output 2->1->9. That is 912
 *
 *  Follow up
 *  Supposes the digits are sorted in the forward order , Repeat the above problem
 *  Example
 *  Input : 6->1->7 + (2->9 -> 5) that is 617 + 295
 *  Output : 9->1-> 2 that is 912
 *
 */
public class Question5 {

    //( 7->1->6) + (5->9->2) . This is 617 + 295
    public Node addReverseSequqnce(Node head1 , Node head2)
    {
        Node dummyHead = new Node(-1);
        Node tail = dummyHead ;

        int carry = 0;
        int value = 0;
        while(head1 != null && head2 != null)
        {
            value = head1.data + head2.data + carry;
            carry = value /10;
            value = value % 10;
            Node node = new Node(value);
            tail.next = node ;
            tail = node ;
            head1 = head1.next;
            head2 = head2.next ;
        }

        while(head1 != null)
        {
            value = head1.data + carry;
            carry = value /10;
            value = value %10;
            Node node = new Node(value);
            tail.next = node ;
            tail = node ;
            head1 = head1.next ;
        }

        while(head2 != null)
        {
            value = head2.data + carry;
            carry = value /10;
            value = value %10;
            Node node = new Node(value);
            tail.next = node ;
            tail = node ;
            head2 = head2.next ;
        }

        return dummyHead.next ;
    }

    public Node add(Node head1 , Node head2)
    {

        return null;
    }

}
