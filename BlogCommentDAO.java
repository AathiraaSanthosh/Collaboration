package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.BlogComment;

public interface BlogCommentDAO
{
	

		public boolean createBlogComment(BlogComment blogcomment);
		public BlogComment getBlogComment(int CommentId);
		public List<BlogComment> getBlogs();
		public boolean approveBlogComment(BlogComment blogcomment);
		public boolean editBlogComment(int Commentid);
		public boolean deleteBlogComment(int Commentid);
		
		
	
	
	
}
