package arc180006;


/**
 * BoundedQueueu interface which represents the bounded sized queue.
 *
 *  @author Arihant Chhajed, Cuong Ngo
 *  Ver 1.0: 2020/01/29
 */
public interface BoundedQueueInterface<T> {
	
	/**
	 * add element x of type T add the rear of the queue
	 * @param x
	 * @return
	 */
	boolean offer(T x);
	
	/**
	 * remove and return the element of type T at the front of the queue
	 * @return
	 */
	T poll();
	
	/**
	 * 
	 * @return the front element of type T at the front of the queue
	 */
	T peek();
	
	/**
	 *
	 * @return the number of elements of the queue
	 */
	int size();
	
	/**
	 * check if the queue is empty
	 * @return true if the queue is empty otherwise false
	 */
	boolean isEmpty();
	
	/**
	 * clear the queue and set size to 0
	 */
	void clear();
	
	/**
	 * fill user supplied array with the elements of the queue,
	 * in queue order
	 * @param a - array of type T supplied by user
	 */
	void toArray(T[] a);
}