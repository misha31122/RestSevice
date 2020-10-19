package cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
class PeopleCarRestController {

    private final CarRepository carRepository;

    private final PeopleRepository peopleRepository;


    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    Collection<Car> getCarsCollection() {
        return this.carRepository.findAll();
    }

    @RequestMapping(value = "/peoples", method = RequestMethod.GET)
    Collection<People> getPeoplesCollection() {
        return this.peopleRepository.findAll();
    }

    @RequestMapping(value = "/{humanId}", method = RequestMethod.GET)
    Collection<People> getPeoples(@PathVariable String humanId) {
        return this.peopleRepository.findByHumanNameContaining(humanId)
                .orElseThrow(() -> new HumanNotFoundException(humanId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{humanId}/cars")
    Collection<Car> getCarsCollection(@PathVariable String humanId) {
        this.validateHuman(humanId);
        return this.carRepository.findByPeopleHumanNameContaining(humanId);
    }


    @Autowired
    PeopleCarRestController(CarRepository carRepository, PeopleRepository peopleRepository) {
        this.carRepository = carRepository;
        this.peopleRepository = peopleRepository;
    }

    private void validateHuman(String humanId) {
        this.peopleRepository.findByHumanNameContaining(humanId)
                .orElseThrow(() -> new HumanNotFoundException(humanId));
    }
}
