abstract class Task {
    abstract void execute();

    public void start() {
        System.out.print("Starting task...");
        execute();
    }
} 

public class TaskMain {
    public static void main(String[] args) {
        Task customTask = new Task() {
            @Override
            void execute() {
                System.out.println("Executing custom task via anonymous inner class!");
            }
        };

        customTask.start();
    }
}
