package binarysearchtree;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName BinarySearchTree
 * @Description
 * @Author serein
 * @Date 2020-08-14 21:20
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e){
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }
    
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else return contains(node.right, e);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null){
            return; 
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node node){
        if (node == null){
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public E minimum(){
        if (size == 0){
            throw new IllegalArgumentException();
        }
        return minimum(root).e;
    }

    public Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    public Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            size--;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E maxmum(){
        if (size == 0){
            throw new IllegalArgumentException();
        }
        return maxmum(root).e;
    }

    public Node maxmum(Node node){
        if (node.right == null){
            return node;
        }
        return maxmum(node.right);
    }

    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    public Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            size--;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root, e);
    }

    public Node remove(Node node, E e){
        if (node == null){
            return null;
        }
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node cur = minimum(node.right);
            cur.right = removeMin(node.right);
            cur.left = node.left;
            node.left = node.right = null;
            return node;
        }
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        generateBSTString(root, 0, builder);
        return builder.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder builder){
        if (node == null){
            builder.append(generateDepthString(depth) + "null\n");
            return;
        }

        builder.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, builder);
        generateBSTString(node.right, depth + 1, builder);
    }

    private String generateDepthString(int depth){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        int[] nums = {5,3,2,4,6,8};
////        for (int num : nums) {
////            tree.add(num);
////        }
//////        tree.preOrder();
//////        System.out.println();
//////        tree.preOrderNR();
////        tree.levelOrder();

        int n = 1000;
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            tree.add(random.nextInt(10000));
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (!tree.isEmpty()){
//            arrayList.add(tree.removeMin());
//        }
//        System.out.println(arrayList);
//        for (int i = 1; i < arrayList.size(); i++) {
//            if (arrayList.get(i - 1) > arrayList.get(i))
//                throw new IllegalArgumentException("error");
//        }
//        System.out.println("test removeMin completed.");

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            tree.add(random.nextInt(10000));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!tree.isEmpty()){
            arrayList.add(tree.removeMax());
        }
        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) < arrayList.get(i))
                throw new IllegalArgumentException("error");
        }
        System.out.println("test removeMax completed.");

    }
}
