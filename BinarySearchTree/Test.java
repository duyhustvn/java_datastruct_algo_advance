public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20, binarySearchTree.getRootNode());
        binarySearchTree.insert(7, binarySearchTree.getRootNode());
        binarySearchTree.insert(30, binarySearchTree.getRootNode());
        binarySearchTree.insert(25, binarySearchTree.getRootNode());
        binarySearchTree.insert(10, binarySearchTree.getRootNode());
        binarySearchTree.insert(4, binarySearchTree.getRootNode());
        binarySearchTree.insert(9, binarySearchTree.getRootNode());
        binarySearchTree.insert(5, binarySearchTree.getRootNode());
        binarySearchTree.insert(6, binarySearchTree.getRootNode());
        
        // preorder travel
        binarySearchTree.preorderTraversal(binarySearchTree.getRootNode());

        // find 
        System.out.println("");
        TreeNode findedNode = binarySearchTree.findByData(7, binarySearchTree.getRootNode());
        System.out.println(findedNode.getData());
        if (findedNode.getRightNode() != null)
            System.out.println("Right children: " + findedNode.getRightNode().getData());

        if (findedNode.getLeftNode() != null)
            System.out.println("Left children: " + findedNode.getLeftNode().getData());

        System.out.println("Root: " + binarySearchTree.getRootNode().getData());

        System.out.println("*Remove Node*");
        binarySearchTree.removeNode(7);

         // preorder travel
         binarySearchTree.preorderTraversal(binarySearchTree.getRootNode());
    }
}