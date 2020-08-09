package stack;

/**
 * @ClassName Stack
 * @Description
 * @Author serein
 * @Date 2020-08-09 18:08
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
