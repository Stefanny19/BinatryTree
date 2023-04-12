import Cola.DinamicQueue;
import Cola.Tools.DoublyLinkedList;
import Cola.Tools.DoublyLinkedListNode;
import Cola.*;

import java.util.LinkedList;

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

    //Recorridos
    @Override
    public String preOrderToString(){
        LinkedList<T> lista = new LinkedList<>();
        return preOrderToString(root, lista);
    }
    private String preOrderToString(BinaryTreeNodez<T> raiz, LinkedList<T> lista) {
        try{
            if(raiz != null){
                lista.add((T) raiz.getObject());
                preOrderToString(raiz.left, lista);
                preOrderToString(raiz.right, lista);
            }
            return lista.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String inOrderToString() {
        LinkedList<T> lista = new LinkedList<>();
        return inOrderToString(this.root, lista);
    }
    private String inOrderToString(BinaryTreeNodez<T> root, LinkedList<T> lista) {
        try{

            if(root != null){
                inOrderToString(root.left, lista);
                lista.add((T) root.data);
                inOrderToString(root.right, lista);
            }
            return lista.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String postOrderToString() {
        LinkedList<T> lista = new LinkedList<>();
        return postOrderToString(this.root, lista);
    }
    private String postOrderToString(BinaryTreeNodez<T> root, LinkedList<T> lista) {
        try{
            if(root != null){
                postOrderToString(root.left, lista);
                postOrderToString(root.right, lista);
                lista.add((T) root.data);
            }
            return lista.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String widthOrderToString() {
        LinkedList<T> lista = new LinkedList<>();
        return widthOrderToString(root, lista);
    }
    private String widthOrderToString(BinaryTreeNodez<T> root, LinkedList<T> lista) {

        DinamicQueue<BinaryTreeNodez<T>> queue = new DinamicQueue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            BinaryTreeNodez<T> temp = queue.extract();

            if(temp != null){
                lista.add((T) temp.data);

                if(temp.left != null){
                    queue.insert(temp.left);
                }
                if(temp.right != null){
                    queue.insert(temp.right);
                }
            }
        }
        return lista.toString();
    }

    //Insercion
    @Override
    public boolean insertWidth(T object) {
        return insertWidth(root, object);
    }
    private boolean insertWidth(BinaryTreeNodez<T> raiz, T object){
        try{

            DinamicQueue<BinaryTreeNodez<T>> queue = new DinamicQueue<>();
            queue.insert(raiz);

            while(!queue.isEmpty()){
                BinaryTreeNodez<T> temp = queue.extract();

                if(temp != null){

                    if(temp.left != null){
                        queue.insert(temp.left);
                    }else{
                        temp.left = new BinaryTreeNodez<>(object);
                        //root = temp;
                        return true;
                    }
                    if(temp.right != null){
                        queue.insert(temp.right);
                    }else{
                        temp.right = new BinaryTreeNodez<>(object);
                        //root = temp;
                        return  true;
                    }
                }else{
                    temp = new BinaryTreeNodez<>(object);
                    //root = temp;
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
        //insercion por preorder
        try{
            //si los hijos izquierdos o derechos están vacios
            if(raiz.left == null){
                raiz.left = new BinaryTreeNodez<>(object);
            }else if(raiz.right == null){
                raiz.right = new BinaryTreeNodez<>(object);
            }

            //Si los hijos izquierdos y derechos están llenos, aplicar recursividad
            if (raiz.left != null && raiz.right != null) {
                insertDeep(raiz.left, object);
            }else{
                insertDeep(raiz.right, object);
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Remover
    @Override
    public boolean removeWidth(T object) {
        try{
            if(root == null){
                System.out.println("No se puede eliminar, el arbol está vacío");
                return false;
            }else{
                removeWidth(root, object);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean removeWidth(BinaryTreeNodez<T> raiz, T object){
        try{


        }catch (Exception e){
            e.printStackTrace();
        }
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

    private BinaryTreeNodez<T> reemplazar(BinaryTreeNodez<T> nodo){
        try{
            BinaryTreeNodez<T> resultado;

            if((nodo.left == null) && (nodo.right == null)){
                resultado = null;
            }else if((nodo.left != null) && (nodo.right == null)){
                resultado = nodo.left;
            }else if((nodo.left == null) && (nodo.right != null)){
                resultado = nodo.right;
            }else{

                BinaryTreeNodez<T> actual = nodo.right;
                BinaryTreeNodez<T> padre = nodo;

                while(actual.left != null){
                    padre = actual;
                    actual = actual.left;
                }

                if(nodo.right == actual){
                    actual.left = nodo.left;
                }else{
                    padre.left = actual.right;
                    actual.right = nodo.right;
                    actual.left = nodo.left;
                }

                resultado = actual;
            }
            return resultado;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
