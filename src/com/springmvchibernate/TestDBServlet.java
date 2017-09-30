package com.springmvchibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String user="springcustomerstudent";
		String pass="springcustomerstudent";
		String jdbcurl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		try{
			PrintWriter out=response.getWriter();
			Class.forName(driver);
			Connection con=DriverManager.getConnection(jdbcurl,user,pass);
			out.println("success");
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
