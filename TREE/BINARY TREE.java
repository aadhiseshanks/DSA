import java.util.Scanner;
class Tree {
	int arr[];
	int capacity;
	Tree(int size) {
		arr=new int[size];
		capacity=0;
	}
	void addNode(int data) {
		if(capacity==arr.length) {
			System.out.println("Binary tree is full");
		}
		arr[capacity]=data;
		capacity++;
	}

	int parent(int index) {
	    if(index == 0) { // Root Node has No Child
	        return - 1;
	    }
		return (index-1)/2;
	}

	int leftChild(int index) {
		int left = 2 * index + 1;
		return (left < capacity) ? left : -1;
	}

	int rightChild(int index) {
		int right =  2 * index + 2;
		return (right < capacity) ? right : -1;
	}
	
	boolean search(int element) {
	    for(int i=0; i<capacity; i++) {
	        if(arr[i] == element) {
	            return true;
	        }
	    }
	    return false;
	}

    void display(){
        for(int i=0;i<capacity;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Tree:");
        int size=sc.nextInt();
        Tree t=new Tree(size);
        System.out.println("Enter the elements to the Tree:");
        for(int i=0;i<size;i++){
            int data = sc.nextInt();
            t.addNode(data);
        }
        System.out.println("Binary Tree: ");
        t.display();
        
        int rootIndex = 0;
        int leftIndex = t.leftChild(rootIndex);
        int rightIndex = t.rightChild(rootIndex);
        int parentIndex = t.parent(1);
        
        System.out.println("Parent Node at Index: "+(parentIndex != -1 ? t.arr[parentIndex]:"None"));
        System.out.println("Left Child of Root: "+(leftIndex != -1 ? t.arr[leftIndex]:"None"));
        System.out.println("Right Child of Root: "+(rightIndex != -1?t.arr[rightIndex]:"None"));
        
        System.out.println("Enter the Element to Search: ");
        int element = sc.nextInt();
        if(t.search(element)) {
            System.out.println("Element "+element+" present in the tree");
        }
        else {
            System.out.println("Element "+element+" not present in the tree");
        }
    }
}
