package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Write an algorithm to find the next node ( in order successor ) of an give node in a binary search tree
 * You may assume that each node has a link to its parent
 *
 */
public class Question6 {

    /**
     * Find the next node from the binary search tree
     * @param node
     * @return
     */
    public TreeNode findNext(TreeNode  node)
    {
        if(node.rightChild != null)
        {
            return findSmallest(node.rightChild);
        }
        else
        {
            if(node.parent == null)
            {
                return null;
            }
            else
            {
                // this is parent's right child
                TreeNode next ;
                next = node.parent ;
                while(next  != null && next.rightChild == node)
                {
                    next = next.parent ;
                    node = node.parent ;
                }

                return next ;
            }

        }

    }

    protected TreeNode findSmallest(TreeNode root)
    {
        if(root.leftChild != null)
        {
            return findSmallest(root.leftChild);
        }
        else
        {
            return root ;
        }
    }


    @Test
    public void test()
    {
        TreeNode root = new TreeNode(10);
        root.leftChild = new TreeNode(5);
        root.leftChild.parent = root ;

        root.leftChild.leftChild = new TreeNode(3);
        root.leftChild.leftChild.parent = root.leftChild;

        root.leftChild.rightChild = new TreeNode(6);
        root.leftChild.rightChild.parent =root.leftChild;

        TreeNode node = findNext(root);
        assertNull(node);

        node = findNext(root.leftChild.leftChild);
        assertEquals(node.value , 5);
        node = findNext(root.leftChild.rightChild);
        assertEquals(node.value , 10);

        root.rightChild = new TreeNode(20);
        root.rightChild.parent = root ;

        node = findNext(root.rightChild);
        assertNull(node);


        root.rightChild.rightChild = new TreeNode(30);
        root.rightChild.rightChild.parent =root.rightChild.rightChild;



        root.rightChild.rightChild.leftChild = new TreeNode(25);
        root.rightChild.rightChild.leftChild.parent =root.rightChild.rightChild;
        node = findNext(root);
        assertEquals(node.value , 20);

        node = findNext(root.rightChild);
        assertEquals(node.value , 25);
    }
}
