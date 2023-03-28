import Cola.DinamicQueue;

public class BinaryTree<T> implements TreeInterface<T> {

    BinaryTreeNodez<T> root;
    int elements = 0; //numero de elementos del arbol

    public BinaryTree() {
        this.root = null;
        elements = 0;
    }

    public BinaryTree(T object) {
        this.root = new BinaryTreeNodez<>(object);
        elements = 1;
    }

    //crear un arbol a partir de sub-árboles
    public BinaryTree(T object, BinaryTree<T> leftSubtree,BinaryTree<T> rightSubtree) {
        this.root = new BinaryTreeNodez<>(object);
        elements = 1;

        if(leftSubtree != null){
            elements = elements + leftSubtree.size();
            root.left = leftSubtree.root;
        } else {
            root.left = null;
        }

        if(rightSubtree != null){
            elements = elements + rightSubtree.size();
            root.right = rightSubtree.root;
        }else{
            root.right = null;
        }
    }

    @Override
    public String preOrderToString(){
        return preOrderToString(root, "");
    }

    private String preOrderToString(BinaryTreeNodez<T> raiz, String string) {
        try{
            if(raiz != null){
                string += raiz.getObject().toString();
                string = preOrderToString(raiz.left, string);
                string = preOrderToString(raiz.right, string);
                elements++; //??
            }
            return string;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String inOrderToString() {
        return inOrderToString(root, "");
    }

    private String inOrderToString(BinaryTreeNodez<T> root, String string) {
        try{

            if(root != null){
                string += root.left.getObject().toString();
                string = inOrderToString(root, string);
                string = inOrderToString(root.right, string);
                elements++; //??
            }
            return string;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String postOrderToString() {
        return postOrderToString(root, "");
    }

    private String postOrderToString(BinaryTreeNodez<T> root, String string) {
        try{
            if(root != null){
                string += root.left.getObject().toString();
                string = postOrderToString(root.right, string);
                string = postOrderToString(root, string);
                elements++; //??
            }
            return string;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String widthOrderToString() {
        return widthOrderToString(root, "");
    }
    private String widthOrderToString(BinaryTreeNodez<T> root, String string) {

        DinamicQueue<TreeNode<T>> queue = new DinamicQueue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            BinaryTreeNodez<T> temp = (BinaryTreeNodez<T>) queue.extract();
            string += temp.getObject().toString();

            if(temp.left != null){
                queue.insert(temp.left);
            }
            if(temp.right != null){
                queue.insert(temp.right);
            }
        }
        return string;
    }

    @Override
    public boolean insertWidth(T object) {
        return insertWidth(root, object);
    }
    private boolean insertWidth(BinaryTreeNodez<T> raiz, T object){

        try{

            DinamicQueue<TreeNode<T>> queue = new DinamicQueue<>();
            queue.insert(raiz);

            while(!queue.isEmpty()){
                BinaryTreeNodez<T> temp = (BinaryTreeNodez<T>) queue.extract();

                if(temp.left != null){
                    queue.insert(temp.left);
                }else{
                    temp.left = new BinaryTreeNodez<>(object);
                    return true;
                }
                if(temp.right != null){
                    queue.insert(temp.right);
                }else{
                    temp.right = new BinaryTreeNodez<>(object);
                    return  true;
                }
            }
            return false;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //insersion por inorder
    @Override
    public boolean insertDeep(T object) {
        try{
            if(root == null){
                root = new BinaryTreeNodez<>(object);
            }else{
                insertDeep(root,object);
            }
            return true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private boolean insertDeep(BinaryTreeNodez<T> raiz, T object){

        //comprobar si un nivel está incompleto

        try{





        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeWidth(T object) {
        return false;
    }

    @Override
    public boolean removeDeep(T object) {
        return false;
    }

    @Override
    public int height(BinaryTreeNodez<T> root) {

        try{
            if(root == null){
                return 0;
            }

            //Obtener la altura de cada nodo, derecho e izquierdo
            int rHeight = height(root.right);
            int lHeight = height(root.left);

            //Comprobar cual es el mayor
            if(rHeight > lHeight){
                return rHeight;
            }else{
                return lHeight;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }


}
