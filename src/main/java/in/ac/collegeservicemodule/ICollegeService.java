package in.ac.collegeservicemodule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ICollegeService {
	private Integer id;
	private String collegename;
	private String location;
	
	public ICollegeService() {
		super();
	}

	public ICollegeService(Integer id, String collegename, String location) {
		super();
		this.id = id;
		this.collegename = collegename;
		this.location = location;
	}
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "ICollegeService [id=" + id + ", collegename=" + collegename + ", location=" + location + "]";
	}
	
}
