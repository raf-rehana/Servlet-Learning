
package dao;

import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

public class EmployeeDao {
 
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM employee"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee s = new Employee();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDesignation(rs.getString("designation"));
                s.setSalary(rs.getString("salary"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Employee getEmployeeById(int id) {
        Employee s = null;

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM employee WHERE id=?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Employee();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDesignation(rs.getString("designation"));
                s.setSalary(rs.getString("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public static void save(Employee s) {

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee(name, designation, salary) VALUES (?, ?, ?)"
            );

            ps.setString(1, s.getName());
            ps.setString(2, s.getDesignation());
            ps.setString(3, s.getSalary());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

  }

    public static void update(Employee s) {

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE employee SET name=?, designation=?, salary=? WHERE id=?"
            );

            ps.setString(1, s.getName());
            ps.setString(2, s.getDesignation());
            ps.setString(3, s.getSalary());
            ps.setInt(4, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void delete(int id) {

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM employee WHERE id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    } 

}
