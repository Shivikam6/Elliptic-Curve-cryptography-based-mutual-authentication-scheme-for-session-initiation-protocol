package com.mvc.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.signupBean;
import com.mvc.dao.signupDao;
import com.mvc.util.EncryptPassword;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public String username, firstname, lastname, emailid, role, password, pass, HPW, HKs, Ks, hks, hpw;
       public String userDB;
       public byte[] R1;
       byte[] sum = new byte[20000000];
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		username = request.getParameter("username");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		emailid = request.getParameter("emailid");
		password = request.getParameter("password");
		pass = request.getParameter("pass2");
		
		String x ="[B@471cb089";
		byte[] Ks = x.getBytes(); //only known by the server and must be safeguarded.
		//new Random().nextBytes(Ks);
		System.out.println("Ks: "+Ks);
		
		hpw = username.concat(pass);
		System.out.println("hpw: "+hpw);
		HPW = EncryptPassword.encryption(hpw);	//HPW = h(username || PWD) 
		System.out.println("HPW: "+HPW);
		
		hks = username.concat(Ks.toString());
		HKs = EncryptPassword.encryption(hks);
		System.out.println("HKs: "+HKs);			//HKs = h(username || Ks)
		
		byte[] a = HPW.getBytes();
		String HPW_bin = "";
		for (int i = 0; i < a.length; i++) {
		      HPW_bin = HPW_bin + String.format("%8s", Integer.toBinaryString(a[i] & 0xFF)).replace(' ', '0');
		  }
		byte[] b = HKs.getBytes();
		String HKs_bin = "";
		for (int i = 0; i < a.length; i++) {
		      HKs_bin = HKs_bin + String.format("%8s", Integer.toBinaryString(a[i] & 0xFF)).replace(' ', '0');
		  }
		
		byte[] VPW = new byte[50];
		int i = 0;
		for (byte n : a)
		    VPW[i] = (byte) (n ^ b[i++]);		//VPW = HPW ⊕ HKs for User
		System.out.println("Encrypted password" + VPW);
		System.out.println("VPW: "+VPW.toString());
		
		int r1 = 1; int P=1;
		
		for (int j = 0; j < a.length; j++) {
			sum[j] += (byte) ( a[j] * 1);
		    }
		// R1 = sum;
		R1 = HPW.getBytes();
		 
		signupBean sb = new signupBean();
		sb.setUsername(username);
		sb.setFirstname(firstname);
		sb.setLastname(lastname);
		//sb.setEmailid(emailid);
		//sb.setRole(role);
		sb.setPassword(VPW.toString());
		//sb.setPass2(pass);
		
		signupDao sd = new signupDao();
		userDB = sd.checkUserNameAvailable(sb);
		//System.out.println("Encrypted password" + VPW.toString());
		//System.out.println("Encrypted pass" + password);
		
		if(userDB.equals("DUPLICATE"))
		{
			System.out.println("I'm duplicate");
			request.setAttribute("msg", "User Already Exist");
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			rd.include(request, response);
			return;
		}
		//else {	
				/*if (!password.equals(pass)) {
			request.setAttribute("msg", "Please enter same password");
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			rd.include(request, response);
			return;
				}*/
				else {
					sd.userRegister(username, firstname, lastname, VPW.toString(), R1);
					request.getRequestDispatcher("/Login.jsp").forward(request, response);
					}
			//} 	
	}
}
