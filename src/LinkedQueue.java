import java.util.LinkedList;

public class LinkedQueue <E> implements Queue<E>{
    private Node<E> head;
    private Node<E> tail;
    LinkedList<E>l= new LinkedList<>();
    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        l.addFirst(e);
    }

    @Override
    public E dequeue() {
        return l.removeLast();
    }

    @Override
    public E first() {
        return l.getLast();
    }


//    >>>>>>>>>>>>>>>>>>>>>>>***<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q3.  Implement a method with signature concatenate(LinkedQueue Q2)
//    for the LinkedQueue class that takes all elements of Q2 and appends
//    them to the end of the original queue. The operation should run
//    in O(1) time and should result in Q2 being an empty queue

    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2.isEmpty()) {
            return; // لا يوجد شيء لإضافته إذا كان Q2 فارغًا
        }

        if(this.isEmpty()) {
            // إذا كان الصف الأصلي فارغًا، نستخدم رؤوس Q2 مباشرة
            this.head = Q2.head;
            this.tail = Q2.tail;
        } else {
            // إذا لم يكن الصف الأصلي فارغًا، نلصق Q2 في نهايته
            this.tail.next = Q2.head;
            this.tail = Q2.tail;
        }

        // نجعل Q2 فارغًا
        Q2.head = null;
        Q2.tail = null;
    }
    private  static  class Node<E>{
        E element;
        Node<E>next;

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node(E element, Node<E> next){
            this.element=element;
            this.next=next;

        }

    }
}
