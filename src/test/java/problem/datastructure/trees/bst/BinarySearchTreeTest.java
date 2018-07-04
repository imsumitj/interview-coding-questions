package problem.datastructure.trees.bst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testAddNewNode() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(25);
        bst.add(8).add(1).add(4).add(5).add(0).add(30).add(3).add(21).add(36);
        System.out.println(bst.toGraphViz());

        assertTrue(bst.contains(3));
        assertTrue(bst.contains(8));
        assertTrue(bst.contains(25));

        assertFalse(bst.contains(35));
        assertFalse(bst.contains(2));
    }

}