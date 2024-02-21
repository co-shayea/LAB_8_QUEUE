import java.util.Arrays;

public class ArrayQueue <E>implements Queue<E>{
    private  E data[];
    private int sz=0;
    private int f;
    private int rear;
    public ArrayQueue(int cap)
    {
        data= (E[])new Object[cap];
    }
    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return sz==0;
    }

    @Override
    public void enqueue(E e) {
        if (size()== data.length)
            throw new IllegalStateException("Queue is full");
        int x=(f+sz)% data.length;
        data[x]=e;
        sz++;


    }

    @Override
    public E dequeue() {
        if (isEmpty())return null;
        E deleted=data[f];
        data[f]=null;
        f=(f+1)% data.length;
        sz--;
        return deleted;
    }

    @Override
    public E first() {
        if (isEmpty())return null;
        return data[f];
    }
//    >>>>>>>>>>>>>>>>>>>>>>>***<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q1.  Augment the ArrayQueue implementation with a new rotate( ) method having
//    semantics identical to the combination, enqueue(dequeue( )).
//    But, your implementation should be more efficient than making
//    two separate calls (for example, because there is no need to modify the size).

//    وإحداث دوران افتراضي للصف.
    public void rotate() {
    if (!isEmpty()) {
        E temp = data[f]; //فظ العنصر الأمامي: نحفظ العنصر الموجود في المؤشر الأمامي f في متغير مؤقت temp.
// نقوم بتحريك المؤشر الأمامي خطوة واحدة للأمام باستخدام modulo (%) لضمان اللف حول المصفوفة عند الوصول إلى النهاية.
        f = (f + 1) % data.length;
//نقوم بتحريك المؤشر الخلفي خطوة واحدة للأمام بنفس الطريقة، حتى لو كان الصف ممتلئًا حاليًا.
        rear = (rear + 1) % data.length;
        data[rear] = temp;
    }
 }
//    >>>>>>>>>>>>>>>>>>>>>>>***<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    Q2.   Implement the clone( ) method for the ArrayQueue class.
    @Override
    protected ArrayQueue<E> clone() throws CloneNotSupportedException {
        @SuppressWarnings("unchecked")
        ArrayQueue<E> clone = (ArrayQueue<E>) super.clone();
        clone.data = Arrays.copyOf(this.data, this.data.length);
        return clone;
//        return super.clone();
    }
}
