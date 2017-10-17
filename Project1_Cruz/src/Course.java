
public class Course {
	private String id;
	private String title;
	private String enrolled;
	private String room;
	
	public Course(String id, String title, String enrolled, String room) {
		this.id = id;
		this.title = title;
		this.enrolled = enrolled;
		this.room = room;
	}
	
	public String getTitle() {
		return title;
	}
}
