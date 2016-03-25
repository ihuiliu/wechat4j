package cn.jincheng.service;

import java.util.List;

import cn.jincheng.domain.User;


public interface UserService {
	List<User> findAll();
	void save(User user); 

}
