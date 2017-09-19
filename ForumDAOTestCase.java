package com.niit.collaborate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.dao.ForumDAO;
import com.niit.collaborate.model.Forum;

public class ForumDAOTestCase {

	
static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.hema.collaborationbackend");
		annotationConfigAppContext.refresh();
		
		forumDAO = (ForumDAO)annotationConfigAppContext.getBean("forumDAO");
	}
	
	@Ignore
	@Test
	public void createForumTest()
	{
		Forum forum = new Forum();
		
		forum.setForumId(2001);
		forum.setForumName("test");
		forum.setForumContent("forum description");
		forum.setUserId(1001);
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		
		
		assertTrue("Problem in Forum creation",forumDAO.createForum(forum));
		
		
	}
	@Ignore
	@Test
	public void approveForumTest() {
		
		Forum forum = new Forum();

		forum.setForumId(2001);
		forum.setForumName("test");
		forum.setForumContent("forum description");
		forum.setUserId(1001);
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		assertTrue("Problem in Forum approve creation",forumDAO.approveForum(forum));
		
	}
	
	
	
	@Test
	public void getAllApprovedForumTest() 
	{
		
		List<Forum> listForum=forumDAO.getForums();
		assertTrue("No Approved forums", listForum.size()>0);
	}

	
	

}
