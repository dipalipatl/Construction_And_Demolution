package com.rcpit.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		try
		{
			Connection conn = ConnectionDB.connect();
			PreparedStatement ps = conn.prepareStatement("select * from userlogin where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	response.sendRedirect("requestcnd.html");
	        }
	        else
	        {
	        	response.sendRedirect("errorpage.html");
	        }

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	}


