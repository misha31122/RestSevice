package cars;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class People {

    @OneToMany(mappedBy = "people")
    private Set<Car> cars = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    public Set<Car> getCars() {
        return cars;
    }

    public Long getId() {
        return id;
    }


    public String getHumanName() {
        return humanName;
    }


    public String humanName;

    public People(String humanName) {
        this.humanName = humanName;
    }

    public People() { // jpa only
    }
}