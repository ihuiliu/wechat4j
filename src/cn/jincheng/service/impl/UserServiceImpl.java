package cn.jincheng.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jincheng.domain.User;
import cn.jincheng.mapper.UserMapper;
import cn.jincheng.service.UserService;
@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
			mapper.save(user);
			int x=1/0;
			System.out.println(x);
			mapper.save(user);
			// TODO Auto-generated catch block
		
	}

}
