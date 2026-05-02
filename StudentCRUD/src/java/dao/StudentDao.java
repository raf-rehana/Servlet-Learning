package dao;

import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

public class StudentDao {

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM student"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setStudentClass(rs.getString("studentClass"));
                s.setRoll(rs.getString("roll"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Student getStudentById(int id) {
        Student s = null;

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM student WHERE id=?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setStudentClass(rs.getString("studentClass"));
                s.setRoll(rs.getString("roll"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public static void save(Student s) {

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student(name, studentClass, roll) VALUES (?, ?, ?)"
            );

            ps.setString(1, s.getName());
            ps.setString(2, s.getStudentClass());
            ps.setString(3, s.getRoll());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

  }

    public static void update(Student s) {

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE student SET name=?, studentClass=?, roll=? WHERE id=?"
            );

            ps.setString(1, s.getName());
            ps.setString(2, s.getStudentClass());
            ps.setString(3, s.getRoll());
            ps.setInt(4, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void delete(int id) {

        try (Connection con = DbUtil.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM student WHERE id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
