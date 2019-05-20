import java.sql.*;

public class Main {

    private final static String url = "jdbc:postgresql://localhost:5432/c0mpany";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            ex1(conn);
//            ex2(conn);
//            ex3(conn);
            ex4(conn);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

//    1.SELECT all Employee records from the database
    public static void ex1(Connection conn){
        try {
            String SQL = "SELECT * FROM employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                System.out.print(rs.getString(1)+", ");
                System.out.print(rs.getString(2)+", ");
                System.out.print(rs.getString(3)+", ");
                System.out.print(rs.getString(4)+", ");
                System.out.print(rs.getString(5)+"\n");
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

//    2.SELECT only the DEVELOPERS from the table
    public static void ex2(Connection conn){
        try {
            String SQL = "SELECT * FROM employee WHERE employee_job_position='DEVELOPER'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                System.out.print(rs.getString(2) +" "+ rs.getString(3)+", ");
                System.out.print(rs.getString(4)+"\n");
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

//    3.SELECT only the Employees making more than 50000
    public static void ex3(Connection conn){
        try {
            String SQL = "SELECT * FROM employee WHERE employee_salary > 50000";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                System.out.print(rs.getString(2)+" "+rs.getString(3)+", ");
                System.out.print(rs.getString(5)+"\n");
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

//    4.INSERT a new ENGINEER, Thomas Tank, with a salary of 75000
    public static void ex4(Connection conn){
        try {
//            String SQL = "INSERT INTO employee(employee_first_name, employee_last_name, employee_job_position, employee_salary) VALUES('Thomas', 'Tank', 'ENGINEER', 75000)";
            String SQL = "SELECT * FROM employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                System.out.print(rs.getString(1)+", ");
                System.out.print(rs.getString(2)+", ");
                System.out.print(rs.getString(3)+", ");
                System.out.print(rs.getString(4)+", ");
                System.out.print(rs.getString(5)+" \n");
            }
        }
        catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        connect();
    }
}
