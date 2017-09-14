package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.ForumComment;

public class ForumCommentDAOImpl implements ForumCommentDAO
{
    @Autowired
    SessionFactory sessionFactory;
    public ForumCommentDAOImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
    
	@Override
	public boolean createForumComment(ForumComment forumcomment) {
		{
			try
			{
				sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
			    return false;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}	
		}}
		
	

	@Override
	public ForumComment getForumComment(int CommentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForumComment> getForums()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where status='A'");
		List<ForumComment> listForumComment=query.list();
		session.close();
		return listForumComment;	
	
	}

	@Transactional
	@Override
	public boolean approveForum(ForumComment forumcomment)
	{
		try
		{
			
			sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
		    return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		}
	

	@Override
	public boolean editForumComment(int commentid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean deleteForumComment(int commentid)
	{
		try
    	{
    		Session session=sessionFactory.openSession();
    		ForumComment forumcomment=(ForumComment)session.get(ForumComment.class,commentid);
    		session.delete(commentid);
    		session.flush();
    		session.close();
    		return true;
    	}
		catch(Exception e)
    	{
			System.out.println("Exception Arised:"+e);
            return false;        		
		
	}

}}
