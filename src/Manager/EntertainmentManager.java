package Manager;

import Common.Entertainment;
import txtFileManager.txtfilemanager;

import java.util.Scanner;

public class EntertainmentManager {
    private Scanner scanner;
    private txtfilemanager fileManager;

    private Entertainment[] entertainments = {
            new Entertainment("Water Park", 150000),
            new Entertainment("Cinema", 100000)
    };

    public EntertainmentManager() {
        scanner = new Scanner(System.in);
        fileManager = new txtfilemanager("Entertainment.txt");
    }

    public void startEntertainmentService() {
        System.out.println("Do you want to use our entertainment services? (yes/no)");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("yes")) {
            System.out.println("Please enter your name:");
            String guestName = scanner.nextLine().trim();

            listEntertainments();

            System.out.println("Please enter the names of entertainments you want to attend (separated by commas):");
            String selectedInput = scanner.nextLine().trim();
            String[] selectedEntertainments = selectedInput.split(",");

            double totalPrice = calculateTotalPrice(selectedEntertainments);

            StringBuilder ticketDetails = new StringBuilder();
            ticketDetails.append("Guest Name: ").append(guestName).append("\n");
            ticketDetails.append("Selected Activities: ");
            for (int i = 0; i < selectedEntertainments.length; i++) {
                ticketDetails.append(selectedEntertainments[i].trim());
                if (i != selectedEntertainments.length - 1) {
                    ticketDetails.append(", ");
                }
            }
            ticketDetails.append("\nTotal Cost: ").append(totalPrice).append(" Toman\n");

            fileManager.AppendRow(ticketDetails.toString());

            System.out.println("✅ Your activities have been reserved!");
            System.out.println("Total Cost: " + totalPrice + " Toman");

        } else {
            System.out.println("Alright, have a great day!");
        }
    }

    private double calculateTotalPrice(String[] selected) {
        double total = 0;
        for (int i = 0; i < selected.length; i++) {
            String selectedEntertainment = selected[i].trim();
            for (int j = 0; j < entertainments.length; j++) {
                if (entertainments[j].getName().equalsIgnoreCase(selectedEntertainment)) {
                    total += entertainments[j].getPrice();
                }
            }
        }
        return total;
    }

    private void listEntertainments() {
        System.out.println("🎉 Available Entertainment Activities:");
        for (int i = 0; i < entertainments.length; i++) {
            System.out.println("🎟️ " + entertainments[i].getName() + " - Price: " + entertainments[i].getPrice() + " Toman");
        }
    }
}
