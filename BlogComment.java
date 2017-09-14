package com.niit.collaborate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class BlogComment
{

	private int Id  ;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getBlogId() {
		return BlogId;
	}
	public void setBlogId(int blogId) {
		BlogId = blogId;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public Date getCommentDate() {
		return CommentDate;
	}
	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	private int BlogId;
	private String Comment;
	private Date CommentDate;
	private int UserId;
	private String UserName;
	
}
