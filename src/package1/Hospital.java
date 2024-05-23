package package1;

public class Hospital {

	int hId;
	String name, department, location, category;
	
	public Hospital() {
		
	}

	public Hospital(int hId, String name, String department, String location, String category) {
		this.hId = hId;
		this.name = name;
		this.department = department;
		this.location = location;
		this.category = category;
	}
	
	public int gethId() {
		return hId;
	}
	
	public void sethId(int hId) {
		this.hId = hId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
