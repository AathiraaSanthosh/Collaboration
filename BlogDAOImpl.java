package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.Blog;

public class BlogDAOImpl implements BlogDAO
{
     
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean createBlog(Blog blog) {
			try
			{
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
			    return false;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}
		}
	@Override
	public Blog getBlog(int blogId) {
			// TODO Auto-generated method stub
			return null;
		}
        
	    @Override
		public List<Blog> getBlogs() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog where status='A'");
			List<Blog> listBlog=query.list();
			session.close();
			return listBlog;
		}

		@Transactional
		@Override
		public boolean approveBlog(Blog blog)
			{
				try
				{
					blog.setStatus("A");
					sessionFactory.getCurrentSession().saveOrUpdate(blog);
				    return true;
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised:"+e);
					return false;
				}
			}
			
		
        @Override
		public boolean editBlog(int blogid)
        {
			
			return false;
		}
        
        @Transactional
        @Override
		public boolean deleteBlog(int blogid)
        {
        	try
        	{
        		Session session=sessionFactory.openSession();
        		Blog blog=(Blog)session.get(Blog.class,blogid);
        		session.delete(blog);
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
