import Cola.DinamicQueue;

public class BinaryTree<T> implements TreeInterface<T> {

    BinaryTreeNodez<T> root;
    int height = 0;

    @Override
    public String preOrderToString(){
        return preOrderToString(root, "");
    }

    public String preOrderToString(BinaryTreeNodez<T> raiz, String string) {
        try{
            if(raiz != null){
                string += raiz.getObject().toString();
                string = preOrderToString(raiz.left, string);
                string = preOrderToString(raiz.right, string);
                height++; //??
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

    public String inOrderToString(BinaryTreeNodez<T> root, String string) {
        try{
            if(root != null){
                string += root.left.getObject().toString();
                string = preOrderToString(root, string);
                string = preOrderToString(root.right, string);
                height++; //??
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

    public String postOrderToString(BinaryTreeNodez<T> root, String string) {
        try{
            if(root != null){
                string += root.left.getObject().toString();
                string = preOrderToString(root.right, string);
                string = preOrderToString(root, string);
                height++; //??
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
    public String widthOrderToString(BinaryTreeNodez<T> root, String string) {

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
    public boolean insertWidth(BinaryTreeNodez<T> raiz, T object){

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

    @Override
    public boolean insertDeep(T object) {
        return false;
    }

    public boolean insertDeep(BinaryTreeNodez<T> raiz, T object){

        //comprobar si un nivel está incompleto

        try{

            boolean isOnLevel = false;



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


}
