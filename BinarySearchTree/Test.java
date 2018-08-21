public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20, binarySearchTree.getRootNode());
        binarySearchTree.insert(7, binarySearchTree.getRootNode());
        binarySearchTree.insert(30, binarySearchTree.getRootNode());
        binarySearchTree.insert(25, binarySearchTree.getRootNode());
        binarySearchTree.insert(10, binarySearchTree.getRootNode());
        binarySearchTree.insert(5, binarySearchTree.getRootNode());
        
        binarySearchTree.preorderTraversal(binarySearchTree.getRootNode());
    }
}