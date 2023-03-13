package behavioral.iterator;

public class CircularQueue<E> {
    private int[] queue;
    private int first = 0;
    private int last = -1;
    private int count = 0;
    private int size;

    CircularQueue(int s) {
        queue = new int[s];
        size = s;
    }

    public boolean isFull() {
        return (count == size);
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void push(int push) throws Exception {
        if (!isFull()) {
            last = (last + 1) % size;
            queue[last] = push;
            count++;
        } else throw new Exception("Queue is Full");
    }

    public void pop() throws Exception {
        if (!isEmpty()) {
            int pop;
            pop = queue[first];
            queue[first] = 0;
            count--;
            first = (first + 1) % size;
            System.out.println(pop + " Poped");
            System.out.println();

        } else throw new Exception("Queue is Empty");
    }

    public Iterator<E> iterator() {
        return new itr();
    }

    private class itr implements Iterator {
        private int cursor = -1;

        @Override
        public boolean hasNext() {
            return cursor != last;
        }

        @Override
        public Object next() {
            int next = queue[cursor + 1];
            cursor++;
            return next;
        }
    }
}
