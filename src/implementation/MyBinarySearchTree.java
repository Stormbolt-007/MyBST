package implementation;

import node.Node;

public class MyBinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }
    public void insert( int data){
        Node node = new Node(data);
        if(root == null){
            root = node;
        }
        else{
            //compare and move to subtree(either left or right)
            Node temp = root;
            Node parent = null;

            while (temp != null){
                parent = temp;
                if(data <= temp.getData()){
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }
            if(data <= parent.getData()){
                parent.setLeft(node);
            }
            else{
                parent.setRight(node);
            }
        }
    }
    public void inOrder(Node node){
        //process the left sub tree
        //process element
        //process right sub tree
        if(node == null){
            return;
        }
        else{
            inOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            inOrder(node.getRight());
        }
    }
    public boolean search(int element){
        boolean response = false;
        Node temp = root;
        while(temp != null){
            if(temp.getData() == element){
                response = true;
                break;
            }
            else{
                if(element < temp.getData()){
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }
        }
        return response;
    }

    public void delete(int element){
        //case 1: deleting the leaf node;
        Node temp = root;
        Node parent = null;
        while(temp != null && temp.getData() != element){
            parent = temp;
            if(element < temp.getData()){
                temp = temp.getLeft();
            }
            else {
                temp = temp.getRight();
            }
        }
        if(temp != null){
            //leaf node deletion..
            if(isLeaf(temp)){
                if(element < parent.getData()){
                    parent.setLeft(null);
                }
                else{
                    parent.setRight(null);
                }
            }
            //left child........deleting node with single child...
            else if(temp.getLeft() != null && temp.getRight() == null){
                if(temp.getData() <= parent.getData()){
                    parent.setLeft(temp.getLeft());
                }
                else{
                    parent.setRight(temp.getLeft());
                }
            }
            //right child..
            else if(temp.getRight() != null && temp.getLeft() == null){
                if(temp.getData() <= parent.getData()){
                    parent.setLeft(temp.getLeft());
                }
                else{
                    parent.setRight(temp.getLeft());
                }
            }
            //two children case.....
            //we have to find successor of deleting node...
            else{
                Node successor = getSuccessor(temp);
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                if(temp.getData() <= parent.getData()){
                    parent.setLeft(successor);
                }
                else{
                    parent.setRight(successor);
                }
            }
        }
        else{
            System.out.println("cannot delete the element which is not present.");

        }
    }

    private Node getSuccessor(Node temp) {
        Node response = null;
        temp = temp.getRight();
        while(temp != null){
            response = temp;
            temp = temp.getLeft();
        }
        return response;
    }

    private boolean isLeaf(Node temp) {
        if(temp.getLeft() == null){
            if(temp.getRight() == null){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
