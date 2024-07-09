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

    public int length() {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public int sum() {
        Node temp = head;
        int sum = 0;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Linkedlist l1 = new Linkedlist();
        l1.insert(sc);
        int sum1 = l1.sum();

        Linkedlist l2 = new Linkedlist();
        l2.insert(sc);
        int sum2 = l2.sum();

        Linkedlist l3 = new Linkedlist();
        l3.insert(sc);
        int sum3 = l3.sum();

        int maxSum = Math.max(sum3, Math.max(sum1, sum2));
        int minSum = Math.min(sum3, Math.min(sum1, sum2));

        int difference = maxSum - minSum;

        System.out.println("Largest Sum: " + maxSum);
        System.out.println("Smallest Sum: " + minSum);
        System.out.println("Difference: " + difference);
    }
}
