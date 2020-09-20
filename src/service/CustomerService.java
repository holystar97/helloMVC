package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	
	// static 을 사용해서 싱글톤 패턴을 적용 
	private static final CustomerService instance = new CustomerService();
	
	// map 를 사용하여 customer에 대한 정보를 저장하도록 함 (차후에는 db를 사용할 것으로 예상) 
	private Map<String, Customer> customers;
	
	// 생성자에서 map을 생성 (원한다면 map 에 여기서 더미 데이터 생성해주어도 됨 )
	private CustomerService() {
		customers = new HashMap<String, Customer>();
		System.out.println("In CustomerService Constructor");
	}
	//싱글톤 패턴을 사용하여 객체를 하나 생성 후 여러개 사용하도록 함
	public static CustomerService getInstance() {
		return instance;
	}
	
	// map 를 사용하여  customer id bean 에 대한 정보를 customer 객체에 저장한다 
	public Customer addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
		customers.put(customer.getPassword(), customer);
		customers.put(customer.getName(), customer);
		customers.put(customer.getGender(), customer);
		customers.put(customer.getEmail(), customer);
		
		return customer;
		
	}
	
	// 해당 id 에 대한 customer를 찾아서 반환한다 ( Id 를 소문자로 하여 찾아주는 이유는 유연성을 위해  ) 
	public Customer findCustomer(String id) {
		if(id != null)
			return(customers.get(id.toLowerCase()));
		else
			return null;
	}
	// customer 객체의 id 와 password 를 입력받아 비교하여 반환한다.
	public Customer login(String id, String password) {
		Customer customer = findCustomer(id);
	
		if(customer != null) {
			if( password.equals(customer.getPassword())  ) {
				System.out.println("login success");
				return customer;
			}
					
			else {
				System.out.println("login failed");
				return null;
			}
		}	
		return null;
	}

	
	
	
	
}
