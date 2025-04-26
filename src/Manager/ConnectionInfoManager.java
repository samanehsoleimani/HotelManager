package Manager;

import Common.Connection;
import txtFileManager.txtfilemanager;
import java.util.Scanner;

public class ConnectionInfoManager {
    private Scanner scanner;
    private txtfilemanager fileManager;

    public ConnectionInfoManager() {
        scanner = new Scanner(System.in);
        fileManager = new txtfilemanager("LIST.txt");
    }

    public void collectConnectionInfo() {
        System.out.println("\n==============================");
        System.out.println("  Welcome to Connection Registration");
        System.out.println("==============================\n");

        System.out.print("→ Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("→ Enter your room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("→ Enter your email: ");
        String email = scanner.nextLine().trim();

        System.out.print("→ Enter your mobile number: ");
        String mobile = scanner.nextLine().trim();

        Connection connection = new Connection(name, roomNumber, email, mobile);

        StringBuilder info = new StringBuilder();
        info.append("\n=== Connection Info ===\n");
        info.append(connection.toString()).append("\n");

        fileManager.AppendRow(info.toString());

        System.out.println("\n✅ Information registered successfully!\n");
    }
}
