import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Random;
        public class Main {
            public static void main(String[] args) {

                String username1 = "admin";
                String password2 = "1234";

                admin admin = new admin(username1, password2);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Type username: ");
                String username = scanner.nextLine();
                System.out.print("Type password: ");
                String password = scanner.nextLine();


                System.out.println("--------------------");

                if (admin.username.equals(username) && admin.password.equals(password)) {
                    System.out.println("You are Logged-In");
                    System.out.println("--------------------");

                    System.out.print("Enter name for reservation: ");
                    String reservationName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter number of guests: ");
                    int numberOfGuests = scanner.nextInt();
                    scanner.nextLine();
                    LocalDateTime reservationTime = LocalDateTime.now();

                    Random random = new Random();
                    int randomNumber = random.nextInt(20) + 1;
                    System.out.println("--------------------");

                    Reservations reservations = new Reservations(reservationName, phoneNumber, numberOfGuests, reservationTime, randomNumber);
                    System.out.println("Reservation Details:");
                    System.out.println("--------------------");
                    System.out.println("Name: " + reservations.getName());
                    System.out.println("Phone Number: " + reservations.getPhoneNumber());
                    System.out.println("Number of Guests: " + reservations.getNumberOfGuests());
                    System.out.println("Reservation Time: " + reservations.getReservationTime());
                    System.out.println("Table Number: " + reservations.getTable());
                    System.out.println("--------------------");

                    System.out.print("Enter the name of the waiter: ");
                    String waiterName = scanner.nextLine();
                    scanner.nextLine();
                    Waiter waiter = new Waiter(waiterName);
                    waiter.welcomeGuest();
                    System.out.println("Hi, I am " + waiterName + ". I will be your waiter for today!");
                    System.out.println("Do you have a reservation?");
                    boolean a = scanner.nextBoolean();
                    System.out.println("-------------------------");
                    if (a) {
                        meny array = new meny();
                        array.addItem("Sprite", "Drinks", 1.5);
                        array.addItem("Orange Juice", "Drinks", 2.5);
                        array.addItem("Iced Tea", "Drinks", 1.75);
                        array.addItem("Lemonade", "Drinks", 2.25);
                        array.addItem("Water", "Drinks", 0.5);

                        array.addItem("Pizza", "Main Dish", 8.0);
                        array.addItem("Pasta", "Main Dish", 6.5);
                        array.addItem("Steak", "Main Dish", 12.0);
                        array.addItem("Sushi", "Main Dish", 10.0);
                        array.addItem("Chicken Curry", "Main Dish", 7.5);

                        array.addItem("Brownie", "Desserts", 4.5);
                        array.addItem("Cheesecake", "Desserts", 6.5);
                        array.addItem("Cupcake", "Desserts", 2.5);
                        array.addItem("Panna Cotta", "Desserts", 5.0);
                        array.addItem("Fruit Tart", "Desserts", 3.75);
                        System.out.println("What do you want to order?");
                        System.out.println("-------------------------");
                        String[] categories = {"Drinks", "Main Dish", "Desserts"};
                        int numberOfCategories = categories.length;
                        int numberOfCustomers = reservations.getNumberOfGuests();
                        String[][] orders = new String[numberOfCustomers][numberOfCategories];
                        for (int categoryIndex = 0; categoryIndex < numberOfCategories; categoryIndex++) {
                            String category = categories[categoryIndex];
                            array.printItemsByCategory(category);
                            for (int customerIndex = 0; customerIndex < numberOfCustomers; customerIndex++) {
                                System.out.print("Customer " + (customerIndex + 1) + ", please enter the number of the item you want to order: ");
                                int itemNumber = scanner.nextInt();
                                scanner.nextLine();
                                String itemName = getItemName(array, category, itemNumber);
                                if (itemName == null) {
                                    System.out.println("Invalid item number. Please try again.");
                                    customerIndex--;
                                    continue;
                                }
                                waiter.placeOrder();
                                orders[customerIndex][categoryIndex] = itemName;
                            }
                        }
                        System.out.println("Order Information:");
                        double totalforall = 0;
                        for (int customerIndex = 0; customerIndex < numberOfCustomers; customerIndex++) {
                            System.out.println("Customer " + (customerIndex + 1) + ":");
                            double totalPrice = 0;
                            for (int categoryIndex = 0; categoryIndex < numberOfCategories; categoryIndex++) {
                                String item = orders[customerIndex][categoryIndex];
                                double price = array.getPriceByItemName(item);
                                if (price != -1) {
                                    System.out.println("Item: " + item + " - Price: $" + price);
                                    totalPrice += price;
                                }
                            }
                            System.out.println("Total Price: $" + totalPrice);
                            totalforall += totalPrice;
                            System.out.println();
                        }
                        System.out.println("The total price for the orders is : " + totalforall + " EURO");
                        waiter.enjoyMeal();
                    }
                }
            }
            private static String getItemName(meny array, String category, int itemNumber) {
                int count = 0;
                for (int i = 0; i < array.items.size(); i++) {
                    if (array.getCategory(i).equals(category)) {
                        count++;
                        if (count == itemNumber) {
                            return array.getItem(i);
                        }
                    }
                }
                return null;
            }
        }

