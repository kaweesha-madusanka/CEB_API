package model;

public class Bill {

	private int id;
	private String uid;
	private String amount;
	private String paid;
	private String created_at;
	
	public Bill() {
	}

	public Bill(int id, String uid, String amount, String paid, String created_at) {
		super();
		this.id = id;
		this.uid = uid;
		this.amount = amount;
		this.paid = paid;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	

}

