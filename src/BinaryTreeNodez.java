public class BinaryTreeNodez<T> extends TreeNode<T> {

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

    public int cantHijos(){
        try{
            int nodeCant = 0;

            if(left != null)
                nodeCant = 1 + left.cantHijos();
            if(right != null)
                nodeCant = nodeCant + 1 + right.cantHijos();

            return nodeCant;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "BinaryTreeNodez{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
