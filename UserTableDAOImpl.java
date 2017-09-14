package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaborate.model.UserTable;

public class UserTableDAOImpl implements UserTableDAO 
{
   @Autowired
   SessionFactory sessionFactory;
   public UserTableDAOImpl(SessionFactory sessionFactory)
   {
	   this.sessionFactory=sessionFactory;
   }
	
	@Override
	public boolean createUserTable(UserTable usertable)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(usertable);
		    return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		
		}
		
	}

	@Override
	public UserTable getUserTable(int usertableId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTable> getUserTable()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from userTable where status='A'");
		List<UserTable> listUserTable=query.list();
		session.close();
		return listUserTable;
	}

	@Override
	public boolean approveUserTable(UserTable usertable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUserTable(int usertableid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserTable(int usertableid) {
		// TODO Auto-generated method stub
		return false;
	}

}
