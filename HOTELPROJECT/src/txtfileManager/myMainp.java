package txtFileManager;

import Manager.*;
import java.util.Scanner;

public class myMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomRateManager roomManager = new RoomRateManager();
        ConnectionInfoManager connectionInfoManager = new ConnectionInfoManager();
        EmployeeManager employeeManager = new EmployeeManager();
        EntertainmentManager entertainmentManager = new EntertainmentManager();
        FoodManager foodManager = new FoodManager();

        System.out.println("👋 Welcome to Hotel Services");
        System.out.println("1. Reserve a Room");
        System.out.println("2. Register Your Connection Info");
        System.out.println("3. View Employee List");
        System.out.println("4. Use Entertainment Services");
        System.out.println("5. Use Food Services");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            roomManager.startRoomBooking();
        } else if (choice == 2) {
            connectionInfoManager.collectConnectionInfo();
        } else if (choice == 3) {
            employeeManager.showEmployeeList();
        } else if (choice == 4) {
            entertainmentManager.startEntertainmentService();
        } else if (choice == 5) {
            foodManager.startFoodService();
        } else {
            System.out.println("❌ Invalid choice");
        }

        scanner.close();
    }
}
