package problem.datastructure.trees.bst;

import static com.google.common.base.Preconditions.checkArgument;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Node structure for Binary Tree which contain data of type <T>.
 *
 * @param <T>
 */
@Getter
@RequiredArgsConstructor class BinaryTreeNode<T> {

    @NonNull
    private final T data;

    private BinaryTreeNode<T> leftNode;
    private BinaryTreeNode<T> rightNode;

    void setLeftNode(@NonNull final BinaryTreeNode<T> newNode) {
        checkArgument(!isLeftNodePresent(), "Left node is already set, cannot be overridden");
        leftNode = newNode;
    }

    void setRightNode(@NonNull final BinaryTreeNode<T> newNode) {
        checkArgument(!isRightNodePresent(), "Right node already set, cannot be overridden");
        rightNode = newNode;
    }

    boolean isRightNodePresent() {
        return rightNode != null;
    }

    boolean isLeftNodePresent() {
        return leftNode != null;
    }

    public String toString() {
        final String left = (leftNode == null) ? "∅" : leftNode.toString();
        final String right = (rightNode == null) ? "∅" : rightNode.toString();
        return "(" + left + ", " + data.toString() + ", " + right + ")";
    }

    /**
     * JSON format which matches the one here: https://ysangkok.github.io/js-clrs-btree/btree.html
     *
     * @return JSON string
     */
    String toJson() {
        final String left = (leftNode == null) ? "{\"keys\": [\"∅\"]}" : leftNode.toJson();
        final String right = (rightNode == null) ? "{\"keys\": [\"∅\"]}" : rightNode.toJson();
        return "{\"keys\": [ \"" + data.toString() + "\"], \"children\": [" + left + ", " + right + "] }";
    }

    /**
     * Generates GraphViz diagram
     * http://www.webgraphviz.com/
     *
     * @return GraphViz diagram
     */
    String toGraphviz() {
        final String nodeName = "node" + data.toString();
        final String binaryTreeNode = nodeName + "[label = \"<L> |" + data.toString() + "|<R>\"] \n";

        final String nodeLeft = (leftNode == null) ? "" : nodeName + ":L -> " + "node" + leftNode.data.toString()
            + "\n" + leftNode.toGraphviz();
        final String nodeRight = (rightNode == null) ? "" : nodeName + ":R -> " + "node" + rightNode.data
            .toString() + "\n" + rightNode.toGraphviz();

        return binaryTreeNode + nodeLeft + nodeRight ;
    }
}