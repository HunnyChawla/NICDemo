package in.nic.ExceptionHandler;

import java.time.Instant;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomHandler {
	@ExceptionHandler(IncorrectResultSizeDataAccessException.class)
	public ResponseEntity<ApiException> getResponse(IncorrectResultSizeDataAccessException px){
		ApiException api= new ApiException();
		api.setCode(HttpStatus.OK.value());
		api.setMessage("More than one entry found");
		api.setStatus(HttpStatus.OK);
		api.setTimestamp(Instant.now());
		return new ResponseEntity<ApiException>(api, HttpStatus.OK);
	}
}
