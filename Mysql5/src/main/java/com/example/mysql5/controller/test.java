package com.example.mysql5.controller;

import java.sql.*;

public class test {

    public static void main(String[] args) throws SQLException {
        //用户信息和url
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root"; //数据库用户名
        String password = "123456"; //数据库密码

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //获取数据库连接
            connection = DriverManager.getConnection(url, username, password);//操作数据库
            statement = connection.createStatement();//获取操作数据库的对象
            String sql = "select * from EMP";
            resultSet = statement.executeQuery(sql);//执行sql，获取结果集

            while (resultSet.next()) {//遍历结果集，取出数据
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String age = resultSet.getString("age");//输出数据
                System.out.print("姓名:" + name);
                System.out.print("性别:" + sex);
                System.out.print("年龄" + age);

                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            resultSet.close();
            statement.close();
            connection.close();

        }

    }


}
