
import java.util.StringTokenizer;


public class Instructor {
	private int id;
	private String name;
	private String email;
	private String phone;
	private Course course;
	
	public Instructor(int id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public boolean assignCourse(Course c) {
		if (course != null) {
			return false;
		}
		else {
			course = c;
			return true;
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLastFourPhone() {
		StringTokenizer st = new StringTokenizer(phone, "-");
		String first = st.nextToken();
		String middle = st.nextToken();
		String last = st.nextToken();
		return last;
	}
	
	public String toString() {
		System.out.println("\tEmployee Number: " + id);
		System.out.println("\tName: " + name);
		System.out.println("\tEmail: " + email);
		System.out.println("\tPhone: " + phone);
		return "";
	}
	
	public String toString(String email) {
		System.out.println("\tEmployee Number: " + id);
		System.out.println("\tName: " + name);
		System.out.println("\tPhone: " + phone);
		return "";
	}
	
	public String getCourse() {
		return course.getTitle();
	}
}
