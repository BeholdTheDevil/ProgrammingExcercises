package Datastructures.CustomBinaryTree;

import java.lang.reflect.ParameterizedType;

/**
 * Created by anton on 2017-03-23.
 */
public class Tree<E extends Comparable<? super E>> {

    Node root;
    Class<E> type;

    Tree(Class<E> type_) {
        type = type_;
        if(!(type.getClass().equals(Float.class) || type.getClass().equals(Double.class) || type.getClass().equals(String.class) || type.getClass().equals(Integer.class))) {
            throw new IllegalArgumentException("Invalid datatype");
        }
    }

    void add(E n) {
        if(root == null) root = new Node(n, type);
        else {
            root.add(n);
        }
    }

    void list() {
        if(root != null) root.list();
        System.out.println("");
    }

    Node findNode(E n) {
        return root.find(n);
    }

    void removeNode(E n) {
        if(findNode(n) != null) root.remove(n);
    }

    class Node<E extends Comparable<? super E>> {

        Node left;
        Node right;
        E val;
        Class<E> type;

        Node(E val_, Class<E> type_) {
            type = type_;
            val = val_;
        }

        void add(E n) {
            if((type.getClass().equals(Float.class) && (float)n < (float)val)
                    || (type.getClass().equals(Double.class) && (double)n < (double)val)
                    || (type.getClass().equals(Integer.class) && (int)n < (int)val)
                    || (type.getClass().equals(String.class) && Float.parseFloat(n.toString()) < Float.parseFloat(val.toString()))) {

                if(left == null) left = new Node(n, type);
                else left.add(n);
            } else {
                if(right == null) right = new Node(n, type);
                else right.add(n);
            }
        }

        boolean list() {
            if(left == null || (left != null && left.list())) {
                System.out.print(" " + val);
                if(right == null || (right != null && right.list())) {
                    return true;
                }
            }
            return false;
        }

        Node find(E n) {
            if(n == val) return this;
            if((type.getClass().equals(Float.class) && (float)n < (float)val)
                    || (type.getClass().equals(Double.class) && (double)n < (double)val)
                    || (type.getClass().equals(Integer.class) && (int)n < (int)val)
                    || (type.getClass().equals(String.class) && Double.parseDouble(n.toString()) < Double.parseDouble(val.toString()))) {
                if(left != null) return left.find(n);
            } else if((type.getClass().equals(Float.class) && (float)n > (float)val)
                    || (type.getClass().equals(Double.class) && (double)n > (double)val)
                    || (type.getClass().equals(Integer.class) && (int)n > (int)val)
                    || (type.getClass().equals(String.class) && Double.parseDouble(n.toString()) > Double.parseDouble(val.toString()))) {
                if(right != null) return right.find(n);
            }
            System.out.println("Error: Node not found");
            return null;
        }

        void remove(E n) {
            if(left != null && left.val == n) {
                Node current = left.right;
                if(current != null) {
                    while(current.left != null) {
                        current = current.left;
                    }
                    current.left = left.left;
                }
                if(left.right != null) left = left.right;
                else left = left.left;
                return;
            } else if(right != null && right.val == n) {
                Node current = right.right;
                if(current != null) {
                    while (current.left != null) {
                        current = current.left;
                    }
                    current.left = right.left;
                }
                if(right.right != null) right = right.right;
                else right = right.left;
                return;
            }
            if((type.getClass().equals(Float.class) && (float)n < (float)val)
                    || (type.getClass().equals(Double.class) && (double)n < (double)val)
                    || (type.getClass().equals(Integer.class) && (int)n < (int)val)
                    || (type.getClass().equals(String.class) && Double.parseDouble(n.toString()) < Double.parseDouble(val.toString()))) {
                left.remove(n);
            } else if((type.getClass().equals(Float.class) && (float)n > (float)val)
                    || (type.getClass().equals(Double.class) && (double)n > (double)val)
                    || (type.getClass().equals(Integer.class) && (int)n > (int)val)
                    || (type.getClass().equals(String.class) && Double.parseDouble(n.toString()) > Double.parseDouble(val.toString()))) {
                right.remove(n);
            }
        }
    }
}