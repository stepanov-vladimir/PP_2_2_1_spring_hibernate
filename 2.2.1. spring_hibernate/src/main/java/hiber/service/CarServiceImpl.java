package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> listCars() {

        List<Car> list = carDao.listCars();

        return list;
    }
}
