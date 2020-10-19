package cars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Bean
    CommandLineRunner init(PeopleRepository peopleRepository, CarRepository carRepository) {
        return (evt) ->
                Arrays.asList("Иванов,Петров,Сидоров,Полещук".split(","))
                        .forEach(a -> {
                            if(a.equalsIgnoreCase("Иванов")) {
                                People people = peopleRepository.save(new People(a));
                                carRepository.save(new Car(people, "ГАЗ 21", "Волга 21-я"));
                                carRepository.save(new Car(people, "ВАЗ 2106", "Шестерка"));
                            }

                            if(a.equalsIgnoreCase("Петров")) {
                                People people = peopleRepository.save(new People(a));
                                carRepository.save(new Car(people, "УАЗ", "УАЗИК"));
                                carRepository.save(new Car(people, "ВАЗ 2110", "Десятка"));
                            }

                            if(a.equalsIgnoreCase("Сидоров")) {
                                People people = peopleRepository.save(new People(a));
                                carRepository.save(new Car(people, "BMW", "БМВ"));
                                carRepository.save(new Car(people, "ВАЗ 2112", "Двенашка"));
                            }

                            if(a.equalsIgnoreCase("Полещук")) {
                                People people = peopleRepository.save(new People(a));
                                carRepository.save(new Car(people, "ГАЗ 20", "Победа"));
                                carRepository.save(new Car(people, "ВАЗ 2107", "Семерка"));
                            }
                        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


