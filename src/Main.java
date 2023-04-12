public class Main {
    public static void main(String[] args) {

        BinaryTree<String> tree = new BinaryTree<>("+");

        BinaryTreeNodez ejemplo = tree.root;

        ejemplo.right = new BinaryTreeNodez("/");
        ejemplo.left = new BinaryTreeNodez("*");

        ejemplo = ejemplo.left;

        ejemplo.setLeft(new BinaryTreeNodez("a"));
        ejemplo.setRight(new BinaryTreeNodez("b"));

        ejemplo = tree.root;
        ejemplo = ejemplo.right;

        ejemplo.setRight(new BinaryTreeNodez("d"));
        ejemplo.setLeft(new BinaryTreeNodez("c"));

        System.out.println("inorder");
        System.out.println(tree.inOrderToString());

        System.out.println("preorder");
        System.out.println(tree.preOrderToString());

        System.out.println("PostOrder");
        System.out.println(tree.postOrderToString());

        System.out.println("width");
        System.out.println(tree.widthOrderToString());

        tree.insertWidth("mondá");
        tree.insertWidth("pa");
        tree.insertWidth("su");
        tree.insertWidth("jopo");
        tree.insertWidth("malparido");

        System.out.println("width");
        System.out.println(tree.widthOrderToString());

        tree.insertDeep("Marcela");
        tree.insertDeep("Coño");
        tree.insertDeep("cono");



        //System.out.println(tree.preOrderToString());
    }
}