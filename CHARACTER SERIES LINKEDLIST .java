import java.util.Scanner;

class Linkedlist {
    Node head = null;

    class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }

    public void insert(char data) {
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

    public void character(int num) {
        Node temp = head;
        if(num == 1) {
            for(int i=1; i<=26; i++) {
                if(i%2==0) System.out.print((char)(temp.data ^ 32));
                else System.out.print(temp.data);
                temp = temp.next;
            }
        }
        else if(num == 2) {
            for(int j=1; j<=26; j++) {
                if(j%2==0) System.out.print(temp.data);
                else System.out.print((char)(temp.data ^ 32));
                temp = temp.next;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist l = new Linkedlist();
        int size = sc.nextInt();
        char ch = 'a';
        for(int i=0; i<=26; i++) {
            l.insert(ch);
            ch++;
        }
        l.character(size);
    }
}
