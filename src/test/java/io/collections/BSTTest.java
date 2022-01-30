package io.collections;

import io.collections.trees.BST;
import org.junit.jupiter.api.Test;

public class BSTTest
{

    /*
     *                      50
     *                     /  \
     *                   25    52
     *                  /  \   /  \
     *                20   27 51   54
     *
     *    Output -> 50, 25, 52, 20, 27, 51, 54
     */
    @Test
    public void testTraverseLevelOrder()
    {
        BST<Integer> bst = new BST<>();
        bst.add(50);
        bst.add(25);
        bst.add(52);
        bst.add(20);
        bst.add(27);
        bst.add(54);
        bst.add(51);
        bst.traverseLevelOrder();
    }

    /*
     *                     50
     *                   /    \
     *                  25      52
     *                 /  \    /  \
     *                20   27 51   54
     *
     *    Output -> 20, 25, 27, 50, 51, 52, 54
     */
    @Test
    public void testTraverseInOrder()
    {
        BST<Integer> bst = new BST<>();
        bst.add(50);
        bst.add(25);
        bst.add(52);
        bst.add(20);
        bst.add(27);
        bst.add(54);
        bst.add(51);
        bst.traverseInorder();
    }

    /*
     *                     15
     *                   /    \
     *                 10       31
     *               /   \     /   \
     *              5     13  25    45
     *            /         \   \     \
     *           1           14  27    71
     *                                   \
     *                                    91
     *    Inorder output -> 1, 5, 10, 13, 14, 15, 24, 25, 27, 31, 45, 1, 14, 27, 71, 91
     *    Height -> 4
     *    Has Key 27 -> true
     */
    @Test
    public void testRecursiveInsertion()
    {
        BST<Integer> bst = new BST<>();
        bst.insert(15);
        bst.insert(10);
        bst.insert(31);
        bst.insert(5);
        bst.insert(13);
        bst.insert(25);
        bst.insert(45);
        bst.insert(1);
        bst.insert(14);
        bst.insert(27);
        bst.insert(71);
        bst.insert(91);
        bst.traverseInorder();
        System.out.println();
        System.out.println(" Has key 27 : "+bst.hasKey(27));
        System.out.println("Height of tree : "+bst.height());
    }

    /*
     *                     15
     *                   /    \
     *                 10       31
     *               /   \     /   \
     *              5     13  25    45
     *            /         \   \     \
     *           1           14  27    71
     *                                   \
     *                                    91
     *    Inorder output -> 1, 5, 10, 13, 14, 15, 25, 27, 31, 45, 71, 91
     *    Height -> 4
     *    Has Key 27 -> true
     */
    @Test
    public void testDeletion()
    {
        BST<Integer> bst = new BST<>();
        bst.insert(15);
        bst.insert(10);
        bst.insert(31);
        bst.insert(5);
        bst.insert(13);
        bst.insert(25);
        bst.insert(45);
        bst.insert(1);
        bst.insert(14);
        bst.insert(27);
        bst.insert(71);
        bst.insert(91);
        bst.traverseInorder();
        System.out.println();
        System.out.println(" Case 1 :- Removing node with no children i.e. 91 ");
        bst.remove(91);
        bst.traverseInorder();
        System.out.println();
        System.out.println(" Case 2 :- Removing node with one children i.e. 25 ");
        bst.remove(25);
        bst.traverseInorder();

        System.out.println();
        System.out.println(" Case 3 :- Removing node with two children i.e. 10 ");
        bst.remove(10);
        bst.traverseInorder();

        //one more case to handle
        // if you delete root element deletion fails

    }


}
