import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {

    public static void transferMoney(Connection conn, int fromAccountId, int toAccountId, double amount) throws SQLException {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try {
            conn.setAutoCommit(false);

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitUpdated = debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditUpdated = creditStmt.executeUpdate();

                if (debitUpdated == 1 && creditUpdated == 1) {
                    conn.commit();
                    System.out.println("Transfer successful.");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed, transaction rolled back.");
                }
            }

        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Error occurred: " + e.getMessage());
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            transferMoney(conn, 1, 2, 100.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
