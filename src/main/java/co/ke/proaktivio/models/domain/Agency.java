package co.ke.proaktivio.models.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.ke.proaktivio.models.pojos.Address;
import co.ke.proaktivio.models.pojos.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "agency")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agency {
	@Id 
	private String id;
	private String name;
	private String description;
	private boolean enabled;
	private String pinNumber;
	private String vat;
	private Address address;
	private Contact contact;
	private int payBillNumber;
	private double monthlyFee;
}
