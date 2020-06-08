package com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gui.model.Student;
import com.gui.util.DateUtil;
import com.gui.util.JdbcUtil;

public class StudentDao {

    /**
     * 新增
     */
    public void add(Student s) throws SQLException {
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //准备sql
        String sql = "insert into stus values(null,?,?,?,?)";
        //获取PreparedStatement
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setString(1, s.getName());
        ps.setDouble(2, s.getScore());
        ps.setObject(3, s.getBirth());
        ps.setString(4, s.getCity());
        //执行sql
        ps.executeUpdate();
        //关闭连接
        JdbcUtil.release(conn);
    }

    /**
     * 删除
     */
    public void detele(int id) throws SQLException {
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //准备sql
        String sql = "delete from stus where id=?";
        //获取PreparedStatement
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setInt(1, id);
        //执行sql
        ps.executeUpdate();
        //关闭连接
        JdbcUtil.release(conn);
    }

    /**
     * 修改
     */
    public void update(Student s) throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "update stus set name=?,score=?,birth=?,city=? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setDouble(2, s.getScore());
        ps.setObject(3, s.getBirth());
        ps.setString(4, s.getCity());
        ps.setInt(5, s.getId());
        ps.executeUpdate();
        JdbcUtil.release(conn);
    }

    /**
     * 查询
     */
    public List<Student> queryAll() throws SQLException {
        List<Student> stus = new ArrayList<>();
        //获取连接
        Connection conn = JdbcUtil.getConnection();
        //准备sql
        String sql = "select * from stus";
        //获取PreparedStatement
        PreparedStatement ps = conn.prepareStatement(sql);
        //执行sql
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setScore(rs.getDouble(3));
            s.setBirth(DateUtil.dateToLocalDate(rs.getDate(4)));
            s.setCity(rs.getString(5));
            stus.add(s);
        }
        //关闭连接
        JdbcUtil.release(conn);
        return stus;
    }
}
