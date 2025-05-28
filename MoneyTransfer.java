import java.sql.*;

public class MoneyTransfer {
    public static void transferMoney(Connection conn, int fromAccount, int toAccount, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false);

            PreparedStatement debitStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?"
            );
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);
            int debitResult = debitStmt.executeUpdate();

            PreparedStatement creditStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?"
            );
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);
            int creditResult = creditStmt.executeUpdate();

            if (debitResult == 1 && creditResult == 1) {
                conn.commit();
                System.out.println("Transfer successful.");
            } else {
                conn.rollback();
                System.out.println("Transfer failed. Rolled back.");
            }

        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
