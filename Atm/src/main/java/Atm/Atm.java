package Atm;

import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Atm {
    private final CashAcceptor cashAcceptor;
    private final CashGiver cashGiver;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать! Принимаем купюры: 50, 1000, 5000 руб.");

        while (true) {
            System.out.println("\n1. Внести купюры");
            System.out.println("2. Снять минимальным количеством купюр");
            System.out.println("3. Получить сдачу");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositCash(scanner);
                    break;
                case 2:
                    withdrawMinBills(scanner);
                    break;
                case 3:
                    withdrawChange(scanner);
                    break;
                case 0:
                    System.out.println("Итоговый баланс: " + cashAcceptor.getTotal() + " руб.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private void depositCash(Scanner scanner) {
        System.out.print("Введите номинал купюры (50, 1000, 5000): ");
        int bill = scanner.nextInt();
        try {
            cashAcceptor.acceptBill(bill);
            System.out.println("Баланс: " + cashAcceptor.getTotal() + " руб.");
        } catch (CashTransactionException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private void withdrawMinBills(Scanner scanner) {
        System.out.print("Введите сумму для снятия: ");
        int amount = scanner.nextInt();
        try {
            cashGiver.dispenseMinBills(amount);
        } catch (CashTransactionException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private void withdrawChange(Scanner scanner) {
        System.out.print("Введите сумму сдачи: ");
        int amount = scanner.nextInt();
        try {
            cashGiver.dispenseChange(amount);
        } catch (CashTransactionException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BillValidator validator = new BillValidator();
        CashAcceptor acceptor = new BillCashReceiver(validator);
        CashGiver dispenser = new BillCashGiver();
        Atm atm = new Atm(acceptor, dispenser);
        atm.run();
    }
}
