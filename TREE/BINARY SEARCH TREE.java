import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
        height  = 0;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int getHeight(Node root) {
        if(root == null) {
            return -1;
        }
        return root.height;
    }
    public void insert(int data) {
        root = insertRecursion(root, data);
    }

    private Node insertRecursion(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data) 
            root.left = insertRecursion(root.left, data);
        else if(data > root.data) 
            root.right = insertRecursion(root.right, data);

        root.height = 1+max(getHeight(root.left), getHeight(root.right));

        if(root != null) {
            System.out.println(root.data+" "+"Height is "+root.height);
        }

        return root;
    }

    public void preOrderTraversal() {
        preOrderRec(root);
    }
    private void preOrderRec(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }
    private void inOrderRec(Node root) {
        if(root != null) {
            inOrderRec(root.left);
            System.out.print(root.data+" ");
            inOrderRec(root.right);
        }
    }

    public void postOrderTraversal() {
        postOrderRec(root);
    }
    private void postOrderRec(Node root) {
        if(root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data+" ");
        }
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if(root == null) 
            return false;

        if(data == root.data) 
            return true; 

        if(data < root.data) 
            return searchRec(root.left, data);
        else
            return searchRec(root.right, data);
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }
    private Node deleteRec(Node root, int data) {
        if(root == null) {
            return null;
        }

        if(data == root.data) {
            // Node with One or No Child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            root.data = min(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        else if(data < root.data) {
            root.left = deleteRec(root.left, data);  
        }
        else {
            root.right = deleteRec(root.right, data);
        }
        return root;
    }

    private int min(Node root) {
        int min = root.data;
        while(root.left!=null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        System.out.println("Enter the Number of Node: ");
        int size = sc.nextInt();
        System.out.println("Enter the Elements: ");
        for(int i=0; i<size; i++) {
            tree.insert(sc.nextInt());
        }

        System.out.println("PreOrder Traversal: ");
        tree.preOrderTraversal();

        System.out.println();

        System.out.println("InOrder Traversal: ");
        tree.inOrderTraversal();

        System.out.println();

        System.out.println("PostOrder Traversal: ");
        tree.postOrderTraversal();

        System.out.println(); 

        System.out.println("Enter the Search Data: ");
        int search = sc.nextInt();
        System.out.println("Searching for "+search+": "+tree.search(search));

        System.out.println("If You Want to Delete a Node Press 1 Else Press 0");
        int val = sc.nextInt();
        if(val == 1) {
            System.out.println("Enter the No of Times Deleted: ");
            int times = sc.nextInt();
            for(int i=0; i<times; i++) {
                tree.delete(sc.nextInt());
            }
        }

        System.out.println("InOrder Traversal: ");
        tree.inOrderTraversal();
    }
}
