package co.ke.proaktivio.models.pojos;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class ResultModel {
	int status;
	boolean isSuccess;
	String message;
	@SuppressWarnings("rawtypes")
	List data;
}
