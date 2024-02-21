public interface Queue <E> {
    int size( );
 /** Tests whether the queue is empty. */
     boolean isEmpty( );
 /** Inserts an element at the rear of the queue. */
         void enqueue(E e);
 /** Returns, but does not remove, the first element of the queue (null if empty). */
         E first( );
 /** Removes and returns the first element of the queue (null if empty). */
         E dequeue( );
}
