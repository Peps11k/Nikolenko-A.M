import java.sql.*;

class Store {
    public Connection connection;

    public Store() {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_db", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDepartment(String name, String workingHours) {
        try {
            String sql = "INSERT INTO departments (name, working_hours) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, workingHours);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeDepartment(String name) {
        try {
            String sql = "DELETE FROM departments WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editDepartment(String oldName, String newWorkingHours) {
        try {
            String sql = "UPDATE departments SET working_hours = ? WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newWorkingHours);
            stmt.setString(2, oldName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductToDepartment(String departmentName, String productName, double price) {
        try {
            String sql = "SELECT id FROM departments WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, departmentName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int departmentId = rs.getInt("id");
                sql = "INSERT INTO products (name, price, department_id) VALUES (?, ?, ?)";
                PreparedStatement stmt2 = connection.prepareStatement(sql);
                stmt2.setString(1, productName);
                stmt2.setDouble(2, price);
                stmt2.setInt(3, departmentId);
                stmt2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeProductFromDepartment(String productName) {
        try {
            String sql = "DELETE FROM products WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, productName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editProductInDepartment(String oldProductName, String newProductName, double newPrice) {
        try {
            String sql = "UPDATE products SET name = ?, price = ? WHERE name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newProductName);
            stmt.setDouble(2, newPrice);
            stmt.setString(3, oldProductName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String showProductsInDepartment(String departmentName) {
        StringBuilder result = new StringBuilder();
        try {
            String sql = "SELECT p.name, p.price FROM products p " +
                    "JOIN departments d ON p.department_id = d.id WHERE d.name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, departmentName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                result.append("Товар: ").append(productName).append(", Цена: ").append(price).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public String showDepartmentsWithoutProducts() {
        StringBuilder result = new StringBuilder();
        try {
            String sql = "SELECT d.name FROM departments d LEFT JOIN products p ON d.id = p.department_id " +
                    "GROUP BY d.id HAVING COUNT(p.id) = 0";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.append(rs.getString("name")).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public String showAllProducts() {
        StringBuilder result = new StringBuilder();
        try {
            String sql = "SELECT p.name, p.price, d.name AS department_name FROM products p " +
                    "JOIN departments d ON p.department_id = d.id";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                String departmentName = rs.getString("department_name");
                result.append("Товар: ").append(productName).append(", Цена: ").append(price)
                        .append(", Отдел: ").append(departmentName).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}