package com.shivam.treepractice;



public class BStDeletion {
    private Node root;

    // structure
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // insertion
    public void insert(int val) {
        root = insert(val, root);
    }
    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        // BST - Logic
        if (val < node.val) {
            // left
            node.left = insert(val, node.left);
        }
        else {
            // right
            node.right = insert(val, node.right);
        }

        return node; // if no new node been inserted return the Existing Node
    }

    // populate
    public void populate(int[] arr) {
        for (int i : arr) {
            insert(i);
        }
    }


    // deletion
    public void delete(int target) {
        if (root == null) {
            System.out.println("Tree Doesn't Exist");
            return;
        }
        root = delete(target, root);
    }
    private Node delete(int target, Node node) {
        if (node == null) {
            System.out.println("Target not Found");
            return null;
        }

        // if target found
        if (target == node.val) {

            // case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // case 2: Node with 2 child
            else if (node.left != null && node.right != null) {
                Node max = getMax(node.left);

                node.val = max.val; // parent node Value Exchange with max from left

                // delete that duplicate node from Left
                node.left = delete(max.val, node.left);

                return node;
            }

            // case 3: Node have only One child

            // only left child
            else if (node.left != null) {
                return node.left;
            }

            // only right child
            else {
                return node.right;
            }
        }

        // searching
        if (target < node.val) {
            node.left = delete(target, node.left);
        }
        else {
            node.right = delete(target, node.right);
        }

        return node; // if nothing deleted return Existing node or if deleted return the updated node reference
    }
    // getMax
    public Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }


    // display
    public void display() {
        display(root, 0);
    }
    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        // go right
        display(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.val);
        }
        else {
            System.out.println(node.val);
        }

        // left
        display(node.left, level + 1);
    }


    // main - fn
    public static void main(String[] args) {
        BStDeletion bst = new BStDeletion();
        int[] arr = {56, 40, 61, 48, 67, 57, 23, 13, 76, 89};
        bst.populate(arr);
        bst.display();

        System.out.println("\nDelete 61");
        bst.delete(61);
        bst.display();

        System.out.println("\nDelete 56");
        bst.delete(56);
        bst.display();

        System.out.println("\nDelete 23");
        bst.delete(23);
        bst.display();

        System.out.println("\nDelete 89");
        bst.delete(89);
        bst.display();

    }
}
