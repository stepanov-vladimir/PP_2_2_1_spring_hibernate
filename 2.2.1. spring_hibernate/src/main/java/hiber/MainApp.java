package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Nissan", 111)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Mazda", 222)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Subaru", 333)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Honda", 444)));

      List<User> users = userService.listUsers();


      List<Car> cars = carService.listCars();
      for (Car car : cars) {
         System.out.println(car);
      }

      User userByCarId = userService.findUserByCarId("Mazda", 222);
      System.out.println(userByCarId);

      context.close();
   }
}
