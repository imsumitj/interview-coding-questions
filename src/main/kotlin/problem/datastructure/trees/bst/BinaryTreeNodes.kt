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

        var returnString = binaryTreeNode

        if (leftNode != null)
            returnString  += "$nodeName:L -> node" + leftNode?.data.toString() + " \n" + leftNode?.toGraphviz()

        if (rightNode != null)
            returnString += "$nodeName:R -> node" + rightNode?.data.toString() + "\n" + rightNode?.toGraphviz()

        return returnString
    }
}