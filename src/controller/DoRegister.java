package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoRegister
 */


@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("id");
		String customerPwd = request.getParameter("password");
		String customerName = request.getParameter("name");
		String customerGender = request.getParameter("gender");
		String customerEmail = request.getParameter("email");
		
		Customer customer = new Customer(customerId, customerPwd, customerName, customerGender, customerEmail);
		customer.setId(customerId);
		customer.setPassword(customerPwd);
		customer.setName(customerName);
		customer.setGender(customerGender);
		customer.setEmail(customerEmail);
		
		CustomerService service = (CustomerService) CustomerService.getInstance();
		System.out.println(service);
		customer =service.addCustomer(customer);
		
		request.setAttribute("customer", customer);
		
		String page;
		
		if(customer == null ) {
			page="/view/registerFail.jsp";
		}else {
			page="/view/registerSuccess.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

}
