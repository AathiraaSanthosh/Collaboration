package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.UserTable;

public interface UserTableDAO
{

	public boolean createUserTable(UserTable usertable);
	public UserTable getUserTable(int usertableId);
	public List<UserTable> getUserTable();
	public boolean approveUserTable(UserTable usertable);
	public boolean editUserTable(int usertableid);
	public boolean deleteUserTable(int usertableid);
	
	
	
}
