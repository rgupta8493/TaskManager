public class Task {
	
	private int id;
	private String description;
	

	

	public Task(int idCounter, String text) {
		this.id = idCounter;
		this.description = text;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
