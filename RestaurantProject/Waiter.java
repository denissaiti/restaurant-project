public class Waiter implements Greetable,Orderable{
    private final String name;

    public Waiter(String name) {
        this.name = name;
    }

    public void welcomeGuest() {
        System.out.println("Welcome to the restaurant!");
    }

    public void serveFood() {
        System.out.println("Food is being served.");
    }

    public String getName() {
        return name;
    }

    @Override
    public void placeOrder() {
        System.out.println("Order is placed!");
    }

    @Override
    public void enjoyMeal() {
        System.out.println("Enjoy the meal!");
    }
}