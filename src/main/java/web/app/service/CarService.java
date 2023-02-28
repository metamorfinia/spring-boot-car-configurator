package web.app.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.app.model.Car;

//defining the business logic
@Service
public class CarService
{
@Autowired
web.app.repository.carRepository carRepository;
//getting all student records
public List<Car> getAllCar()
{
List<Car> cars = new ArrayList<Car>();
carRepository.findAll().forEach(car -> cars.add(car));
return cars;
}
//getting a specific record
public Car getCarById(int id)
{
return carRepository.findById(id).get();
}
public void saveOrUpdate(Car car)
{
carRepository.save(car);
}
//deleting a specific record
public void delete(int id) 
{
carRepository.deleteById(id);
}
}