package threads;

class MultiplicandThread extends Thread {
    @Override
    public void run() {
        System.out.println("First line and Concluding Line\t\tThread 1");
    }
}

class MultiplicationThread extends Thread {
    private final int multiplier;

    public MultiplicationThread(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = 1; i <= 10; i++) {
            int result = i * multiplier;
            System.out.printf("%d\t\t*\t\t%d\t\t=\t\t%d\n", i, multiplier, result);
            total += result;
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nTotal of Multiplicand\t*\t" + multiplier + "\t=\tGrand Total: " + total);
    }
}

class OperatorThread extends Thread {
    @Override
    public void run() {
        System.out.println("Operator, Multiplier, = and Answer column\tThread 3");
    }
}

public class MultiplicationTableThreads {
    public static void main(String[] args) throws InterruptedException {
        MultiplicandThread t1 = new MultiplicandThread();
        OperatorThread t3 = new OperatorThread();
        MultiplicationThread t2 = new MultiplicationThread(2);

        t1.start();
        t1.join();

        t3.start();
        t3.join();

        t2.start();
        t2.join();

        System.out.println("All threads have finished execution.");
    }
}