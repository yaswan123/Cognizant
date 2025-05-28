import java.sql.*;

public class TransactionExample {

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/your_database";  // Replace with your database URL
    private String username = "your_username"; // Replace with your database username
    private String password = "your_password"; // Replace with your database password

    public TransactionExample() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void createAccountsTable() throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS accounts (\n" +
                "    id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    account_name VARCHAR(255),\n" +
                "    balance DECIMAL(10, 2)\n" +
                ");";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
        }
    }

    public void insertAccounts(String accountName, double initialBalance) throws SQLException {
        String insertQuery = "INSERT INTO accounts (account_name, balance) VALUES (?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, accountName);
            preparedStatement.setDouble(2, initialBalance);
            preparedStatement.executeUpdate();
        }
    }

    public void transfer(int fromAccountId, int toAccountId, double amount) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Debit the source account
            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(debitQuery)) {
                preparedStatement.setDouble(1, amount);
                preparedStatement.setInt(2, fromAccountId);
                if (preparedStatement.executeUpdate() == 0) {
                    throw new SQLException("Debit failed: No account found with id " + fromAccountId);
                }
            }

            // Credit the destination account
            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(creditQuery)) {
                preparedStatement.setDouble(1, amount);
                preparedStatement.setInt(2, toAccountId);
                if (preparedStatement.executeUpdate() == 0) {
                    throw new SQLException("Credit failed: No account found with id " + toAccountId);
                }
            }

            // Commit the transaction
            connection.commit();
        } catch (SQLException e) {
            // Rollback the transaction in case of an error
            if (connection != null) {
                connection.rollback();
            }
            throw e;  // Re-throw the exception to propagate it
        } finally {
            // Ensure auto-commit is re-enabled and close the connection
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }


    public static void main(String[] args) {
        TransactionExample example = new TransactionExample();
        try {
            example.createAccountsTable();
            example.insertAccounts("Alice", 1000.00);
            example.insertAccounts("Bob", 500.00);

            example.transfer(1, 2, 200.00);
            System.out.println("Transfer successful!");

        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}