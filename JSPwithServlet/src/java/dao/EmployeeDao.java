package dao;

import entity.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

public class EmployeeDao {

    public static int saveEmp(Employee e) {
        int status = 0;
        String sql = "insert into emp(name, salary) values(?,?)";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDouble(2, e.getSalary());   // ✅ FIX

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<Employee> getAllEmp() {
        List<Employee> emps = new ArrayList<>();
        String sql = "select * from emp";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")   // ✅ FIX
                );
                emps.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emps;
    }

    public static void deleteEmp(int id) {
        String sql = "delete from emp where id=?";

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
        String sql = "select * from emp where id=?";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")   // ✅ FIX
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static int updateEmp(Employee e) {
        int status = 0;
        String sql = "update emp set name=?, salary=? where id=?";

        try (Connection con = DbUtil.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDouble(2, e.getSalary());   // ✅ FIX
            ps.setInt(3, e.getId());

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}