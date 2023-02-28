package web.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.app.model.Car;
import web.app.service.CarService;

//creating RestController
@RestController
public class CarController
{
    @RequestMapping("/")
    public String getCar() {
        return "Guten Tag!";
}
//autowired the CarService class
@Autowired
CarService carService;
//creating a get mapping that retrieves all the students detail from the database 
@GetMapping("/car")
private List<Car> getAllCar()
{
return carService.getAllCar();
}
//creating a get mapping that retrieves the detail of a specific student
@GetMapping("/car/{id}")
private Car getCar(@PathVariable("id") int id)
{
return carService.getCarById(id);
}
//creating a delete mapping that deletes a specific student
@DeleteMapping("/car/{id}")
private void deleteCar(@PathVariable("id") int id)
{
carService.delete(id);
}
//creating post mapping that post the student detail in the database
@PostMapping("/car")
private int saveStudent(@RequestBody Car car)
{
carService.saveOrUpdate(car);
return car.getId();
}
}
