package queue;

/**
 * @ClassName 队列
 * @Description
 * @Author serein
 * @Date 2020-08-09 20:40
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
