package app.Reimbursement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.Reimbursement.Repos.EmployeeRepoImpl;
import app.Reimbursement.Repos.TicketRepo;
import app.Reimbursement.Repos.TicketRepoImpl;
import app.Reimbursement.Repos.EmployeeRepo;
import app.Reimbursement.beans.Employees;
import app.Reimbursement.beans.Tickets;

public class EmployeeLoginServlet extends HttpServlet {

	private static final long serialVersionUID = -629378313430832399L;
	

	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String resource = req.getRequestURI();
		
		EmployeeRepo empRepo = new EmployeeRepoImpl();
		TicketRepo ticketRepo = new TicketRepoImpl();
		String nEmpResource = resource.replace("test/api", "");
		Employees yesLogin = null;
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapTime = new ObjectMapper();
		
		String httpVerb = req.getMethod();
		
		switch (nEmpResource) {
		case "/employee/login":
			resp.setContentType("application/json");
			String usernamePost = req.getParameter("username");
			String passwordPost = req.getParameter("password");
			boolean tUser= empRepo.checkLogin(usernamePost, passwordPost);

			//create user profile
			if(httpVerb.equals("GET")) {
				
				//Yes, created
				if (tUser != true) {			
				writer.write("Username is invalid or does not exist. Enter new Username");
				resp.setStatus(401);
				//fail
				}else {
					yesLogin = empRepo.findByUsername(usernamePost);
					Cookie employeeCookie = new Cookie("authenticated", "true");
					resp.addCookie(employeeCookie);
					writer.write("Welcome New User");
					resp.setStatus(201);
				}	
		//Employee login
			}else if (httpVerb.equals("POST")) {
				Employees newEmp = new Employees();
				System.out.println(req.getQueryString());				
				String empName = req.getParameter("full_name");
				String empUser= req.getParameter("employee_username");
				String empPass = req.getParameter("employee_password");
				Employees usernameTaken = empRepo.findByUsername(empUser);
				
				//user input error in login
				if(usernameTaken !=null) {
					writer.write("Username already in use. Please try again.");
					resp.setStatus(401);
				}else {
					newEmp = new Employees(0, empName, empUser, empPass);
					empRepo.newEmpoloyee(newEmp);
					Cookie newEmpCookie = new Cookie("authenticated","true");
					resp.addCookie(newEmpCookie);
					resp.setContentType("application/json");
					writer.write("Welcome New Revature Associate");
					resp.setStatus(201);
				}

		}break;
		
		case "/employees/all" :
			if(httpVerb.equals("GET")) {
				resp.setContentType("application/json");
				EmployeeRepo empRepos = new EmployeeRepoImpl();
				List<Employees> employees = empRepos.findAllEmployees();
				mapTime = new ObjectMapper();
				String json = mapTime.writeValueAsString(employees);
				writer.write(json);
				resp.setStatus(200);
			}else {resp.setStatus(404);
				writer.write("Request Invalid");
			}break;
			
			
		
		case "/employees/tickets/new" :
			if(httpVerb.equals("POST")) {
				Tickets newTick= new Tickets();
				System.out.println(req.getQueryString());				
				String empName = req.getParameter("employee_name");
				String empUser = req.getParameter("employee_username");
				Employees validUName = empRepo.findByUsername(empUser);
					if (validUName ==null) {
						writer.write("Invalid Username");
						resp.setStatus(400);	
					}else {
						String amount = req.getParameter("amount");
						double amountParsed = Double.parseDouble(amount);
						
						String description = req.getParameter("description");				
						newTick= new Tickets(0, amountParsed, description, 0, 0,"pending");
						ticketRepo.newTicket(newTick);
						Cookie newTicketCookie = new Cookie("authenticated","true");
						resp.addCookie(newTicketCookie);
						resp.setContentType("application/json");
						writer.write("Ticket submitted, pending manager processing");
						resp.setStatus(201);
					}
				
				}break;
				
		case"/employees/check-ticket":
			String ticketCredUser = req.getParameter("username");
			String ticketCredStatus= req.getParameter("status");
			if (httpVerb.equals("POST")) {
				Tickets myTickets = ticketRepo.findByStatus(ticketCredUser);
				String json = mapTime.writeValueAsString(myTickets);
				resp.setContentType("application/json");
				writer.write("To filter by status, insert a status into the designated box.");
				writer.write(json);
				resp.setStatus(200);
				String statusInput = req.getParameter("status");
					if(statusInput.equals("pending")) {
						ticketRepo.findByStatus(statusInput);
					}else if(statusInput.equals("approved")) {
						ticketRepo.findByStatus(statusInput);
					}else if(statusInput.equals("denied")) {
						ticketRepo.findByStatus(statusInput);
					}else {resp.setStatus(404);
					}
			}break;
		}
		}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req,resp);
		}
}

