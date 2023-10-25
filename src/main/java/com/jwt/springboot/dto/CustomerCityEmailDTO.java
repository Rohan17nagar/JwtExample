package com.jwt.springboot.dto;

public class CustomerCityEmailDTO {
	private String city;
    private String customerEmail;

    public CustomerCityEmailDTO(String city, String customerEmail) {
        this.city = city;
        this.customerEmail = customerEmail;
    }

	public CustomerCityEmailDTO() {
		super();
	
	}

	@Override
	public String toString() {
		return "CustomerCityEmailDTO [city=" + city + ", customerEmail=" + customerEmail + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
    
    
}
