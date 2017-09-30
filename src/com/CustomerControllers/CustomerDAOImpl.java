package com.CustomerControllers;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> theQuery =session.createQuery("from Customer",Customer.class);
		List<Customer> customers =theQuery.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer cust) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
				
		// save the customer ... finally LOL
		session.saveOrUpdate(cust);
	}

	@Override
	public Customer getCustomer(int id) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database from primary key
		Customer customer=session.get(Customer.class,id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
	}
}
