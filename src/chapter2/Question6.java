package chapter2;

/**
 * Given a  circula linked list, implement an algorithm which returns the node at the begin of the loop
 *
 * DEFINITION
 * Circular linked list: A linked list in which a node;s next pointer points to an earlier node. so as to make a loop in the linked list
 * EXAMPLE
 * Input : A-> B-> C-> D-> E-> C ( the same C as earlier)
 * Output: C
 */
public class Question6 {

    /**
     * Returns loopBegin or null if there is no loop
     * @param head
     * @return
     */
    public Node findLoopBegin(Node head)
    {
        /*
            suppose the distance from head to the circle begin is r and the circle length is q

            1) total length = r+q
            2) Suppose the slow node speed is x , the fast node speed is 2x , if there is a circle they will meet
            3) when they meet  slow node is (x-r)%q , fast node is (2x-r)%q
              (x-r)%q == (2x-r)%q

              q-(x-r)%q    r


         */
        return null;
    }
}
