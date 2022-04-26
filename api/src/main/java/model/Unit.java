package model;

public class Unit {

	private int id;
	private String uid;
	private String units;
	private String created_at;
	
	public Unit() {
	}
	
	public Unit(int id, String uid, String units, String created_at) {
		super();
		this.id = id;
		this.uid = uid;
		this.units = units;
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

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	

}
