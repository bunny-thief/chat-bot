package ChatBot;

import java.util.HashMap;
import java.util.Scanner;

public class ChatBot {

    private Scanner scanner;
    private HashMap<String, Integer> orders;
    private String userInput;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> orders = new HashMap<String, Integer>();
        orders.put("BF445566", 1);
        orders.put("BF334433", 2);
        orders.put("BF123123", 3);
        orders.put("BF144332", 1); //Alva's code: ;r''.'/???????MGg vl;mbn,/..n;Lnnp./]rc◊  b  ' p-kl-m,,,,,,,l //.'bc0b, bc. /bkmn ,./   l//
        //1 = not dispatched, 2, dispatched, 3 delivered

        ChatBot chatBot = new ChatBot(scanner, orders);
        chatBot.run();
    }

    public ChatBot(Scanner scanner, HashMap<String, Integer> orders) {
        this.scanner = scanner;
        this.orders = orders;
    }

    public void run() {

        int counter = 0;

        while (true) {
            if (counter == 0) {
                System.out.println("How can I help you?");
            } else if (counter == 1) {
                System.out.println("Is there anything else I can help you with?");
            } else if (counter > 1) {
                System.out.println("Do you still need my help?");
                userInput = scanner.nextLine();
                if ("yes".equals(userInput)) {
                    counter = 0;
                    continue;
                } else {
                    counter = 0;
                    continue;
                }
            }
            counter++;

            userInput = scanner.nextLine();

            if (userInput.toLowerCase().contains("track") || userInput.toLowerCase().contains("package")) {
                trackPackage();
                System.out.println();
                continue;
            }

            if (userInput.toLowerCase().contains("return") || userInput.toLowerCase().contains("item")) {
                while (true) {
                    if (returnItem()) {
                        break;
                    } else {
                        continue;
                    }
                }
                continue;
            }

            if (userInput.toLowerCase().contains("customer") || userInput.toLowerCase().contains("service")) {
                contactCustomerService();
                continue;
            }

            if (userInput.toLowerCase().contains("contact") || userInput.toLowerCase().contains("info") || userInput.toLowerCase().contains("time")) {
                contactInfo();
                continue;
            }

            if (userInput.toLowerCase().contains("exit") || userInput.toLowerCase().contains("end") || userInput.toLowerCase().contains("no")) {
                exit();
                break;
            } else {

                System.out.println("I'm not sure I understand your request.");
                System.out.println("Would you like to speak with our customer service team?");

                userInput = scanner.nextLine();
                if (userInput.toLowerCase().equals("yes")) {
                    contactCustomerService();
                } else {
                    continue;
                }
            }
        }
    }

    public void trackPackage() {
        System.out.print("Enter the order number:");
        String order = scanner.nextLine();

        if (orders.containsKey(order)) {
            int orderStatus = orders.get(order);
            if (orderStatus == 1) {
                System.out.println("This order has not been dispatched yet.");
            } else if (orderStatus == 2) {
                System.out.println("This order has been dispatched.");
            } else {
                System.out.println("This order has been delivered.");
            }
        } else {
            System.out.println("The order number you entered is not in our system.");
        }
    }

    public boolean returnItem() {
        System.out.println("I'm sorry to hear there was a problem.");
        System.out.println("Please enter the order number so we can begin the return process.");
        String orderNumber = scanner.nextLine();

        if (orders.containsKey(orderNumber)) {
            System.out.println("A pick-up has been scheduled for this item.");
            return true;
        } else {
            System.out.println("This order is not in our system.");
            System.out.println("Would like you try again?");
            userInput = scanner.nextLine();
            if ("yes".equals(userInput)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void contactCustomerService() {
        System.out.println("You can contact our customer service team directly at:");
        System.out.println("""
                Customer Service
                +44 (0)20 7756 1234
                customerservice@asos.com
                """);
    }

    public void contactInfo() {
        System.out.println("""
                Here is our contact info and opening hours:
                                
                We are available 24/7 at https://www.asos.com
                                
                9:00 - 5:00 BST +44 (0)20 7756 1122
                ASOS HQ
                Barlby Road
                Selby
                YO8 5BL
                UK
                """);
    }

    public void exit() {
        System.out.println("Bye!");
    }

}

