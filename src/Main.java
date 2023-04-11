public class Main {
    public static void main(String[] args) {

        BinaryTree<String> tree = new BinaryTree<>("hola");
        tree.insertWidth("mamawebo");
        tree.insertWidth("joa");

        System.out.println(tree.inOrderToString());
    }
}