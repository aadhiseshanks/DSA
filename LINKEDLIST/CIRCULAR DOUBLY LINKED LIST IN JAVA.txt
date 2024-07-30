class Main {
  static Node head = null;

  static class Node {
    int data;
    Node next;
    Node prev;
  }

  static void insertatend(int d) {
    Node newNode = new Node();
    newNode.data = d;
    newNode.next = null;
    newNode.prev = null;

    if (head == null) {
      newNode.next = newNode;
      newNode.prev = newNode;
      head = newNode;
    } else {
      newNode.next = head;
      newNode.prev = head.prev;
      head.prev.next = newNode;
      head.prev = newNode;
    }
  }

  static void insertatbeg(int d) {
    Node newNode = new Node();
    newNode.data = d;
    newNode.prev = null;
    newNode.next = null;

    if (head == null) {
      newNode.next = newNode;
      newNode.prev = newNode;
      head = newNode;
    } else {
      newNode.next = head;
      newNode.prev = head.prev;
      head.prev.next = newNode;
      head.prev = newNode;
      head = newNode;
    }
  }

  static void insertafter(int d, int x) {
    Node newNode = new Node();
    newNode.data = d;
    newNode.prev = null;
    newNode.next = null;

    if (head == null) {
      System.out.println("List is empty. Cannot insert in the middle.");
      return;
    }

    Node temp = head;
    do {
      if (temp.data == x) {
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        return;
      }
      temp = temp.next;
    } while (temp != head);

    System.out.println("Element " + x + " not found in the list.");
  }

  static void deleteatbeg() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    if (head.next == head) {
      head = null; 
    } else {
      Node last = head.prev;
      head = head.next;
      head.prev = last;
      last.next = head;
    }
  }

  static void deleteatend() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    if (head.next == head) {
      head = null; 
    } else {
      Node last = head.prev;
      last.prev.next = head;
      head.prev = last.prev;
    }
  }

  static void display() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    Node temp = head;
    do {
      System.out.println("Prev: " + temp.prev);
      System.out.println("Data: " + temp.data);
      System.out.println("Next: " + temp.next);
      temp = temp.next;
    } while (temp != head);
  }

  static void len() {
    Node temp = head;
    int length = 0;
    do {
      length++;
      temp = temp.next;
    } while(temp != head);
    System.out.println("Length of Node: "+length);
  }

  static int search(int data) {
    Node temp = head;
    do {
      if(temp.data == data) return 1;
      temp = temp.next;
    } while(temp != head);
    return 0;
  }

  public static void main(String[] args) {
    insertatend(10);
    insertatend(20);
    insertatend(30);
    insertatbeg(40);
    insertafter(50, 20);
    deleteatbeg();
    deleteatend();
    insertatend(60);
    display();
    len();
    System.out.println((search(40)==1)?"Node is Present":"Node is not Present");
  }
}
