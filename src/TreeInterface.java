import java.util.LinkedList;

public interface TreeInterface<T> {
    LinkedList<T> preOrder();
    LinkedList<T> inOrder();
    LinkedList<T> postOrder();
    LinkedList<T> widthOrder();
    boolean insertWidth(T object);
    boolean insertDeep(T object);
    boolean searchWidth(T object);
    boolean searchDeep(T object);
    boolean removeWidth(T object);
    boolean removeDeep(T object);
    int height();
    int size();
    boolean isEmpty();
    int nodeCount();
    boolean isFull();
    boolean isComplete();
}
