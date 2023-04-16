import Cola.DinamicQueue;

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
    public boolean isEmpty() {
        return root == null;
    }

    //Recorridos
    @Override
    public LinkedList<T> preOrder(){
        LinkedList<T> lista = new LinkedList<>();
        return preOrder(root, lista);
    }
    private LinkedList<T> preOrder(BinaryTreeNodez<T> raiz, LinkedList<T> lista) {
        try{
            if(raiz != null){
                lista.add(raiz.data);
                preOrder(raiz.left, lista);
                preOrder(raiz.right, lista);
            }
            return lista;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public LinkedList<T> inOrder() {
        LinkedList<T> lista = new LinkedList<>();
        return inOrder(this.root, lista);
    }
    private LinkedList<T> inOrder(BinaryTreeNodez<T> root, LinkedList<T> lista) {
        try{

            if(root != null){
                inOrder(root.left, lista);
                lista.add(root.data);
                inOrder(root.right, lista);
            }
            return lista;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public LinkedList<T> postOrder() {
        LinkedList<T> lista = new LinkedList<>();
        return postOrder(root, lista);
    }
    private LinkedList<T> postOrder(BinaryTreeNodez<T> root, LinkedList<T> lista) {
        try{
            if(root != null){
                postOrder(root.left, lista);
                postOrder(root.right, lista);
                lista.add(root.data);
            }
            return lista;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public LinkedList<T> widthOrder() {
        LinkedList<T> lista = new LinkedList<>();
        return widthOrder(root, lista);
    }
    private LinkedList<T> widthOrder(BinaryTreeNodez<T> root, LinkedList<T> lista) {

        DinamicQueue<BinaryTreeNodez<T>> queue = new DinamicQueue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            BinaryTreeNodez<T> temp = queue.extract();

            if(temp != null){
                lista.add(temp.data);

                if(temp.left != null){
                    queue.insert(temp.left);
                }
                if(temp.right != null){
                    queue.insert(temp.right);
                }
            }
        }
        return lista;
    }

    //Insercion
    @Override
    public boolean insertWidth(T object) {
        if(root == null){
            root = new BinaryTreeNodez<>(object);
            elements++;
            return  true;
        }else{
            return insertWidth(root, object);
        }
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
                        elements++;
                        return true;
                    }
                    if(temp.right != null){
                        queue.insert(temp.right);
                    }else{
                        temp.right = new BinaryTreeNodez<>(object);
                        elements++;
                        return  true;
                    }
                }else{
                    temp = new BinaryTreeNodez<>(object);
                    elements++;
                    return true;
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
        if(root == null){
            root = new BinaryTreeNodez<>(object);
            elements++;
        }
        return insertDeep(root, object);
    }
    private boolean insertDeep(BinaryTreeNodez<T> raiz, T object){
        //insercion por preorder
        try{
            if(raiz == null){
                return false;
            }

            //si los hijos izquierdos o derechos están vacios
            if(raiz.left == null){
                raiz.left = new BinaryTreeNodez<>(object);
                elements++;
            }else if(raiz.right == null){
                raiz.right = new BinaryTreeNodez<>(object);
                elements++;
            }else {
                //Si los hijos izquierdos y derechos están llenos, aplicar recursividad
                if (raiz.left != null && raiz.right != null) {
                    insertDeep(raiz.left, object);
                }else{
                    insertDeep(raiz.right, object);
                }
            }

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Buscar
    @Override
    public boolean searchWidth(T object) {
        if(isEmpty()){
            System.out.println("El arbol está vacío");
            return false;
        }
        return searchWidth(root, object);
    }
    private boolean searchWidth(BinaryTreeNodez<T> node, T object){
        try{
            if(node == null){
                return false;
            }

            DinamicQueue<BinaryTreeNodez<T>> queue = new DinamicQueue<>();
            queue.insert(root);

            while(!queue.isEmpty()){
                BinaryTreeNodez<T> temp = queue.extract();

                if(temp != null){

                    if(temp.left != null){
                        if(temp.left.data.equals(object)){
                            queue.clear();
                            return true;
                        }else {
                            queue.insert(temp.left);
                        }
                    }
                    if(temp.right != null){
                        if(temp.right.data.equals(object)){
                            queue.clear();
                            return true;
                        }else {
                            queue.insert(temp.right);
                        }
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean searchDeep(T object) {
        if(isEmpty()){
            System.out.println("El arbol está vacío");
            return false;
        }
        return searchDeep(root, object);
    }
    private boolean searchDeep(BinaryTreeNodez<T> nodo, T object){
        try{
            if(nodo != null){
                //Recorrido en PostOrder
                boolean foundleft = searchDeep(nodo.left,object);
                boolean foundRight = searchDeep(nodo.right, object);

                return nodo.data.equals(object) || foundleft || foundRight;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Remover
    @Override
    public boolean removeWidth(T object) {
        try{
            if(isEmpty()) {
                System.out.println("No se puede eliminar, el arbol está vacío");
                return false;
            }
             return removeWidth(root, object);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private boolean removeWidth(BinaryTreeNodez<T> raiz, T object){
        try{
            if(raiz == null){
                return false;
            }
            DinamicQueue<BinaryTreeNodez<T>> queue = new DinamicQueue<>();
            queue.insert(root);

            while(!queue.isEmpty()){
                BinaryTreeNodez<T> temp = queue.extract();

                if(temp != null){

                    if(temp.left != null){
                        if(temp.left.data.equals(object)){
                            temp.left = reemplazar(temp.left);
                            elements--;
                            queue.clear();
                            return true;
                        }else {
                            queue.insert(temp.left);
                        }
                    }
                    if(temp.right != null){
                        if(temp.right.data.equals(object)){
                            temp.right = reemplazar(temp.right);
                            elements--;
                            queue.clear();
                            return true;
                        }else {
                            queue.insert(temp.right);
                        }
                    }
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean removeDeep(T object) {
        try{
            if(isEmpty()) {
                System.out.println("No se puede eliminar, el arbol está vacío");
                return false;
            }
            return removeDeep(root, object);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private boolean removeDeep(BinaryTreeNodez<T> raiz, T object){
        try{
            if (raiz == null) {
                return false;
            }

            if(raiz.left != null){
                if(raiz.left.data.equals(object)){
                    raiz.left = reemplazar(raiz.left);
                    elements--;
                    return true;
                }
            }else if(raiz.right != null){
                if(raiz.right.data.equals(object)){
                    raiz.right = reemplazar(raiz.right);
                    elements--;
                    return true;
                }
            }

            boolean leftRemoved = removeDeep(raiz.left, object);
            boolean rightRemoved =removeDeep(raiz.right, object);

            return leftRemoved || rightRemoved;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int height(){
        return height(root);
    }
    public int height(BinaryTreeNodez<T> nodo) {
        try{
            if(isEmpty() || nodo == null){
                return 0;
            }else{
                //caluclar los subarboles izquierdo y derecho
                int leftSubtree = height(nodo.left);
                int rightSubtree = height(nodo.right);

                //Calcular el mayor
                if(leftSubtree > rightSubtree){
                    return leftSubtree + 1;
                }else{
                    return rightSubtree + 1;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int size() {
        return elements;
    }

    //NodeCount() cuenta la cantidad de nodos desde la raiz
    @Override
    public int nodeCount() {
        try{
            return root.cantHijos();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //El arbol de altura k está lleno si tiene 2^k-1 nodos
    @Override
    public boolean isFull() {
        int nodeCant = (int) (Math.pow(2,height()) - 1);
        return size() == nodeCant;
    }

    /*Si está lleno hasta el nivel k-1 y todos los nodos están lo más a la izquierda posible*/
    @Override
    public boolean isComplete() {
        return isComplete(root,height(), 0);
    }
    public boolean isComplete(BinaryTreeNodez<T> nodo, int height, int level){
        if(nodo == null){
            return true;
        }
        if(level >= height){ //si el nivel actual es mayor a la altura del arbol
            return false;
        }

        if(isComplete(nodo.left, height, level+1) && isComplete(nodo.right, height, level+1)){
            return true;
        }else{
            return false;
        }
    }

    //Devuelve el nodo que sustituirá al que se va a reemplazar en el medoto remove

    /*
    Referencia para la realizacion del método reemplazar: Estructura de datos con java, diseño de estructuras y algoritmos
    Autrores: John Lewis y Joseph Chase
     */
    private BinaryTreeNodez<T> reemplazar(BinaryTreeNodez<T> nodo){
        try{
            BinaryTreeNodez<T> resultado;

            //Evaluacion del nodo en tres casos
            //Caso 1: El nodo no tiene ningun hijo
            if((nodo.left == null) && (nodo.right == null)){
                resultado = null;

                //Caso 2: El nodo solo tiene un hijo
            }else if((nodo.left != null) && (nodo.right == null)){
                resultado = nodo.left;
            }else if((nodo.left == null) && (nodo.right != null)){
                resultado = nodo.right;

                //Caso 3: El nodo tiene dos hijos. Evaluar a la derecha
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

                //Devuelve el sucesor del nodo que hay que eliminar
                resultado = actual;
            }
            return resultado;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
