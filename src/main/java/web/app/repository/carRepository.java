package web.app.repository;
import org.springframework.data.repository.CrudRepository;
import web.app.model.Car;

public interface carRepository extends CrudRepository<Car, Integer>
{
}
