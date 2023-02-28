package web.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.app.model.Car;
import web.app.service.CarService;

//creating RestController
@RestController
public class CarController
{
//autowired the CarService class
@Autowired
CarService carService;
//creating a get mapping that retrieves all the students detail from the database 
@GetMapping("/student")
private List<Car> getAllCar()
{
return carService.getAllCar();
}
//creating a get mapping that retrieves the detail of a specific student
@GetMapping("/student/{id}")
private Car getCar(@PathVariable("id") int id)
{
return carService.getCarById(id);
}
//creating a delete mapping that deletes a specific student
@DeleteMapping("/student/{id}")
private void deleteCar(@PathVariable("id") int id)
{
carService.delete(id);
}
//creating post mapping that post the student detail in the database
@PostMapping("/student")
private int saveStudent(@RequestBody Car car)
{
carService.saveOrUpdate(car);
return car.getId();
}
}
