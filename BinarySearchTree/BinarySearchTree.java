public class BinarySearchTree<E extends Comparable<? super E>> {
    private TreeNode root;

    public BinarySearchTree(E data) {
        root = new TreeNode<E>(data);
    }

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode<E> getRootNode() {
        return this.root;
    }

    public void insert(E data, TreeNode node) {
        TreeNode<E> newNode = new TreeNode<E>(data);
        if (root == null) {
            root = newNode;
        } else {
            int comp = data.compareTo((E) node.getData());
            if (comp > 0 && node.getRightNode() != null) {
                insert(data, node.getRightNode());
            } else if (comp < 0 && node.getLeftNode() != null) {
                insert(data, node.getLeftNode());
            } else if (comp > 0 && node.getRightNode() == null) {
                node.setRightNode(newNode);
            } else if (comp < 0 && node.getLeftNode() == null) {
                node.setLeftNode(newNode);
            } else if (comp == 0) {
                node.increaseCount();
            }
        }
    }

    public void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preorderTraversal(node.getLeftNode());
        preorderTraversal(node.getRightNode());
    }

    public TreeNode findByData(E data, TreeNode node) {
        TreeNode findedNode = new TreeNode<E>(null);

        int comp = data.compareTo((E) node.getData());
        if (node != null) {
            if (comp == 0) {
                findedNode = node;
            } else if (comp < 0 && node.getLeftNode() != null) {
                return findByData(data, node.getLeftNode());
            } else if (comp > 0 && node.getRightNode() != null) {
                return findByData(data, node.getRightNode());
            } else if ((comp < 0 && node.getLeftNode() == null) || (comp > 0 && node.getRightNode() == null)) {
                findedNode = null;
            }

        } else {
            findedNode = null;
        }
        return findedNode;
    }
}