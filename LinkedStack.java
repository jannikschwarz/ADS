import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

	private LinkedList linkedList;

	public boolean isEmpty() {
		if(linkedList.size() == 0){
			return true;
		}
		return false;
	}

	public void push(T elm) {
		linkedList.addToFront(elm);
	}

	public T pop() throws EmptyStackException {
		try {
			return (T)linkedList.removeFirst();
		} catch (EmptyListException e) {
			e.printStackTrace();
			throw new EmptyStackException();
		}
	}
}
