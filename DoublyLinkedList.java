public class DoublyLinkedList<E>{

	private class Node {

		private E data;
		private Node next;
		private Node previous;
		private Node(E data){
			this.data = data;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty(){

		return size == 0;
	}

	public int getSize(){

		return size;
	}
	public void addHead(E data){

		Node node = new Node(data);
		//node.data = data;

		if(head == null){
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.previous = node;
			head = node;
		}

		size++;

	}

	public E removeHead(){

		E oldHeadData = head.data;

		if(head != null){
			head = head.next;
			head.previous = null;
		}
		size--;
		return oldHeadData;

	}


	public void addTail(E data){
		Node node = new Node(data);

		if(tail == null){
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}

		size++;

	}

	public E removeTail(){
		E oldTailData = tail.data;

		if(tail != null){
			tail = tail.previous;
			tail.next = null;
		}
		size--;
		return oldTailData;



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
				if(pos == position){
					current.previous.next = node;
					node.previous = current.previous;
					node.next = current;
					current.previous = node;
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
				if(pos == position){
					data = current.data;
					current.previous.next = current.next;
					current.next.previous = current.previous;
				}
				pos++;
				current = current.next;

			}
		}

		size--;

		return data;

	}


	public E peek(){

		return head.data;
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