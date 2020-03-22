package be.abis.ex.model;

public class VatNumber {

	private String countryCode;
	private String id;

	public VatNumber() {

	}

	public VatNumber(String countryCode, String id) {
		this.countryCode = countryCode;
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return countryCode + id;
	}

}
