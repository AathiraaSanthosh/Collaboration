package com.niit.collaborate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Friend
{
private int UserId;
private int FriendId;
private String Status;
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public int getFriendId() {
	return FriendId;
}
public void setFriendId(int friendId) {
	FriendId = friendId;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}

	
	
}
