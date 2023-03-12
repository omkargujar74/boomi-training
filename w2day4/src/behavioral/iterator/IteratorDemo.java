package behavioral.iterator;

public class IteratorDemo {
    public static void main(String[] args) throws Exception {
        CircularQueue<Object> circularQueue = new CircularQueue<>(10);
        circularQueue.push(10);
        circularQueue.push(20);
        circularQueue.push(30);
        circularQueue.push(40);
        circularQueue.push(50);
        circularQueue.push(60);
        circularQueue.push(70);
        circularQueue.push(80);
        circularQueue.push(90);
        circularQueue.push(100);

        Iterator<Object> iterator = circularQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
