package threads;

class AlphabetThread extends Thread {
    private final Object lock;
    private final boolean isForward;

    public AlphabetThread(Object lock, boolean isForward) {
        this.lock = lock;
        this.isForward = isForward;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (isForward) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.print(c + " ");
                    try {
                        Thread.sleep(1000); // 1 second delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify(); // Notify the second thread
            } else {
                try {
                    lock.wait(); // Wait for the first thread to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (char c = 'Z'; c >= 'A'; c--) {
                    System.out.print(c + " ");
                    try {
                        Thread.sleep(2000); // 2 seconds delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class AlphabetThreads {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        AlphabetThread forwardThread = new AlphabetThread(lock, true);
        AlphabetThread reverseThread = new AlphabetThread(lock, false);

        forwardThread.start();
        reverseThread.start();

        forwardThread.join();
        reverseThread.join();

        System.out.println("\nBoth threads have finished execution.");
    }
}