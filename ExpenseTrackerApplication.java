import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private int expenseId;
    private String expenseName;
    private String category;
    private double amount;

    public Expense(int expenseId, String expenseName, String category, double amount) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void displayExpense() {
        System.out.println("ID: " + expenseId +
                " | Name: " + expenseName +
                " | Category: " + category +
                " | Amount: ₹" + amount);
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addExpense() {
        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Expense Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        expenses.add(new Expense(id, name, category, amount));
        System.out.println("Expense Added Successfully!");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No Expenses Found!");
            return;
        }

        System.out.println("\n----- Expense List -----");
        for (Expense e : expenses) {
            e.displayExpense();
        }
    }

    public static void editExpense() {
        System.out.print("Enter Expense ID to Edit: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Expense e : expenses) {
            if (e.getExpenseId() == id) {

                System.out.print("Enter New Expense Name: ");
                e.setExpenseName(sc.nextLine());

                System.out.print("Enter New Category: ");
                e.setCategory(sc.nextLine());

                System.out.print("Enter New Amount: ");
                e.setAmount(sc.nextDouble());

                System.out.println("Expense Updated Successfully!");
                return;
            }
        }

        System.out.println("Expense Not Found!");
    }

    public static void deleteExpense() {
        System.out.print("Enter Expense ID to Delete: ");
        int id = sc.nextInt();

        for (Expense e : expenses) {
            if (e.getExpenseId() == id) {
                expenses.remove(e);
                System.out.println("Expense Deleted Successfully!");
                return;
            }
        }

        System.out.println("Expense Not Found!");
    }

    public static void calculateTotalExpense() {
        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        System.out.println("Total Expenses = ₹" + total);
    }

    public static void categorySummary() {
        double food = 0, travel = 0, shopping = 0,
               entertainment = 0, education = 0, misc = 0;

        for (Expense e : expenses) {
            String cat = e.getCategory().toLowerCase();

            switch (cat) {
                case "food":
                    food += e.getAmount();
                    break;
                case "travel":
                    travel += e.getAmount();
                    break;
                case "shopping":
                    shopping += e.getAmount();
                    break;
                case "entertainment":
                    entertainment += e.getAmount();
                    break;
                case "education":
                    education += e.getAmount();
                    break;
                default:
                    misc += e.getAmount();
            }
        }

        System.out.println("\n----- Category Wise Summary -----");
        System.out.println("Food: ₹" + food);
        System.out.println("Travel: ₹" + travel);
        System.out.println("Shopping: ₹" + shopping);
        System.out.println("Entertainment: ₹" + entertainment);
        System.out.println("Education: ₹" + education);
        System.out.println("Miscellaneous: ₹" + misc);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Total Expenses");
            System.out.println("6. Category Wise Summary");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    editExpense();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    calculateTotalExpense();
                    break;

                case 6:
                    categorySummary();
                    break;

                case 7:
                    System.out.println("Thank You for Using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }
}
