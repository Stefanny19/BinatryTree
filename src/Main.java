public class Main {
    public static void main(String[] args) {

        BinaryTree<String> tree = new BinaryTree<>();

        BinaryTreeNodez ejemplo = tree.root;

        /*ejemplo.right = new BinaryTreeNodez("/");
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
        System.out.println(tree.widthOrderToString());*/

        tree.insertWidth("Alicia");
        tree.insertWidth("Ramón");
        tree.insertWidth("Jesús");
        tree.insertWidth("Stefanny");
        tree.insertWidth("Isabel");

        System.out.println("width");
        System.out.println(tree.widthOrder().toString());

        System.out.println("preorder");
        System.out.println(tree.preOrder().toString());

        System.out.println("inorder");
        System.out.println(tree.inOrder().toString());

        System.out.println(tree.size());

        tree.insertDeep("Miguel");
        tree.insertDeep("Manuel");
        tree.insertDeep("Sebastian");
        tree.insertDeep("Ciro");

        System.out.println("width");
        System.out.println(tree.widthOrder().toString());

        System.out.println("inorder");
        System.out.println(tree.inOrder().toString());

        System.out.println("preorder");
        System.out.println(tree.preOrder().toString());

        System.out.println("Search: Miguel");
        System.out.println(tree.searchDeep("Miguel"));
        System.out.println(tree.searchWidth("Miguel"));

        System.out.println("Search: Andrés");
        System.out.println(tree.searchDeep("Andrés"));
        System.out.println(tree.searchWidth("Andrés"));


        //System.out.println(tree.preOrderToString());
    }
}