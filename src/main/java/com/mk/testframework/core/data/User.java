package com.mk.testframework.core.data;

/**
 * @author VThipperudrappa
 *
 */
public class User {
	private String title;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String country;
	private String language;
	private String type;
	private String phoneNumber;
	public Address address;
	public Address2 address2;
	private String birthMonth;
	private String birthDay;
	private String gender;
	private String promocode;

	public class Address {
		public String country_code;
		public String country;
		public String streetAddress1;
		public String streetAddress2;
		public String city;
		public String state;
		public String province;
		public String postalCode;
		public String storeId;

		public String getCountry() {
			return country;
		}

		public String getStreetAddress1() {
			return streetAddress1;
		}

		public String getStreetAddress2() {
			return streetAddress2;
		}

		public String getCity() {
			return city;
		}

		public String getState() {
			return state;
		}

		public String getProvince() {
			return province;
		}

		public String getPostalCode(){
			return postalCode;
		}
		
		public String getStoreId(){
			return storeId;
		}
	}

	public class Address2 {
		public String country_code;
		public String country;
		public String streetAddress1;
		public String streetAddress2;
		public String city;
		public String state;
		public String province;
		public String zipCode;
		public String postalCode;

		public String getCountry() {
			return country;
		}

		public String getStreetAddress1() {
			return streetAddress1;
		}

		public String getStreetAddress2() {
			return streetAddress2;
		}

		public String getCity() {
			return city;
		}
		
		public String getState() {
			return state;
		}

		public String getProvince() {
			return province;
		}

		public String getPostalCode(){
			return postalCode;
		}
	}

	public String getTitle() {
		return title;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}


	public String getBirthmonth(){
		return birthMonth;
	}


	public String getBirthday(){
		return birthDay;
	}


	public String getGender(){
		return gender;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getCountry() {
		return country;
	}

	public String getLanguage() {
		return language;
	}

	public String getType() {
		return type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getpromocode() {
		  return promocode;
}
}