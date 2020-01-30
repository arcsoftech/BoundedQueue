/*
 * BoundedQueueueInterface Interface which represents the bounded sized queue.
 *
 *  @author Arihant Chhajed, Cuong Ngo
 *  Ver 1.0: 2020/01/29
*/

package arc180006;


public interface BoundedQueueInterface<T>{
    
    public boolean offer(T x);
    public T poll();
    public T peek();
    public int size();
    public boolean isEmpty();
    public void clear();
    public void toArray(T[] a);
}