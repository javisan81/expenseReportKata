package org.example;

import java.util.Date;
import java.util.List;


public class ExpenseReport {

    private final Date currentDate;

    public enum ExpenseType {
        DINNER, BREAKFAST, CAR_RENTAL
    }

    public static class Expense {
        ExpenseType type;
        int amount;

        public Expense(ExpenseType type, int amount) {
            this.type = type;
            this.amount = amount;
        }
    }

    public ExpenseReport() {
        this.currentDate = new Date();
    }

    public ExpenseReport(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void printReport(List<Expense> expenses) {
        System.out.println("Expenses " + currentDate);

        for (Expense expense : expenses) {
            String expenseName = "";
            switch (expense.type) {
                case DINNER:
                    expenseName = "Dinner";
                    break;
                case BREAKFAST:
                    expenseName = "Breakfast";
                    break;
                case CAR_RENTAL:
                    expenseName = "Car Rental";
                    break;
            }

            String mealOverExpensesMarker = expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000 ? "X" : " ";

            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);
        }

        Expenses expenses1 = new Expenses(expenses);
        System.out.println("Meal expenses: " + expenses1.calculateMealExpenses());
        System.out.println("Total expenses: " + expenses1.total());
    }

}
