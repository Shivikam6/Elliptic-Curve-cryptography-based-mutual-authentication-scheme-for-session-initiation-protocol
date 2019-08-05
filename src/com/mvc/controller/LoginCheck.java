package com.mvc.controller;


import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;
import com.mvc.util.EncryptPassword;
import com.mvc.util.ExtendedEuclidean;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public String username, password, role, hpw, HPW1, hks, HKs, h ; 
      public byte[] HPW, VPW;
	public byte HPW_inv, R1, R_1;

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = null;
			username = request.getParameter("username");
			password = request.getParameter("password");
			
			
			
			String x ="[B@471cb089";
			byte[] Ks = x.getBytes();
			
			LoginBean lb = new LoginBean();
			lb.setUsername(username);
			lb.setPassword(password);
			//lb.setRole(role);
				
			//Login by user from the Database
			LoginBean loginbean=new LoginBean();
			loginbean.setUsername(username);
			loginbean.setPassword(password);
			//loginbean.setRole(role);
			
			LoginDao logindao=new LoginDao();
			String validateUser=logindao.authenticateUser(loginbean);
			
			//Checking the validation of user and error messages
			
			if (validateUser.equals("SUCCESS"))
			{
				//hpw = username.concat(password);
				//HPW1 = EncryptPassword.encryption(hpw);
				//HPW = HPW1.getBytes();
				VPW = password.getBytes();
				
				hks = username.concat(x);
				HKs = EncryptPassword.encryption(hks);
				byte[] HKs_byte= HKs.getBytes();
				
				int i = 0;
				for (byte n : HKs_byte)
				    HPW[i] = (byte) (n ^ VPW[i++]);
				
				R1=logindao.getR1(username);
				System.out.println("R1: "+R1);
				HPW_inv = ExtendedEuclidean.solve(HPW, R1);
				R_1 = (byte) (HPW_inv * R1);
				
				byte R2 = 2; //r2=2
				String R2_str = String.valueOf(R2);
				//byte[] SKs =  
				
				//h = SKs.concat(R2);
				//h_1 = EncryptPassword.encryption(input)
				
				session=request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("/Profile_S.jsp").forward(request, response);
			}
			
			else {
				
				if (username.equals("") && password.equals("")) {
					request.setAttribute("msg", "Please enter Username & password");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
				}
				else if (username.equals("")) {
					request.setAttribute("msg", "Please enter Username");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
					}
				else if (password.equals("")) {
					request.setAttribute("msg", "Please enter Password");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
					}
				else {
					request.setAttribute("msg", "Incorrect Credentials");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
				}
			}
			
	}


		private byte[] dotProduct(byte[] hPW2, byte[] r12) {
			// TODO Auto-generated method stub
			return null;
		}

}
