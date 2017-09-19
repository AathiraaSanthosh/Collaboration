package com.niit.collaborate.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.dao.ForumCommentDAO;
import com.niit.collaborate.model.ForumComment;

public class ForumCommentDAOTestCase {
static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		forumCommentDAO = (ForumCommentDAO)annotationConfigAppContext.getBean("forumCommentDAO");
	}
	

	@Test
	public void createForumTest()
	{
		ForumComment forumComment = new ForumComment();
		
		forumComment.setId(3001);
		forumComment.setForumId(1001);
		forumComment.setComment("Blog comment string");
		forumComment.setUserId(10);
		forumComment.setUserName("hema");
		forumComment.setCommentDate(new java.util.Date());
	
		
		assertTrue("Problem in Blog comment creation",forumCommentDAO.createForumComment(forumComment));
		
		
	}

	@Ignore
	@Test
	public void approveForumTest() {
		
ForumComment forumComment = new ForumComment();
		
		forumComment.setId(3001);
		forumComment.setForumId(1001);
		forumComment.setComment("Blog comment string");
		forumComment.setUserId(10);
		forumComment.setUserName("hema");
		forumComment.setCommentDate(new java.util.Date());
	
		
		assertTrue("Problem in forum approve ",forumCommentDAO.approveForum(forumComment));
		
	}
	
	@Ignore
	@Test
	public void getAllApprovedForumTest() 
	{
		
		List<ForumComment> listForumComment=forumCommentDAO.getForums();
		assertTrue("No Approved forum Comments", listForumComment.size()>0);
	}
	
	@Ignore
	@Test
	public void deleteForumTest() {
		assertTrue("problem in deleting forum comment", forumCommentDAO.deleteForumComment(1001));
		
	}
}

	
	