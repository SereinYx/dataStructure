package array;

/**
 * @ClassName Array
 * @Description 数组类
 * @Author serein
 * @Date 2020-08-06 14:20
 */
@SuppressWarnings("unchecked")
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构建函数，传入数组的容量capacity
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity = 10
    public Array(){
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length){
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Index is Illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素
    public void set(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Index is Illegal.");
        }
        data[index] = e;
    }

    // 查询数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查询数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Require index >=0 and index < size");
        }
        E res = data[index];
        for (int i = index + 1;i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;  // loitering objects

        if (size == data.length / 2){
            resize(data.length / 2);
        }
        return res;
    }


    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public boolean removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    // 扩容或减容数组空间
    private void resize(int newCapacity){
        E [] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
