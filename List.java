public interface List<T> {

	private EmptyStackException emptyStackException;

	private EmptyListException emptyListException;

	public abstract boolean isEmpty();

	public abstract int size();

	public abstract void addToFront(T data);

	public abstract T removeFirst();

}
