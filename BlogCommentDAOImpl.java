package com.niit.collaborate.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import com.niit.collaborate.model.BlogComment;

public class BlogCommentDAOImpl implements BlogCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public BlogCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean createBlogComment(BlogComment blogcomment) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
		    return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
		
	@Override
	public BlogComment getBlogComment(int CommentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogComment> getBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where status='A'");
		List<BlogComment> listBlogComment=query.list();
		session.close();
		return listBlogComment;
	}
	
	@Transactional
	@Override
	public boolean approveBlogComment(BlogComment blogcomment) {
		{
			try
			{
				
				sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
			    return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}}
		}
		
	@Override
	public boolean editBlogComment(int Commentid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean deleteBlogComment(int Commentid)
	{
		try
    	{
    		Session session=sessionFactory.openSession();
    		BlogComment blog=(BlogComment)session.get(BlogComment.class,Commentid);
    		session.delete(Commentid);
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

