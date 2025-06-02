import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            StudentDAO dao = new StudentDAO(conn);

            boolean inserted = dao.insertStudent(1, "Alice", 22);
            System.out.println("Insert successful: " + inserted);

            boolean updated = dao.updateStudentAge(1, 23);
            System.out.println("Update successful: " + updated);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
