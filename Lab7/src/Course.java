
public class Course {
	private String cName;
	private double cScore;
	
	public Course() {
		//Default
	}
	
	public Course(String name, double score) {
		this.cName = name;
		this.cScore = score;
	}
	
	public String getCourseName() {
		return cName;
	}
	
	public String toString() {
		return "Course Title: " + cName + "\n" +
				"Course Score: " + cScore + "\n";
	}
}
