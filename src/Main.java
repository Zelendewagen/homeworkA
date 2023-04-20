import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree node = new Tree();
        Scanner scan = new Scanner(System.in);

        char ch;
        do {
            System.out.println("Введите число");
            int num = scan.nextInt();
            node.root = node.insert(node.root, num);
            node.inorder(node.root);
            System.out.println("\nПродолжить?(Y, N)");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}


class Tree {

    Node root = null;

    Node rotateLeft(Node myNode) {
        System.out.print("left\n");
        Node child = myNode.right;
        Node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    Node rotateRight(Node myNode) {
        System.out.print("right\n");
        Node child = myNode.left;
        Node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    boolean isRed(Node myNode) {
        if (myNode == null) {
            return false;
        }
        return (myNode.color == true);
    }

    void swapColors(Node node1, Node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    Node insert(Node myNode, int data) {
        if (myNode == null) {
            return new Node(data);
        }
        if (data < myNode.value) {
            myNode.left = insert(myNode.left, data);
        } else if (data > myNode.value) {
            myNode.right = insert(myNode.right, data);
        } else {
            return myNode;
        }
        if (isRed(myNode.right) && !isRed(myNode.left)) {
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }
        if (isRed(myNode.left) && isRed(myNode.left.left)) {
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }
        if (isRed(myNode.left) && isRed(myNode.right)) {
            myNode.color = !myNode.color;
            myNode.left.color = false;
            myNode.right.color = false;
        }
        return myNode;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            char c = '●';
            if (node.color == false)
                c = '◯';
            System.out.print(node.value + "" + c + " ");
            inorder(node.right);
        }
    }

}

class Node {
    Node left, right;
    int value;
    boolean color; // красный

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
        color = true;
    }
}

