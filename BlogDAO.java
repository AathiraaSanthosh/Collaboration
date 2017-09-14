package com.niit.collaborate.dao;

import java.util.List;
import com.niit.collaborate.model.Blog;


public interface BlogDAO 
{

	public boolean createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getBlogs();
	public boolean approveBlog(Blog blog);
	public boolean editBlog(int blogid);
	public boolean deleteBlog(int blogid);
	
	
}
