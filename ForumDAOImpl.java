package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.Forum;

public class ForumDAOImpl implements ForumDAO
{
   @Autowired
   SessionFactory sessionFactory;
   public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
   
	@Override
	public boolean createForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		    return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}	
		
	}

	@Override
	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Forum> getForums()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum where status='A'");
		List<Forum> listForum=query.list();
		session.close();
		return listForum;			
	
	}

	@Transactional
	@Override
	public boolean approveForum(Forum forum) 
	{
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		    return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	@Override
	public boolean editForum(int forumid) {
		
		return false;
	}

	@Transactional
	@Override
	public boolean deleteForum(int forumid)
	{
		try
    	{
    		Session session=sessionFactory.openSession();
    		Forum forum=(Forum)session.get(Forum.class,forumid);
    		session.delete(forum);
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
