package Manager;

import java.util.Scanner;
import Common.Employee;
import txtFileManager.txtfilemanager;

public class EmployeeManager {
    private final Employee[] employees;
    private final String ADMIN_PASSWORD = "admin123"; // رمز عبور برای ورود مدیر
    private final Scanner scanner;
    private final txtfilemanager fileManager;

    public EmployeeManager() {
        scanner = new Scanner(System.in);
        fileManager = new txtfilemanager("EMP.txt");

        employees = new Employee[]{
                new Employee("Mr. Amir Rezaei", "Manager", "Full Day"),
                new Employee("Mr. Ali Hosseini", "Receptionist", "8am - 2pm"),
                new Employee("Ms. Sara Ahmadi", "Receptionist", "2pm - 8pm"),
                new Employee("Mr. Nima Karimi", "Receptionist", "8am - 2pm"),
                new Employee("Ms. Fatemeh Rajabi", "Receptionist", "2pm - 8pm"),
                new Employee("Mr. Mohsen Ghaffari", "Guard", "Night"),
                new Employee("Mr. Hamid Nazari", "Guard", "Day"),
                new Employee("Ms. Maryam Ebrahimi", "Cleaner", "8am - 2pm"),
                new Employee("Mr. Hossein Fallahi", "Cleaner", "8am - 2pm"),
                new Employee("Ms. Leila Shariati", "Cleaner", "2pm - 8pm"),
                new Employee("Ms. Simin Mostafavi", "Cleaner", "2pm - 8pm"),
                new Employee("Mr. Hassan Tavakoli", "Cleaner", "Night"),
                new Employee("Ms. Zahra Moradi", "Cleaner", "Night")
        };
    }

    public void showEmployeeList() {
        System.out.print("🔐 Enter manager password to access employee list: ");
        String inputPassword = scanner.nextLine().trim();

        if (inputPassword.equals(ADMIN_PASSWORD)) {
            System.out.println("\n✅ Access Granted. Here's the employee list:\n");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        } else {
            System.out.println("❌ Incorrect password. Access denied.");
        }
    }
}
