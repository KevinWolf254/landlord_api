package co.ke.proaktivio.models.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.ke.proaktivio.models.pojos.Address;
import co.ke.proaktivio.models.pojos.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Agency {
	@Id 
	private String id;
	private String name;
	private boolean enabled;
	private String pinNumber;
	private Address address;
	private Contact contact;
	private int payBillNumber;
	private double monthlyFee;
}
