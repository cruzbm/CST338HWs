import java.util.HashMap;

public class Student {
	private int id;
	private String name;
	private HashMap<Integer, Course> enrolledCourses;
	private HashMap<Course, Double> scores;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		this.enrolledCourses = new HashMap<>();
		this.scores = new HashMap<>();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean unregisterCourse(int cId) {
		if (enrolledCourses.containsKey(cId)) {
			enrolledCourses.get(cId).minusStudent();
			enrolledCourses.remove(cId);
			return true;
		}
		else {
			System.out.println("Student " + id + " is not enrolled in " + cId);
			return false;
		}
	}
	
	public boolean currentCourses(int cId) {
		if (enrolledCourses.containsKey(cId)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void registerNewCourse(int cId, Course newCourse) {
		enrolledCourses.put(cId, newCourse);
		enrolledCourses.get(cId).addStudent();
		scores.put(newCourse, 0.00);
	}
	
	public boolean inputScore(int cId, double score) {
		scores.put(enrolledCourses.get(cId), score);
		return false;
	}
	
}
