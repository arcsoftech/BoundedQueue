package arc180006;

import java.util.Scanner;

/**
 * BoundedQueueu Class which represents the bounded sized queue.
 *
 *  @author Arihant Chhajed, Cuong Ngo
 *  Ver 1.0: 2020/01/29
 */
public class BoundedQueue<T> implements BoundedQueueInterface<T> {

    private int front, rear, size;
    private int currentLength;
    private T[] q;

    @SuppressWarnings("unchecked")
    public BoundedQueue(int size) {
        if (size <= 0)
            throw new ArrayStoreException("Queue cannot have negative or zero size");
        this.size = size;
        front = currentLength = 0;
        rear = size - 1;
        q = (T[]) new Object[this.size];
    }

    /**
	 * add element x of type T add the rear of the queue
	 * @param x
	 * @return
	 */
    public boolean offer(T x) {
        if (isFull())
            return false;
        rear = (rear + 1) % this.size;
        q[rear] = x;
        currentLength = currentLength + 1;
        return true;

    }
    
    /**
	 * remove and return the element of type T at the front of the queue
	 * @return the element which was at front of type T
	 */
    public T poll() {
        if (isEmpty())
            return  null;
        T item = q[front];
        front = (front + 1) % size;
        currentLength -= 1;
        return item;

    }

    /**
	 * 
	 * @return the front element of type T at the front of the queue
	 */
    public T peek() {
        if (isEmpty())
            return  null;
        T item = q[front];
        return item;
    }

    /**
	 *
	 * @return the number of elements of the queue
	 */
    public int size() {

        return currentLength;

    }

    /**
	 * check if the queue is empty
	 * @return true if the queue is empty otherwise false
	 */
    public boolean isEmpty() {
        return (currentLength == 0);
    }

    /**
	 * clear the queue and set size to 0
	 */
    public void clear() {
        front = currentLength = 0;
        rear = size - 1;

    }

    /**
	 * fill user supplied array with the elements of the queue,
	 * in queue order
	 * @param a - array of type T supplied by user
	 */
    public void toArray(T[] a) {
        if (a.length < currentLength)
            throw new ArrayStoreException("Array size is not suffient to store all the elements in queue");
        System.arraycopy(q, front, a, 0, size - front);
        if (rear < front)
            System.arraycopy(q, 0, a, size - front, rear + 1);

    }

    /**
	 * check if the queue is full
	 * @return true if the queue is full otherwise false
	 */
    private boolean isFull() {
        return (currentLength == size);
    }

    /**
	 * Print the element in the queue
	 */
    public void printQueue() {
        System.out.print(currentLength + ": ");
        int counter = currentLength;
        int p = front;
        while (counter != 0) {
            System.out.print(q[p] + " ");
            p = (p + 1) % this.size;
            counter -= 1;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Generate a doubly linked list of 10 nodes.
        int n = 10;

        BoundedQueue<Integer> lst = new BoundedQueue<>(n);
        for (int i = 1; i <= n; i++) {
            lst.offer(Integer.valueOf(i));
        }

        lst.printQueue();
        // Iterates through the list and perform operations based on user input.

        System.out.println(
                "Please choose the following operations to perform on the list.\n1. offer\n2. poll\n3. peek\n4. isEmpty\n5. size\n6. clear\n7. toArray");
        whileloop: while (in.hasNext()) {
            int com = in.nextInt();
            switch (com) {
            case 1: // Add new element to the queue
                System.out.println("Please enter value of the element to be inserted:");
                int val = in.nextInt();
                lst.offer(Integer.valueOf(val));
                lst.printQueue();
                break;
            case 2: // poll the element at the front of the queue
                System.out.println("Value of poll item is " + lst.poll());
                System.out.println("Current Item in Queue: ");
                lst.printQueue();
                break;
            case 3: // peek the element at the front of the queue
                System.out.println("Value of peek item is " + lst.peek());
                System.out.println("Current Item in Queue: ");
                lst.printQueue();
                break;
            case 4: // Check if queue is empty
                System.out.println("isEmpty output is " + lst.isEmpty());
                break;
            case 5: // print the current size of the queue
                System.out.println("size output is " + lst.size());
                break;
            case 6: // clear the queue
                lst.clear();
                System.out.println("clear output is ");
                System.out.println("Current Item in Queue: ");
                lst.printQueue();
                break;
            case 7: // copy the element of queue to user defined array.
                System.out.println("Please enter the size of the array");
                Integer[] a = new Integer[in.nextInt()];
                System.out.println("toArray output is ");
                lst.toArray(a);
                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i]);
                }
                break;
            default: // Exit loop
                break whileloop;
            }
        }
    }
}
