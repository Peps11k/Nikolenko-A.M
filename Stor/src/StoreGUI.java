import javax.swing.*;
import java.awt.*;


public class StoreGUI {
    private Store store;
    private JFrame frame;

    public StoreGUI() {
        store = new Store();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Управление магазином");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(0, 1));

        // Добавление отдела
        JPanel addDepartmentPanel = new JPanel();
        JTextField departmentNameField = new JTextField(10);
        JTextField departmentHoursField = new JTextField(10);
        JButton addDepartmentButton = new JButton("Добавить отдел");
        addDepartmentButton.addActionListener(e -> {
            String name = departmentNameField.getText();
            String hours = departmentHoursField.getText();
            store.addDepartment(name, hours);
            JOptionPane.showMessageDialog(frame, "Отдел добавлен.");
        });
        addDepartmentPanel.add(new JLabel("Название отдела:"));
        addDepartmentPanel.add(departmentNameField);
        addDepartmentPanel.add(new JLabel("Часы работы:"));
        addDepartmentPanel.add(departmentHoursField);
        addDepartmentPanel.add(addDepartmentButton);
        frame.add(addDepartmentPanel);

        // Удаление отдела
        JPanel removeDepartmentPanel = new JPanel();
        JTextField removeDepartmentField = new JTextField(10);
        JButton removeDepartmentButton = new JButton("Удалить отдел");
        removeDepartmentButton.addActionListener(e -> {
            String name = removeDepartmentField.getText();
            store.removeDepartment(name);
            JOptionPane.showMessageDialog(frame, "Отдел удален.");
        });
        removeDepartmentPanel.add(new JLabel("Название отдела для удаления:"));
        removeDepartmentPanel.add(removeDepartmentField);
        removeDepartmentPanel.add(removeDepartmentButton);
        frame.add(removeDepartmentPanel);

        // Редактирование отдела
        JPanel editDepartmentPanel = new JPanel();
        JTextField editDepartmentField = new JTextField(10);
        JTextField newHoursField = new JTextField(10);
        JButton editDepartmentButton = new JButton("Редактировать отдел");
        editDepartmentButton.addActionListener(e -> {
            String oldName = editDepartmentField.getText();
            String newHours = newHoursField.getText();
            store.editDepartment(oldName, newHours);
            JOptionPane.showMessageDialog(frame, "Отдел отредактирован.");
        });
        editDepartmentPanel.add(new JLabel("Название отдела для редактирования:"));
        editDepartmentPanel.add(editDepartmentField);
        editDepartmentPanel.add(new JLabel("Новые часы работы:"));
        editDepartmentPanel.add(newHoursField);
        editDepartmentPanel.add(editDepartmentButton);
        frame.add(editDepartmentPanel);

        // Добавление товара
        JPanel addProductPanel = new JPanel();
        JTextField productDepartmentField = new JTextField(10);
        JTextField productNameField = new JTextField(10);
        JTextField productPriceField = new JTextField(10);
        JButton addProductButton = new JButton("Добавить товар");
        addProductButton.addActionListener(e -> {
            String departmentName = productDepartmentField.getText();
            String productName = productNameField.getText();
            double price = Double.parseDouble(productPriceField.getText());
            store.addProductToDepartment(departmentName, productName, price);
            JOptionPane.showMessageDialog(frame, "Товар добавлен.");
        });
        addProductPanel.add(new JLabel("Название отдела:"));
        addProductPanel.add(productDepartmentField);
        addProductPanel.add(new JLabel("Название товара:"));
        addProductPanel.add(productNameField);
        addProductPanel.add(new JLabel("Цена товара:"));
        addProductPanel.add(productPriceField);
        addProductPanel.add(addProductButton);
        frame.add(addProductPanel);

        // Удаление товара
        JPanel removeProductPanel = new JPanel();
        JTextField removeProductField = new JTextField(10);
        JButton removeProductButton = new JButton("Удалить товар");
        removeProductButton.addActionListener(e -> {
            String name = removeProductField.getText();
            store.removeProductFromDepartment(name);
            JOptionPane.showMessageDialog(frame, "Товар удален.");
        });
        removeProductPanel.add(new JLabel("Название товара для удаления:"));
        removeProductPanel.add(removeProductField);
        removeProductPanel.add(removeProductButton);
        frame.add(removeProductPanel);

        // Редактирование товара
        JPanel editProductPanel = new JPanel();
        JTextField oldProductNameField = new JTextField(10);
        JTextField newProductNameField = new JTextField(10);
        JTextField newProductPriceField = new JTextField(10);
        JButton editProductButton = new JButton("Редактировать товар");
        editProductButton.addActionListener(e -> {
            String oldName = oldProductNameField.getText();
            String newName = newProductNameField.getText();
            double newPrice = Double.parseDouble(newProductPriceField.getText());
            store.editProductInDepartment(oldName, newName, newPrice);
            JOptionPane.showMessageDialog(frame, "Товар отредактирован.");
        });
        editProductPanel.add(new JLabel("Старое название товара:"));
        editProductPanel.add(oldProductNameField);
        editProductPanel.add(new JLabel("Новое название товара:"));
        editProductPanel.add(newProductNameField);
        editProductPanel.add(new JLabel("Новая цена товара:"));
        editProductPanel.add(newProductPriceField);
        editProductPanel.add(editProductButton);
        frame.add(editProductPanel);

        // Показ товаров в отделе
        JPanel showProductsPanel = new JPanel();
        JTextField showDepartmentField = new JTextField(10);
        JButton showProductsButton = new JButton("Показать товары в отделе");
        JTextArea productsArea = new JTextArea(5, 30);
        showProductsButton.addActionListener(e -> {
            String departmentName = showDepartmentField.getText();
            String products = store.showProductsInDepartment(departmentName);
            productsArea.setText(products);
        });
        showProductsPanel.add(new JLabel("Название отдела:"));
        showProductsPanel.add(showDepartmentField);
        showProductsPanel.add(showProductsButton);
        frame.add(showProductsPanel);
        frame.add(new JScrollPane(productsArea));

        // Показ отделов без товаров
        JPanel showDepartmentsWithoutProductsPanel = new JPanel();
        JButton showDepartmentsButton = new JButton("Показать отделы без товаров");
        JTextArea departmentsArea = new JTextArea(5, 30);
        showDepartmentsButton.addActionListener(e -> {
            String departments = store.showDepartmentsWithoutProducts();
            departmentsArea.setText(departments);
        });
        showDepartmentsWithoutProductsPanel.add(showDepartmentsButton);
        frame.add(showDepartmentsWithoutProductsPanel);
        frame.add(new JScrollPane(departmentsArea));

        // Показ всех товаров
        JPanel showAllProductsPanel = new JPanel();
        JButton showAllProductsButton = new JButton("Показать все товары");
        JTextArea allProductsArea = new JTextArea(5, 30);
        showAllProductsButton.addActionListener(e -> {
            String allProducts = store.showAllProducts();
            allProductsArea.setText(allProducts);
        });
        showAllProductsPanel.add(showAllProductsButton);
        frame.add(showAllProductsPanel);
        frame.add(new JScrollPane(allProductsArea));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StoreGUI::new);
    }
}