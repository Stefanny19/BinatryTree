public class Main {
    public static void main(String[] args) {

        BinaryTree<String> tree = new BinaryTree<>();

        tree.insertWidth("Alicia");
        tree.insertWidth("Ramón");
        tree.insertWidth("Jesús");
        tree.insertWidth("Stefanny");
        tree.insertWidth("Isabel");
        tree.insertWidth("Camila");

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

        System.out.println("widthOrder");
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

        System.out.println("Remove: Miguel");
        System.out.println(tree.removeWidth("Miguel"));

        System.out.println("Remove: Ciro");
        System.out.println(tree.removeDeep("Ciro"));
        System.out.println(tree.widthOrder().toString());

        System.out.println("Size:" + tree.size());

        System.out.println("Height: " + tree.height());

        System.out.println("Node count: " + tree.nodeCount());

        System.out.println("Is Full?: " + tree.isFull());

        System.out.println("Is complete?: " + tree.isComplete());


    }
}