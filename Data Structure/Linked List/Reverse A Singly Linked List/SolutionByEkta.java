/*
   program to reverse the given Linked List Iteratively
*/
import java.util.Scanner;

public class reverseLLIteratively {

	//function to take linked list as input
	public static node<Integer> takeInput(){
		node<Integer> head=null, tail=null;
		System.out.println("enter the values of each node");
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		while(data != -1) {
			node<Integer> newNode = new node<>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}else {
				tail.next = newNode;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		s.close();
		return head;
	}
	
	public static void print(node<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	//function to reverse the linked list
	public static node<Integer> reverse(node<Integer> head){
		node<Integer> curr = head.next;
		node<Integer> prev = head;
		head.next = null;
		node<Integer> temp;
		
		while(curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		node<Integer> head = takeInput();
		head = reverse(head);
		print(head);
	}

}

//node class
class node<T> {
	T data;
	node<T> next;
	
	node(T data){
		this.data = data;
		next = null;
	}
}

