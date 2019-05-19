package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.IUserDao;
import demo.entity.User;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> findOne(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.findone(userName, password);
	}

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		if (userDao.save(user) != null) {
			return 1;
		}
		return -1;
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
//		  Page<User> userPage = userDao.findAll(pageable);        
//		  List<User> userDTOList = userPage.getContent();        
//		  Page<User> userDTOPage = new PageImpl<User>(userDTOList,pageable,userPage.getTotalElements());        
//		  return userDTOPage;
		Sort sort=new Sort(Direction.ASC, "id");
		PageRequest pageable=new PageRequest(pageNo-1, pageSize,sort); 
		return userDao.findAll(pageable);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	

}
