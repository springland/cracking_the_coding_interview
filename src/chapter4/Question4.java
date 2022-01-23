package chapter4;

import chapter2.Node;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary search tree , design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g. if you have a tree with depth D , you will have D linked list )
 */
public class Question4 {

    public List<Node> travelTreeByLevel(TreeNode root)
    {


        List<Node>  nodesByLevel = new LinkedList<>();

        if(root == null) {
            return nodesByLevel;
        }

        List<TreeNode>  currentLevel = new LinkedList<>();

        currentLevel.add(root);
        do {
            Node dummyHead = new Node(0);
            List<TreeNode>  nextLevel = new LinkedList<>();
            for (TreeNode treeNode : currentLevel) {
                dummyHead.appendToTail(treeNode.value);
                if (treeNode.leftChild != null) {
                    nextLevel.add(treeNode.leftChild);
                }
                if (treeNode.rightChild != null) {
                    nextLevel.add(treeNode.rightChild);
                }
            }
            nodesByLevel.add(dummyHead.getNext());
            currentLevel = nextLevel ;
        }
        while(!currentLevel.isEmpty()) ;
        return nodesByLevel ;
    }

    @Test
    public void test()
    {
        TreeNode root = new TreeNode(10);
        List<Node>  nodesByLevel = null;

        nodesByLevel = travelTreeByLevel(root);
        assertEquals(nodesByLevel.size() , 1);

        /*
                                      10
                                    8       20
                                 6     9  15   24
                               5        12
                             4

 */

        root.leftChild = new TreeNode(8);
        root.leftChild.leftChild = new TreeNode(6);
        root.leftChild.rightChild = new TreeNode(9);
        root.leftChild.leftChild.leftChild = new TreeNode(5);
        root.leftChild.leftChild.leftChild.leftChild = new TreeNode(4);
        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(24);
        root.rightChild.leftChild.leftChild = new TreeNode(12);

        nodesByLevel = travelTreeByLevel(root);
        assertEquals(nodesByLevel.size() , 5);


        int[][] levelData = new int[5][];
        levelData[0]= new int[] {10};
        levelData[1] = new int[] {8 , 20};
        levelData[2] = new int[] {6 , 9 , 15 , 24};
        levelData[3] = new int[] {5 , 12};
        levelData[4] = new int[] {4};

        for(int levelIndex = 0 ; levelIndex < levelData.length ; levelIndex++)
        {
            Node node = nodesByLevel.get(levelIndex);
            for(int index = 0 ; index < levelData[levelIndex].length ; index++)
            {
                assertEquals(node.getData() , levelData[levelIndex][index]);
                node = node.getNext();
            }
        }
     }
}
