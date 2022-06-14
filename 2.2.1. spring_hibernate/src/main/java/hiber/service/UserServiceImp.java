package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User findUserByCarId(String carModel, int carSeries) {
      return userDao.findUserByCarId(carModel, carSeries);
   }


}
