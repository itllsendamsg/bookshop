package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookIDSqlDao {

    public static void main(String[] argv) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "root", "");
            EmployeeDao employees = new EmployeeSqlDao(conn);
            Employee newEmp = new Employee(510082,
                    "Konrad",
                    "Jałowiecki",
                    Date.valueOf("1988-06-22"),
                    Date.valueOf("2017-11-10"),
                    Gender.MALE);
            employees.add(newEmp);

            Employee emp = employees.get(510082);
            System.out.println("Employee " + emp.toString() + " was hired at " + emp.getHireDate());
            emp.setHireDate(Date.valueOf("2017-12-21"));
            emp.setLastName("Kowalski");
            employees.update(emp);

            emp = employees.get(510082);
            System.out.println("We changed hiring date to " + emp.getHireDate() + " and last name to " + emp.getLastName());
            employees.delete(newEmp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
