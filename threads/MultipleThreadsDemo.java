package threads;

class CustomThread extends Thread {
    public CustomThread(String name, ThreadGroup group) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName() + ", Thread Group: " + getThreadGroup().getName());
    }
}

public class MultipleThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("CustomGroup");

        CustomThread t1 = new CustomThread("Thread-1", group);
        CustomThread t2 = new CustomThread("Thread-2", group);
        CustomThread t3 = new CustomThread("Thread-3", group);

        t1.start();
        t2.start();
        t3.start();

        // Check if threads are alive
        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            Thread.sleep(100); // Wait for threads to finish
        }

        System.out.println("All threads have finished execution.");
    }
}