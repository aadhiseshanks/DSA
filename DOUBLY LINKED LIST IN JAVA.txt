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

      if(head == null) {
          head = newNode;
      }
      else {
        Node temp = head;
        while(temp.next!=null) {
          temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
      }
    } 

    static void insertatbeg(int d) {
      Node newNode = new Node();
      newNode.data = d;
      newNode.next = null;
      newNode.prev = null;

      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }

    static void insertatmid(int d, int x) {
      Node newNode = new Node();
      newNode.data = d;
      newNode.next = null;
      newNode.prev = null;

      if(head==null) {
        System.out.println("Doubly Linked List is Empty!");
      }
      else {
        Node temp = head;
        int i = 1;
        while(temp!=null && i<x-1) {
          temp = temp.next;
          i++;
        }
        if(x==1) insertatbeg(d);
        else if(temp != null) {
          newNode.next = temp.next;
          newNode.prev = temp;

          if(temp != null) {
            temp.next.prev = newNode;
          }
          temp.next = newNode;
        }
      } 
    }
    static void deleteatbeg() {
      if(head!=null) {
        if(head.next!=null) {
          head.next.prev = null;
        }
        head = head.next;
      }
    }

    static void display() {
      Node temp = head;
      while(temp!=null) {
        System.out.println(temp.prev);
        System.out.println(temp.data);
        System.out.println(temp.next);
        temp = temp.next;
      }
    }

    static void deleteatmid(int x) {
        Node temp = head;
        int i = 1;
        while(temp != null && i < x - 1) {
          temp = temp.next;
          i++;
        }

        if(temp != null && temp.next != null) {
          temp.next = temp.next.next;
          if(temp.next != null) {
            temp.next.prev = temp;
          }
        }
    }

    static void deleteatend() {
        Node temp = head;
        while(temp.next != null) {
          temp = temp.next;
        }

        if(temp.prev != null) {
          temp.prev.next = null;
        }
        else head = null;
    }

    static int search(int d) {
      Node temp = head;
      while(temp.next != null) {
        if(temp.data == d) return 1; 
        temp = temp.next;
      }
      return 0;
    }

    static void len() {
      Node temp = head;
      int length = 0;
      while(temp != null) {
          length++;
          temp = temp.next;
      }
      System.out.println("Length of Node: "+length);
    }
    
    public static void main(String[] args) {
      insertatend(10);
      insertatend(20);
      insertatend(30);
      insertatbeg(40);
      insertatmid(50, 3);
      deleteatbeg();
      deleteatend();
      deleteatmid(2);
      display();
      System.out.println((search(10)==1)?"Node is Present":"Node is not Present");
      len();
    }
}
