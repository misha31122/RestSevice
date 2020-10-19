package cars;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Long> {
    Optional<List<People>> findByHumanNameContaining(String humanName);
}