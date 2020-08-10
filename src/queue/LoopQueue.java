package queue;

/**
 * @ClassName LoopQueue
 * @Description
 * @Author serein
 * @Date 2020-08-10 20:55
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //full queue
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == data.length / 4 && getSize() != 0)
            resize(getCapacity() / 2);
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        return data[front];
    }

    private void resize(int newCapacity){
        E [] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue: Size: %d, Capacity: %d\n", getSize(), getCapacity()));
        builder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            builder.append(data[i]);
            if ((i + 1) % data.length != tail)
                builder.append(", ");
        }
        builder.append("] tail");
        return builder.toString();
    }
}
