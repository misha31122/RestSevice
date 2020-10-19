package cars;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

    @JsonIgnore
    @ManyToOne
    private People people;

    @Id
    @GeneratedValue
    private Long id;

    public Car() { // jpa only
    }

    public Car(People people, String carName, String description) {
        this.carName = carName;
        this.description = description;
        this.people = people;
    }

    public String carName;
    public String description;

    public People getPeople() {
        return people;
    }

    public Long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getDescription() {
        return description;
    }
}