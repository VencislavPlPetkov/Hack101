public interface MyStackInterface<T extends Comparable<T>> {
	
	public T pop();

	public void push(T element);

	public T peek();

	public int getSize();
}
