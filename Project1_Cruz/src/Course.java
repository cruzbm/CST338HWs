
public class Course {
	private int id;
	private String title;
	private int enrolled;
	private String room;
	private Instructor instructor;
	private double avgScore;
	
	public Course(int id, String title, int enrolled, String room) {
		this.id = id;
		this.title = title;
		this.enrolled = enrolled;
		this.room = room;
		this.avgScore = 100.0;
	}
	
	public Course(Course copyCourse) {
		this.id = copyCourse.getId();
		this.title = copyCourse.getTitle();
		this.enrolled = copyCourse.getEnrolled();
		this.room = copyCourse.getRoom();
		this.avgScore = copyCourse.avgScore;
	}
	
	public boolean assignInstructor(Instructor i) {
		if (instructor == null) {
			instructor = i;
			return true;
		}
		else {
			System.out.println("Instructor already assigned.");
			return false;
		}
	}
	
	public void addStudent() {
		enrolled++;
	}
	
	public void minusStudent() {
		enrolled--;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void updateLocation(String room) {
		this.room = room;
	}
	
	public int getId() {
		return id;
	}
	
	public int getEnrolled() {
		return enrolled;
	}
	
	public String getRoom() {
		return room;
	}
	
	public String getInstructor() {
		return instructor.getName();
	}
}
