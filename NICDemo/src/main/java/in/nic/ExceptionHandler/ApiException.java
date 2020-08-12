package in.nic.ExceptionHandler;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ApiException {
	private Instant timestamp;
	private HttpStatus status;
	private int code;
	private String message;
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ApiException [timestamp=" + timestamp + ", status=" + status + ", code=" + code + ", message=" + message
				+ "]";
	}
	
}
