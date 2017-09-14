package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.Friend;

public interface FriendDAO
{
		public boolean createFriend(Friend friend);
		public Friend getFriend(int friendId);
		public List<Friend> getFriendRequest();
		public boolean approveFriend(Friend friend);
		public boolean editFriend(int friendid);
		public boolean deleteFriend(int friendid);
		
	}

	
	

