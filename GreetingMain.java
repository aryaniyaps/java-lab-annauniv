interface Greeting {
    void sayHello(String name);
}
public class GreetingMain {
    public static void main(String[] args) {
        // anonymous class
        Greeting g1 = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name + " from anonymous class!");
            }
        };

        // lambda expression (functional interface)
        Greeting g2 = (name) -> System.out.println("Hi " + name + ", from lambda!");

        g1.sayHello("Bob");
        g2.sayHello("Charlie");
    }
}
