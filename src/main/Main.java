package main;

import implementation.MyBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.insert(50);
        bst.insert(25);
        bst.insert(75);
        bst.insert(10);
        bst.insert(35);
        bst.insert(45);


        bst.inOrder(bst.getRoot());
        System.out.println();
//        bst.delete(25);
//        bst.inOrder(bst.getRoot());
        System.out.println(bst.heightOfTree(bst.getRoot()));
    }
}
