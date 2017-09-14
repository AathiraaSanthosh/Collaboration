package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.Friend;

public class FriendDAOImpl implements FriendDAO
{

	@Autowired
	SessionFactory sessionFactory;
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean createFriend(Friend friend)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
		    return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
			
	}

	@Override
	public Friend getFriend(int friendId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> getFriendRequest()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where status='A'");
		List<Friend> listFriend=query.list();
		session.close();
		return listFriend;	
		
	}

	@Transactional
	@Override
	public boolean approveFriend(Friend friend)
	{

		try
		{
			friend.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
		    return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}	
	

	@Override
	public boolean editFriend(int friendid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean deleteFriend(int friendid)
	{
		try
    	{
    		Session session=sessionFactory.openSession();
    		Friend friend=(Friend)session.get(Friend.class,friendid);
    		session.delete(friend);
    		session.flush();
    		session.close();
    		return true;
    	}
		catch(Exception e)
    	{
			System.out.println("Exception Arised:"+e);
            return false;        	
    	}
		
		
	}

}
