package cn.jincheng.mapper;

import java.util.List;

import cn.jincheng.domain.User;


public interface UserMapper {
	
	List<User> findAll();
	void save(User user); 

}
