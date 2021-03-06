package com.niit.collaborate.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.dao.BlogCommentDAO;
import com.niit.collaborate.model.BlogComment;


public class BlogCommentDAOTestCase 
{

static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.hema.collaborationbackend");
		annotationConfigAppContext.refresh();
		
		blogCommentDAO = (BlogCommentDAO)annotationConfigAppContext.getBean("blogCommentDAO");
	}
	

	@Test
	public void createBlogTest()
	{
		BlogComment blogComment = new BlogComment();
		
		blogComment.setId(3001);
		blogComment.setBlogId(1001);
		blogComment.setComment("Blog comment string");
		blogComment.setUserId(10);
		blogComment.setUserName("hema");
		blogComment.setCommentDate(new java.util.Date());
	
		
		assertTrue("Problem in Blog comment creation",blogCommentDAO.createBlogComment(blogComment));
		
		
	}

	@Ignore
	@Test
	public void approveBlogTest() {
		
		BlogComment blogComment = new BlogComment();
		
		blogComment.setId(3001);
		blogComment.setBlogId(1001);
		blogComment.setComment("Blog comment string");
		blogComment.setUserId(10);
		blogComment.setUserName("hema");
		blogComment.setCommentDate(new java.util.Date());
	
		
		assertTrue("Problem in Blog creation",blogCommentDAO.approveBlogComment(blogComment));
		
	}
	
	@Ignore
	@Test
	public void getAllApprovedBlogTest() 
	{
		
		List<BlogComment> listBlogComment=blogCommentDAO.getBlogs();
		assertTrue("No Approved Blog Comments", listBlogComment.size()>0);
	}
	
	@Ignore
	@Test
	public void deleteBlogTest() {
		assertTrue("problem in deleting blog comment", blogCommentDAO.deleteBlogComment(1001));
		
	}
	
}
