package chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * You are given a binary tree in which each node contains a value.
 * Design an algorithm to print all paths which sum to a given value
 * Note that a path can start or end anywhere in the tree
 */
public class Question9 {

    /**
     *
     * @param root
     * @param target  subpath total includes root
     * @param total  total
     * @return
     */
    public List<List<TreeNode>>  findAllPathes(TreeNode root , int target , int total)
    {

        List<List<TreeNode>>  subPathes ;
        List<List<TreeNode>>  pathes = new ArrayList<>();


        if(root != null) {

            pathes.addAll(findSubPathes(root, target));

            subPathes = findAllPathes(root.leftChild, total, total);
            pathes.addAll(subPathes);
            subPathes = findAllPathes(root.rightChild, total, total);
            pathes.addAll(subPathes);
        }

        return pathes;
    }

    protected List<List<TreeNode>> findSubPathes(TreeNode root , int target)
    {
        List<List<TreeNode>>  subPathes ;
        List<List<TreeNode>>  pathes = new ArrayList<>();

        if(root == null)
        {
            return pathes;
        }

        if(target == root.value)
        {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            pathes.add(path);

        }
        if(target - root.value > 0) {

            subPathes = findSubPathes(root.leftChild, target - root.value );

            pathes.addAll(buildPathes(root , subPathes));


            subPathes = findSubPathes(root.rightChild, target - root.value);

            pathes.addAll(buildPathes(root , subPathes));

        }
        return pathes ;

    }

    protected List<List<TreeNode>>  buildPathes(TreeNode root , List<List<TreeNode>> subpathes)
    {
        List<List<TreeNode>> pathes = new ArrayList<>();
        for(List<TreeNode> subpath : subpathes)
        {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            path.addAll(subpath);
            pathes.add(path);
        }
        return pathes ;
    }


    @Test
    public void test()
    {

        /*
                                                root (1)
                                               /        \
                                       node1 (1)         node2 (2)
                                       /       \          /    \
                               node3(2)   node5(2)   node6(1)  node7(2)
                                   \
                                  node4(2)




         */
       TreeNode root = new TreeNode( "root" , 1);

       TreeNode node1 = new TreeNode("node1" , 1);
       root.leftChild = node1;
       TreeNode node2 = new TreeNode("node2" , 2);
       root.rightChild = node2 ;
       TreeNode node3 = new TreeNode("node3" , 2);
       node1.leftChild = node3 ;
       TreeNode node4 = new TreeNode("node4" , 2);
       node3.rightChild = node4 ;

       TreeNode node5 = new TreeNode("node5" , 2);
       node1.rightChild = node5;

       TreeNode node6 = new TreeNode("node6" , 1);
       node2.leftChild = node6;

       TreeNode node7 = new TreeNode("node7" , 2);
       node2.rightChild = node7;

       //total = 3  [ root , node2] , [node1 , node5] [ node1 , node3] ,[node2 , node6]

        List<List<TreeNode>> pathes ;

       pathes = findAllPathes(root , 3 , 3);
       assertEquals(pathes.size() , 4);
        System.out.println("total = 3");
       for(List<TreeNode> path: pathes)
       {
           printPath(path);
           assertTrue(validPathTotal(path , 3));

       }


       System.out.println("total = 4");
        // total = 4  [root , node1 , node3 ] , [root , node1 , node5] , [node3 , node4] , [root , node2 , node6] , [node2 , node7]

        pathes = findAllPathes(root , 4 , 4);
        assertEquals(pathes.size() , 5);
        for(List<TreeNode> path: pathes)
        {
            printPath(path);
            assertTrue(validPathTotal(path , 4));

        }

    }

    public boolean validPathTotal(List<TreeNode> path , int total)
    {
        for(TreeNode node : path)
        {
            total = total - node.value;
        }

        return total == 0 ;
    }
    public void printPath(List<TreeNode> path)
    {
       for(TreeNode node: path)
       {
           System.out.print(node.toString() + " -> " );
       }
       System.out.println("null");
    }
}
