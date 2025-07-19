import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(double amount, String category, String dateStr, String description) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Expense e = new Expense(amount, category, date, description);
        expenses.add(e);
        System.out.println("✅ Expense added.");
    }

    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void filterByCategory(String category) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses in this category.");
        }
    }

    public void filterByMonth(int month) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getDate().getMonthValue() == month) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses in this month.");
        }
    }

    public void getTotalSpent() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.printf("💰 Total spent: ₹%.2f\n", total);
    }
}