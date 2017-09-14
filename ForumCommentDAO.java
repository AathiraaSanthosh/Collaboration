package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.ForumComment;

public interface ForumCommentDAO 
{

		public boolean createForumComment(ForumComment forumcomment);
		public ForumComment getForumComment(int CommentId);
		public List<ForumComment> getForums();
		public boolean approveForum(ForumComment forumcomment);
		public boolean editForumComment(int commentid);
		public boolean deleteForumComment(int commentid);
		
		
		
	}


