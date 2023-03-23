public class BinaryTreeNodez<T> extends TreeNode {

    BinaryTreeNodez<T> left, right;

    public BinaryTreeNodez() {
        left = right = null;
    }

    public BinaryTreeNodez(T data) {
        super(data);
        left = right = null;
    }

    public BinaryTreeNodez(T data, BinaryTreeNodez<T> left, BinaryTreeNodez<T> right) {
        super(data);
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNodez<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNodez<T> left) {
        this.left = left;
    }

    public BinaryTreeNodez<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNodez<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNodez{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
