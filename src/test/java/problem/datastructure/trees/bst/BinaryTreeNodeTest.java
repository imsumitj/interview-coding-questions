package problem.datastructure.trees.bst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeNodeTest {

    private final BinaryTreeNode<Integer> classToTest = new BinaryTreeNode<>(5);

    @Before
    public void before() {
        classToTest.setLeftNode(new BinaryTreeNode<>(10));
        classToTest.setRightNode(new BinaryTreeNode<>(3));
    }

    @Test
    public void checksIfGetterWorkAsExpected() throws Exception {
        assertTrue(classToTest.isLeftNodePresent());
        assertTrue(classToTest.isRightNodePresent());
        assertEquals(new Integer(5), classToTest.getData());
        assertEquals(new Integer(10), classToTest.getLeftNode().getData());
        assertEquals(new Integer(3), classToTest.getRightNode().getData());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenOverridingRightNode() throws Exception {
        classToTest.setRightNode(new BinaryTreeNode<>(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenOverridingLeftNode() throws Exception {
        classToTest.setLeftNode(new BinaryTreeNode<>(4));
    }
}