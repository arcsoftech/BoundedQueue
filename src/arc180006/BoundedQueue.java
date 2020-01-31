/**
 * BoundedQueueu Class which represents the bounded sized queue.
 *
 *  @author Arihant Chhajed, Cuong Ngo
 *  Ver 1.0: 2020/01/29
 */

package arc180006;

import java.util.Scanner;




public class BoundedQueue<T> implements BoundedQueueInterface<T> {

    private int front, rear, size;
    private int currentSize;
    private T[] q;

    @SuppressWarnings("unchecked")
    public BoundedQueue(int size) {
        if (size < 0)
            throw new ArrayStoreException("Queue cannot have negative size");
        this.size= size;
        front = currentSize = 0;
        rear = size - 1;
        q = (T[]) new Object[this.size];
    }

    public boolean offer(T x) {
        if (isFull())
            return false;
        rear = (rear + 1) % this.size;
        q[rear] = x;
        currentSize = currentSize + 1;
        return true;

    }

    public T poll() {
        if (isEmpty())
            return (T) null;
        T item = q[front];
        front = (front + 1) % size;
        currentSize -= 1;
        return item;

    }

    public T peek() {
        if (isEmpty())
            return (T) null;
        T item = q[front];
        return item;
    }

    public int size() {

        return currentSize;

    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        front = currentSize = 0;
        rear = size - 1;
        q = (T[]) new Object[size];

    }

    public void toArray(T[] a) {
        if(a.length < currentSize)
            throw new ArrayStoreException("Array size is not suffient to store all the elements in queue");
        System.arraycopy(q, front, a,  
        0, currentSize);
        
    }

    private boolean isFull() {
        return (currentSize == size);
    }

    public void printQueue()
    {
        System.out.print(currentSize + ": ");
        for(int i = front; i <= rear; i++)
        {
            System.out.print(q[i]);
        }
        
    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        // Generate a doubly linked list of 10 nodes.
        int n = 10;
     
        BoundedQueue<Integer> lst = new BoundedQueue<>(n);
        for (int i = 1; i <= n; i++) {
            lst.offer(Integer.valueOf(i));
        }
        
       lst.printQueue();
        // Iterates through the list and perform operations based on user input.
    
        System.out.println("Please choose the following operations to perform on the list.\n1. offer\n2. poll\n3. peek\n4. isEmpty\n5. size\n6. clear\n7. toArray");
        whileloop: while (in.hasNext()) {
            int com = in.nextInt();
            switch (com) {
            case 1: // Move to next element and print it
                System.out.println("Please enter value of the element to be inserted:");
                int val = in.nextInt();
                lst.offer(Integer.valueOf(val));
                lst.printQueue();
                break;
            case 2: // Move to the previous element and print it
                System.out.println("Value of poll item is "+lst.poll());
                System.out.println("Current Item in Queue: ");
                lst.printQueue();
                break;
            case 3: // Remove element and print the updated list.
                System.out.println("Value of peek item is "+lst.peek());
                System.out.println("Current Item in Queue: ");
                lst.printQueue();
                break;
            case 4: // Add element before the element returned by next() i.e after cursor.
                System.out.println("isEmpty output is "+ lst.isEmpty());
                break;
            case 5: // Add element before the element returned by next() i.e after cursor.
                System.out.println("size output is "+ lst.size());
                break;
            case 6: // Add element before the element returned by next() i.e after cursor.
                lst.clear();
                System.out.println("clear output is ");
                System.out.println("Current Item in Queue: ");
                lst.printQueue();
                break;
            case 7: // Add element before the element returned by next() i.e after cursor.
                System.out.println("Please enter the size of the array");
                Integer[] a = new Integer[in.nextInt()];
                System.out.println("toArray output is ");
                lst.toArray(a);
                for(int i = 0; i < n; i++)
                {
                    System.out.println(a[i]);
                }
                break;
            default: // Exit loop
                break whileloop;
            }
        }
    }
}
