package arc180006;

/**
 * Bounded Queue class using array
 * @author cuong
 * @param <T>
 *
 * @param <T>
 */
public class BoundedQueue<T> implements BoundedQueueInterface<T>{
	T[] queue;
	Integer size;

	public BoundedQueue(Integer arraySize) {
		if (arraySize <= 0) throw new IllegalArgumentException();
		queue = (T[]) new Object[arraySize];
		size = 0;
	}
	
	@Override
	public boolean offer(T x) {
		if (size == queue.length) {
			return false;
		}else {
			queue[size] = x;
			size++;
			return true;
		}
	}

	@Override
	public T poll() {
		if (size == 0) return null;
		T front = queue[size-1];
		for (int i = 1; i < size; i++) {
			queue[i-1] = queue[i];
		}
		size--;
		return front;
	}

	@Override
	public T peek() {
		return size == 0 ? null : queue[size-1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public void toArray(T[] a) {
		if (a.length < queue.length) throw new IllegalArgumentException();
		for (int i = 0; i < queue.length; i++) {
			a[i] = queue[i];
		}
	}
	

	
	
}