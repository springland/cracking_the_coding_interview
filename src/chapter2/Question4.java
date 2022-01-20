package chapter2;

/**
 * Write code to partition a linked list around a value x , such that all nodes less that x come
 * before all nodes greater than or equal to x
 */
public class Question4 {

    public Node partition(Node head , int x)
    {
        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);

        Node node = head ;
        while(node != null)
        {
            Node next = node.next ;
            if(node.data < x)
            {
                node.next = lessHead.next;
                lessHead.next = node ;
            }
            else
            {
                node.next = greaterHead.next ;
                greaterHead.next = node ;

            }
            node = next ;
        }

        if(lessHead.next != null )
        {
            node = lessHead.next;
            while(node.next != null)
            {
                node = node.next ;
            }
            node.next = greaterHead.next;
            return lessHead.next;

        }
        else {
            return greaterHead.next ;
        }

    }
}
