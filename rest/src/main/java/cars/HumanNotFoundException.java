package cars;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class HumanNotFoundException extends RuntimeException {

    public HumanNotFoundException(String humanId) {
        super("could not find human '" + humanId + "'.");
    }
}
