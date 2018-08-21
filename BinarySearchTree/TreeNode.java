public class TreeNode<E> {
    private E data;
    private int count;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
        this.count = 1;
        this.left = null;
        this.right = null;
    }

    public E getData() {
        return this.data;
    }

    public TreeNode<E> getLeftNode() {
        return this.left;
    }

    public TreeNode<E> getRightNode() {
        return this.right;
    }

    public void setLeftNode(TreeNode<E> newNode) {
        this.left = newNode;
    }

    public void setRightNode(TreeNode<E> newNode) {
        this.right = newNode;
    }

    public int getCount() {
        return this.count;
    }

    public void increaseCount() {
        this.count++;
    }
}