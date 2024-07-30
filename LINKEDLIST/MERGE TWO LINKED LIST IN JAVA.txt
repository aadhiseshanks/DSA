import java.util.Scanner;

class Linkedlist {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insert(Scanner sc) {
        while (true) {
            int data = sc.nextInt();
            if (data == -1) break;
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
    }

    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void display(Node head1, Node head2, int max) { 
        Node temp1 = head1;
        Node temp2 = head2;
        while (max > 0) {
            if (temp1 != null) {
                System.out.print(temp1.data + "->");
                temp1 = temp1.next;
            } else {
                System.out.print("_->");
            }

            if (temp2 != null) {
                System.out.print(temp2.data + "->");
                temp2 = temp2.next;
            } else {
                System.out.print("_ ");
            }
            max--;
        }
        System.out.print("END");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Linkedlist l1 = new Linkedlist();
        l1.insert(sc);

        Linkedlist l2 = new Linkedlist();
        l2.insert(sc);

        int size1 = l1.size();
        int size2 = l2.size();

        int result = Math.max(size1, size2);

        Linkedlist.display(l1.head, l2.head, result);
    }
}
