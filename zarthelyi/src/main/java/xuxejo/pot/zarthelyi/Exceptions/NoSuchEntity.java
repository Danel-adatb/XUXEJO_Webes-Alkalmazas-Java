package xuxejo.pot.zarthelyi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found!")
public class NoSuchEntity extends RuntimeException{

}
