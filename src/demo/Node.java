package demo;

public class Node {
	public static void main(String[] args) {
		Node head=new Node(1);
		Node p=new Node(2);
		head.next=p;
		head.travel();
		Node q=new Node(3);
		p.next=q;
		head.travel();
	}

	public void travel() {
		Node p=this;
		while(p!=null){
			System.out.print(p.data);
			p=p.next;
		}
		
	}

	public Node(int data, Node next) {		
		this.data = data;
		this.next = next;
	}
	public Node(int data) {
		this(data, null);
	}
	int data;
	Node  next;
	
}
