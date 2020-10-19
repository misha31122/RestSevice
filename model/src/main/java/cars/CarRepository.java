
package cars;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CarRepository extends JpaRepository<Car, Long> {
    Collection<Car> findByPeopleHumanNameContaining(String humanName);
}