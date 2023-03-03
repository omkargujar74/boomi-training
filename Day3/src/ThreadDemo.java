public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        writeLetter();
    }

    public static void writeLetter() throws InterruptedException {
        ThreadSafeClass threadSafeClass = new ThreadSafeClass();
        Thread thread1 = new Thread(() -> {
            synchronized (threadSafeClass) {
                for (int i = 0; i < 200; i++) {
                    threadSafeClass.writeLetter("Line from thread1\n");
//                    try {
//                        Thread.sleep(5);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    //System.out.println("Number of lines = " + threadSafeClass.getNumberOfLines());
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadSafeClass) {
                    for (int i = 0; i < 300; i++) {
                        threadSafeClass.writeLetter("Line from thread2\n");
//                    try {
//                        Thread.sleep(5);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                        //System.out.println("Number of lines = " + threadSafeClass.getNumberOfLines());
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadSafeClass) {
                    for (int i = 0; i < 100; i++) {
                        threadSafeClass.writeLetter("Line from thread3\n");
//                    try {
//                        Thread.sleep(5);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                        //System.out.println("Number of lines = " + threadSafeClass.getNumberOfLines());
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Number of lines = " + threadSafeClass.getNumberOfLines());
//        System.out.println("Letter = " + threadSafeClass.getLetter());

    }
}
