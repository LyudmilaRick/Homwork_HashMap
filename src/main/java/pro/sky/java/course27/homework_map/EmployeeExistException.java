package pro.sky.java.course27.homework_map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeExistException extends RuntimeException{
    public EmployeeExistException(String message) {
        super(message);
    }
}
