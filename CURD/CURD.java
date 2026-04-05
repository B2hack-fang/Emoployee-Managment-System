package org.CURD;

import org.DTO.EmployeeDTO;
import java.sql.*;

public class CURD {

    public CURD() {
        CreateTable();
    }

    public void CreateTable() {
        try (
                Connection connection = ConnectionFactory.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String sql = """
                CREATE TABLE IF NOT EXISTS employee (
                    sn INT AUTO_INCREMENT PRIMARY KEY,
                    USERNAME VARCHAR(30) NOT NULL UNIQUE,
                    PASSWORD VARCHAR(30),
                    FULLNAME VARCHAR(100),
                    ADDRESS VARCHAR(200),
                    SALARY INT
                )
                """;

            statement.executeUpdate(sql);
            System.out.println("Table Created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ INSERT
    public void insert(EmployeeDTO emp) {
        String sql = "INSERT INTO employee (USERNAME, PASSWORD, FULLNAME, ADDRESS, SALARY) VALUES ('"
                + emp.getUserName() + "','" + emp.getPassword() + "','" +
                emp.getFullName() + "','" + emp.getAddress() + "'," +
                emp.getSalary() + ")";

        try (
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
        ) {
            stmt.executeUpdate(sql);
            System.out.println("Data Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ UPDATE
    public void Update(String userName, int salary) {
        String sql = "UPDATE employee SET SALARY = " + salary +
                " WHERE USERNAME = '" + userName + "'";

        try (
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
        ) {
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows + " row updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ DELETE
    public void deleteData(String userName) {
        String sql = "DELETE FROM employee WHERE USERNAME = '" + userName + "'";

        try (
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
        ) {
            int rows = stmt.executeUpdate(sql);
            System.out.println(rows + " row deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ READ
    public void read(String userName, int salary) {
        String sql = "SELECT * FROM employee WHERE USERNAME='" + userName +
                "' AND SALARY=" + salary;

        try (
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getString("USERNAME") + " " +
                                rs.getString("FULLNAME") + " " +
                                rs.getInt("SALARY")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}