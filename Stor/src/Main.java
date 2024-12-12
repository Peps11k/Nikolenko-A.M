import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие: 1 - Добавить отдел, 2 - Удалить отдел, 3 - Редактировать отдел, " +
                    "4 - Добавить товар, 5 - Удалить товар, 6 - Показать товары в отделе, " +
                    "7 - Показать отделы без товаров, 8 - Показать все товары, 0 - Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки

            switch (choice) {
                case 1:
                    System.out.print("Введите название отдела: ");
                    String deptName = scanner.nextLine();
                    System.out.print("Введите часы работы: ");
                    String workingHours = scanner.nextLine();
                    store.addDepartment(deptName, workingHours);
                    break;
                case 2:
                    System.out.print("Введите название отдела для удаления: ");
                    String removeDeptName = scanner.nextLine();
                    store.removeDepartment(removeDeptName);
                    break;
                case 3:
                    System.out.print("Введите название отдела для редактирования: ");
                    String editDeptName = scanner.nextLine();
                    System.out.print("Введите новые часы работы: ");
                    String newWorkingHours = scanner.nextLine();
                    store.editDepartment(editDeptName, newWorkingHours);
                    break;
                case 4:
                    System.out.print("Введите название отдела для добавления товара: ");
                    String addProductDept = scanner.nextLine();
                    System.out.print("Введите название товара: ");
                    String productName = scanner.nextLine();
                    System.out.print("Введите цену товара: ");
                    double price = scanner.nextDouble();
                    store.addProductToDepartment(addProductDept, productName, price);
                    break;
                case 5:
                    System.out.print("Введите название товара для удаления: ");
                    String removeProductName = scanner.nextLine();
                    store.removeProductFromDepartment(removeProductName);
                    break;
                case 6:
                    System.out.print("Введите название отдела для показа товаров: ");
                    String showProductsDept = scanner.nextLine();
                    store.showProductsInDepartment(showProductsDept);
                    break;
                case 7:
                    store.showDepartmentsWithoutProducts();
                    break;
                case 8:
                    store.showAllProducts();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    try {
                        store.connection.close(); // Закрываем соединение с БД
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }
}