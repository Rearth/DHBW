package sem02.de.dhbw.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BinaryTree<T extends Comparable> implements Comparable<T>{

    private T value;
    private BinaryTree<T> left = null;
    private BinaryTree<T> right = null;

    public BinaryTree(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public boolean add(T newValue) {

        if (traverse().contains(newValue)) {
            return false;
        } else {
            if (newValue.compareTo(value) < 0) {
                if (left == null) {
                    left = new BinaryTree<>(newValue);
                } else {
                    left.add(newValue);
                }
            } else {
                if (right == null) {
                    right = new BinaryTree<>(newValue);
                } else {
                    right.add(newValue);
                }
            }

            return true;
        }

    }

    public List<T> traverse() {

        Set<T> list = new TreeSet<T>();
        list.add(this.getValue());
        if (left != null) {
            list.addAll(left.traverse());
        }
        if (right != null) {
            list.addAll(right.traverse());
        }

        return new ArrayList<>(list);

    }


    public static void main(String[] args) {

        BinaryTree<Float> root = new BinaryTree<Float>(0.5f);

        for (int i = 0; i < 10; i++) {
            float f = (float) Math.random();
            System.out.println("generated number: " + f);
            root.add(f);

        }

        System.out.println(root.traverse());
        System.out.println(root.left.getValue());

    }

    @Override
    public int compareTo(T t) {
        return 0;
    }
}
