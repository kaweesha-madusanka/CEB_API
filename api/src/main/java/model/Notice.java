package model;

public class Notice {

	private int id;
	private String message;
	private String created_at;

	public Notice() {
	}

	public Notice(int id, String message, String created_at) {
		super();
		this.id = id;
		this.message = message;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	
}
