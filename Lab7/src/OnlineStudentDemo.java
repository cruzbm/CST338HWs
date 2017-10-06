
public class OnlineStudentDemo {
	
	public static void main(String[] args) {
		
		OnlineStudent b = new OnlineStudent("Brandon", 8309, "brcruz");
		b.addCourse("CST338", 90.00);
		b.hasTimeToWork(); //Should return true
		
		b.addCourse("CST412", 90.00);
		b.hasTimeToWork(); //Should return true
		
		System.out.println(b); //Should print saying enrolled in 2 courses
		System.out.println("\n");
		
		b.addCourse("CST499", 95.00);
		b.hasTimeToWork(); //Should return false
		
		b.addCourse("CST338",  95.00); //Should return false, student already has course
		
		System.out.println(b); //Should say enrolled in only 3 courses
		
	}
}
