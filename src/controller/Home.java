package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */

/**
 * servlet annotations를 사용하여, servlet name은 파일 이름명이자 클래스명 인 Home을 쓰고, servlet의 url-pattern 은 
 * 아래와 같이 webservlet annotation을 사용하여 /home과 같이 경로명을 만들어준다. 
 * */

@WebServlet("/home")

/**
 * servlet은 httpservlet을 상속받아서 httpservletrequest, httpservletresponse를 오버라이딩하여 request와 response를
 * 사용한다.여기서 servlet container 가 넘어온 객체의 주소값을 전달하여 request 에 넣어준다.
 * */
public class Home extends HttpServlet {
	
	/**
	 * 여기서 serialVersionUID 는 static variables(공유 자원)으로 stack 메모리 에 저장되는  local variables와는 달리 
	 * heap 메모리에 저장이 된다. 
	 * 
	 * 자바 직렬화는 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도
	 * 사용 할 수 있또록 바이트 형태로 데이터를 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변화하는(역직렬화 )
	 * 를 아울러서 말한다. 
	 * 시스템적으로 보면,JVM 의 메모리에 상주 (힙 또는 스택) 되어있는 객체 데이터를 바이트 형태로 변환하는 기술과 
	 * 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 말한다.
	 * 
	 *	여기서 사용된 serialVersionUID의 경우, JVM은 직렬화와 역직렬화를 하는 시점의 클래스에 대한 버전 번호를 부여한다.
	 *만약 그 시점에 클래스의 정의가 바뀌엉 있다면 새로운 버전 번호를 할당한다. 그래서 직렬화 할 때의 버전번호와 
	 *역직렬화를 할때의 버전 번호가 다르면 역직렬화가 불가능하게 될 수도 있다. 즉, 클래스 버전이 맞는지를 확인하기 위한 
	 *용도로 serialVersionUID 값을 사용한다. 만약 한 클래스는 1L 이고 , 다른 클래스는 1L 이 아닌 2L일 경우 역직렬화에서
	 *예외처리가 발생한다.  
	 *

	 * */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	// index.jsp 에서 a href 태그 안에서 get 방식으로 action 속성과 값을 보냈었는데, 여기 business logic (java code) 에서 그 값을 받고 처리한다 .
		
		String action = request.getParameter("action");
		
	// business logic - 3가지 경우를 분류하여 page 를 이동시키고자 한다. 
		
		String page = null;

		if (action.equals("login"))
			page = "/view/loginForm.jsp";
		else if (action.equals("register"))
			page = "/view/registerForm.jsp";
		else
			page = "/view/error.jsp";
	
	/*
	 * requestDispatcher 의 역할 : 
	 * 
	 * 1. 결과 데이터에 대한 bean 을 정의한다. 
	 * 2. request를 처리할 수 있는 servlet를 사용하도록 한다. 
	 * 3. 위에서 선언한 business logic를 수행하고 해당 결괄르 가진 bean를 꺼내올 수 있도록 한다. 
	 * 4. bean을 request,session or servlet context에 저장한다. 
	 * 5. jsp page로 요청을 forward한다. 
	 * 6. beans으로 부터 데이터를 사용할 수 있도록 한다. --> jsp:useBean / jsp:getProperty / ${name.property} etc. 
	 * 
	 * */
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}
}
