package stack;

import java.util.Random;

/**
 * @ClassName TestStackTime
 * @Description
 * @Author serein
 * @Date 2020-08-11 22:04
 */
public class TestStackTime {

    public static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack time: " + time1 + " s");

        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        double time2 = testStack(listStack, opCount);
        System.out.println("LinkedStack time: " + time2 + " s");
    }
}
