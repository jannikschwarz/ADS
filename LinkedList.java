public class LinkedList<T> implements List<T> {

	private Node<T> head;

	private int size;



	public boolean isEmpty() {
		if(size == 0){
			return true;
		}else{
			return false;
		}
	}

	public int size() {
		return size;
	}


	public void addToFront(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	public T removeFirst() throws EmptyListException {
		if(head == null){
			throw new EmptyListException("List is empty");
		}
		Node<T> temp = head;
		head = temp.getNext();
		size--;
		return temp.getData();
	}
}
