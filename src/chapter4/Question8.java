package chapter4;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * You have two very large binary tree: T1 with millions of nodes and T2 with hunderds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 *
 * A tree T2 is a subtree of T1 if there exists a node in T1 such that the subtree of n is identical to T2.
 * That is if you cut of the tree at node n , the two trees would be identical
 */
public class Question8 {

    public boolean isSubTree(TreeNode t1 , TreeNode t2)
    {
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(t1);
        TreeNode t2Match = null;
        while(!queue.isEmpty())
        {
            TreeNode node = queue.removeFirst();
            if(node.leftChild!= null)
            {
                queue.add(node.leftChild);
            }
            if(node.rightChild != null)
            {
                queue.add(node.rightChild);
            }
            if(node.value == t2.value)
            {
                if(match(node , t2))
                {
                    return true ;
                }
            }
        }

        return false ;
    }

    protected boolean match(TreeNode t1 , TreeNode t2)
    {
        if(t1 != null && t2 != null)
        {
            if(t1.value != t2.value) {
                return false;
            }

            if(!match(t1.leftChild , t2.leftChild))
            {
                return false ;
            }

            return match(t1.rightChild , t2.rightChild);

        }
        else if( t1 == null && t2 != null)
        {
            return false;
        }
        else if ( t1 != null )
        {
            return false ;
        }
        return true ;
    }

    @Test
    public void test()
    {
       TreeNode srcRoot = new TreeNode(10);
       TreeNode srcNode1 = new TreeNode(5);
       TreeNode srcNode2 = new TreeNode(6);
       srcRoot.leftChild = srcNode1;
       srcRoot.rightChild = srcNode2;

       TreeNode targetRoot = new TreeNode(6);
       assertTrue(isSubTree(srcRoot , targetRoot));

       TreeNode targetNode1 = new TreeNode(5);
       targetRoot.leftChild = targetNode1;

       assertFalse(isSubTree(srcRoot , targetRoot));

       TreeNode srcNode3 = new TreeNode(6);
       srcNode2.rightChild = srcNode3;
        assertFalse(isSubTree(srcRoot , targetRoot));

        TreeNode srcNode4 = new TreeNode(6);
        srcNode1.leftChild = srcNode4;
        assertFalse(isSubTree(srcRoot , targetRoot));

        TreeNode srcNode5 = new TreeNode(4);
        srcNode4.leftChild = srcNode5 ;

        assertFalse(isSubTree(srcRoot , targetRoot));

        TreeNode srcNode6 = new TreeNode(5);
        srcNode3.leftChild = srcNode6 ;
        assertTrue(isSubTree(srcRoot , targetRoot));
    }

}
