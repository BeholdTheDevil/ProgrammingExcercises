package Datastructures.CustomBinaryTree;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by anton on 2017-03-22.
 */
public class BinaryTree {

    static Tree<Integer> tree;

    public static void main(String[] args) {

        tree = new Tree(Integer.class);
        tree.add(25);
        System.out.println("Root = " + tree.root.val);

        Random rand = new Random();

        for(int i = 0; i < 15; i++) {
            int n = rand.nextInt(50);
            System.out.print(" "  + n + ".0");
            tree.add(n);
        }
        System.out.println("");
        System.out.println("         " + tree.root.val);
        System.out.println("    " + tree.root.left.val + "  " + tree.root.right.val);
        System.out.println(tree.root.left.left.val + "  " + tree.root.left.right.val);
        System.out.println("");
        tree.list();
    }
}
