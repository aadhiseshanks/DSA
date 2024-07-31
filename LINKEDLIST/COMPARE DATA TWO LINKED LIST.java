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

    public static int Equals(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return 0;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) return 1;
        else return 0;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist l1 = new Linkedlist();
        l1.insert(sc);
        Linkedlist l2 = new Linkedlist();
        l2.insert(sc);
        int result = Linkedlist.Equals(l1.head, l2.head);
        System.out.println(result);
    }
}
