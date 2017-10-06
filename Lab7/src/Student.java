import java.util.HashMap;

public class Student implements Workable{
	private String sName;
	private int sID;
	private HashMap<String, Course> courses;
	
	public Student(String name, int id) {
		this.sName = name;
		this.sID = id;
		courses = new HashMap<String, Course>();
	}
	
	public boolean addCourse(String newCourseName, double newCourseScore) {
		if (courses.containsKey(newCourseName)) {
			System.out.println("Student already has course.");
			System.out.println("false");
			return false;
		}
		else {
			courses.put(newCourseName, new Course(newCourseName, newCourseScore));
			System.out.println("true");
			return true;
		}
	}
	
	public String toString() {
		return "Name: " + sName + " \n" +
				"Student ID: " + sID + "\n" +
				"Number of Courses: " + courses.size() + "\n";
				//courses.toString();
	}
	
	@Override
	public boolean hasTimeToWork() {
		if (courses.size() >= 3) {
			System.out.println("Student does not have time to work");
			return false;
		}
		else {
			System.out.println("Student has time to work");
			return true;
		}
	}
}
