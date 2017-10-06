
public class OnlineStudent extends Student {
	
	private String skypeID;
	
	public OnlineStudent(String name, int id, String skypeId) {
		super(name, id);
		this.skypeID = skypeId;
	}
	
	public String toString() {
		return super.toString() +
				"SkypeID: " + skypeID;
	}
}
