import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n📒 Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Filter by Category");
            System.out.println("4. Filter by Month");
            System.out.println("5. Show Total Spent");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category (Food, Transport, etc): ");
                    String category = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    manager.addExpense(amount, category, date, description);
                    break;

                case 2:
                    manager.viewAllExpenses();
                    break;

                case 3:
                    System.out.print("Enter category to filter: ");
                    String filterCat = sc.nextLine();
                    manager.filterByCategory(filterCat);
                    break;

                case 4:
                    System.out.print("Enter month number (1-12): ");
                    int month = sc.nextInt();
                    manager.filterByMonth(month);
                    break;

                case 5:
                    manager.getTotalSpent();
                    break;

                case 6:
                    System.out.println("Exiting... Bye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}