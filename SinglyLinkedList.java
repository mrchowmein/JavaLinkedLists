public class SinglyLinkedList<E>{
	

	private class Node {

		private E data;
		private Node next;
		private Node(E data){
			this.data = data;
		}
	}



	//remove from the head
	private Node head; 
	//add to the tail
	private Node tail;

	private int size;


	public boolean isEmpty(){
		return head == null;

	}

	public E peek() {
		return head.data;

	}

	public void addTail(E data){
		Node node = new Node(data);
		if (tail != null){
			tail.next = node;

		}
		tail = node;
		if (head == null) {
			head = node;
		}

		size++;
	}

	public E removeHead(){

		E data = head.data;
		head = head.next;
		if (head == null){
			tail = null;
		}
		size--;
		return data;


	}

	public E removeTail(){

		Node current = head;
		E data = tail.data;

		while(current.next != tail){
			current = current.next;
		}

		tail = current;
		tail.next = null;

		size--;
		return data;


	}

	public void reverse(){

		Node current = head;
		Node previous = null;
		Node next = null;

		while(current != null){
			next = current.next;
			current.next = previous; //assign current next to previous node
			
			//reset positions
			previous = current;
			current = next;
		}

		head = previous;

	}



	public void addHead(E data){

		Node node = new Node(data);
	
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}

		size++;
	}

	public void insertPos(E data, int position){

		Node node = new Node(data);
		Node current = head;
		int pos = 0;

		if(position == 0){
			addHead(data);
		} else if(position == size-1){
			addTail(data);
		} else {

			while(current != null){
				if(pos+1 == position){
					node.next = current.next;
					current.next = node;
				}
				pos++;
				current = current.next;

			}
		}
		size++;

	}

	public E removePos(int position){

		
		Node current = head;
		int pos = 0;
		E data = null;

		if(position == 0){
			data = removeHead();
		} else if(position == size-1){
			data = removeTail();
		} else {

			while(current != null){
				if(pos+1 == position){
					data = current.next.data;
					current.next = current.next.next;
				}
				pos++;
				current = current.next;

			}
		}

		size--;

		return data;

	}


	public void traverse(){

		Node current = head;

		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();

	}
}