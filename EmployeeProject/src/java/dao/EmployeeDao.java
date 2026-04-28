package dao;

import entity.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

public class EmployeeDao {

    public static int saveEmp(Employee e) {

        int status = 0;
        String sql = "INSERT INTO employee(name, joindate, designation, salary) VALUES (?,?,?,?)";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDate(2, e.getJoindate());
            ps.setString(3, e.getDesignation());
            ps.setDouble(4, e.getSalary());

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return status;
    }

   public static List<Employee> getAllEmp() {

    List<Employee> list = new ArrayList<>();
    String sql = "SELECT * FROM employee";

    try (Connection con = DbUtil.getCon();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Employee e = new Employee();

            e.setId(rs.getInt("id"));
            e.setName(rs.getString("name"));
            e.setJoindate(rs.getDate("joindate"));
            e.setDesignation(rs.getString("designation"));
            e.setSalary(rs.getDouble("salary"));

            list.add(e);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return list;
}

    public static void deleteEmp(int id) {

        String sql = "DELETE FROM employee WHERE id=?";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Employee getById(int id) {

        Employee e = null;
        String sql = "SELECT * FROM employee WHERE id=?";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    e = new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDate("joindate"),
                            rs.getString("designation"),
                            rs.getDouble("salary")
                    );
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static int updateEmp(Employee e) {

        int status = 0;
        String sql = "UPDATE employee SET name=?, joindate=?, designation=?, salary=? WHERE id=?";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDate(2, e.getJoindate());
            ps.setString(3, e.getDesignation());
            ps.setDouble(4, e.getSalary());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return status;
    }
}