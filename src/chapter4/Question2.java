package chapter4;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given a directed grpah , design an algorithm to find out whether there is a route between two nodes
 */
public class Question2 {

    public boolean hasRoute(GraphNode node1 , GraphNode node2)
    {

        if(node1 == node2)
        {
            return true ;
        }

        if(node1 == null || node2 == null)
        {
            return false ;
        }
        LinkedList<GraphNode>  nodes = new LinkedList<>();
        nodes.addAll(node1.neighbours);
        HashSet<GraphNode>  visited = new HashSet<>();

        while(!nodes.isEmpty())
        {
            GraphNode node = nodes.removeFirst();
            if(visited.contains(node))
            {
                continue ;
            }
            if(node == node2)
            {
                return true ;
            }

            visited.add(node);
            nodes.addAll(node.neighbours);
        }
        return false ;
    }

    @Test
    public void test()
    {
        assertTrue(hasRoute(null , null));
        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();
        assertFalse(hasRoute(node1  , null));

        assertFalse(hasRoute(node1 , node2));

        GraphNode node3 = new GraphNode() ;
        node1.neighbours.add(node3);
        assertFalse(hasRoute(node1 , node2));

        GraphNode node4 = new GraphNode();
        node3.neighbours.add(node4);
        node4.neighbours.add(node1);

        assertFalse(hasRoute(node1 , node2));
        assertTrue(hasRoute(node1 , node4));

        node4.neighbours.add(node2);
        assertTrue(hasRoute(node1 , node2));
    }
}
