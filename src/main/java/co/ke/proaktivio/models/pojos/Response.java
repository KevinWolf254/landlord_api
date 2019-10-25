package co.ke.proaktivio.models.pojos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Response {
	HttpStatus status;
	boolean isSuccess;
	String message;
	List<Object> data = new ArrayList<Object>();
}
