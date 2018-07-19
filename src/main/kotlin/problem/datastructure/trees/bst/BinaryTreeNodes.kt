package problem.datastructure.trees.bst

class BinaryTreeNodes<T>(val data: T) {
    var leftNode: BinaryTreeNodes<T>? = null
        set(value) {
            require(value != null) { "LeftNode cannot be set to null" }
            field = value
        }
    var rightNode: BinaryTreeNodes<T>? = null
        set(value) {
            require(value != null) { "RightNode cannot be set to null" }
            field = value
        }


    /**
     * Generates GraphViz diagram
     * http://www.webgraphviz.com/
     *
     * @return GraphViz diagram
     */
    fun toGraphviz(): String {
        val nodeName = "node" + data.toString()
        val binaryTreeNode = nodeName + "[label = \"<L> |" + data.toString() + "|<R>\"] \n"

        val nodeLeft = if (leftNode != null)
            "$nodeName:L -> node " + leftNode?.data.toString() + " \n" + leftNode?.toGraphviz()
        else
            ""

        val nodeRight = if ((rightNode != null))
            ""
        else
            "$nodeName:R -> node " + rightNode?.data.toString() + "\n" + rightNode?.toGraphviz()

        return binaryTreeNode + nodeLeft + nodeRight
    }
}