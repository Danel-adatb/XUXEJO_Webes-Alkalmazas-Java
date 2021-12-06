package zarthelyi.masodik.feladat.pot.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found Entity")
public class NoSuchEntity extends RuntimeException{
}
