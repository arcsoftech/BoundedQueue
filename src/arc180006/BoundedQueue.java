/**
 * BoundedQueueu Class which represents the bounded sized queue.
 *
 *  @author Arihant Chhajed, Cuong Ngo
 *  Ver 1.0: 2020/01/29
 */

package arc180006;
// import java.util.Iterator;
// import java.util.Scanner;
// import java.util.NoSuchElementException;

public class BoundedQueue<T> implements BoundedQueueInterface<T> {


    
    private  T[] q;
    
    @SuppressWarnings("unchecked")
    public BoundedQueue(int size){
      
       q =  (T[]) new Object[size];

    }

  
    public boolean offer(T x)
    {

    }
    public T poll()
    {

    }
    public T peek(){

    }
    public int size(){

    return q.length;

    }
    public boolean isEmpty(){

    }
    public void clear(){

    }
    public void toArray(T[] a){

    }

}