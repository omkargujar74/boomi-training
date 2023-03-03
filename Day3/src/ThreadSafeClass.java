import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeClass {
    private StringBuilder letter = new StringBuilder();
    private AtomicInteger numberOfLines = new AtomicInteger(0);

    public synchronized void writeLetter(String line) {
        letter.append(line);
        numberOfLines.incrementAndGet();
    }

    public synchronized int getNumberOfLines() {
        return numberOfLines.get();
    }

    public synchronized StringBuilder getLetter() {
        return letter;
    }
}
