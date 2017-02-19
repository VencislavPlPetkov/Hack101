public interface MyQueueInterface<T extends Comparable<T>> {

	public void enqueue(T element);

	public T dequeue();

	public T peek();

	public int getSize();
}
