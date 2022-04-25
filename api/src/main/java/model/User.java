package model;

public class User {

	


	private String uid;
	private String name;
	private String nic;
	private String address;
	private String mobile;
	private String email;
	private String ebill;
	private String created_at;
	
	public User() {
	}
	
	public User(String uid, String name, String nic, String address, String mobile, String email, String ebill, String created_at) {
		super();
		this.uid = uid;
		this.name = name;
		this.nic = nic;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.ebill = ebill;
		this.created_at = created_at;
		
	}

	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNic() {
		return nic;
	}



	public void setNic(String nic) {
		this.nic = nic;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEbill() {
		return ebill;
	}



	public void setEbill(String ebill) {
		this.ebill = ebill;
	}



	public String getCreated_at() {
		return created_at;
	}



	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	

}
