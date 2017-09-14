package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.Forum;

public interface ForumDAO
{
	public boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getForums();
	public boolean approveForum(Forum forum);
	public boolean editForum(int forumid);
	public boolean deleteForum(int forumid);
	
}
