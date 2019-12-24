package co.ke.proaktivio.models.pojos;

public enum ELocality {
	SUB_URBAN("Sub urban"), CBD("Cbd"), REMOTE("Remote");
	
	private String name;
	 
	ELocality(String name) {
        this.name = name;
    }
	public String getName() {
		return name;
	}
}
