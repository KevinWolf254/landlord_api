package co.ke.proaktivio.models.pojos;

import lombok.Data;

@Data
public class Address {
	private String postalAddress;
	private String postalCode;
	private String building;
	private String floor;
	private int roomNumber;
	private String street;
	private String town;
	private String country;
}
