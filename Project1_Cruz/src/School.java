/*
* Title: School.java
* Abstract: 
* Author: Brandon Cruz
* ID: 6809
* Date: 10/11/2017
*/

import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class School {
	
	private String name;
	private HashMap<Integer, Course> courses;
	private HashMap<Integer, Instructor> instructors;
	private HashMap<Integer, Student> students;
	
	public School(String name) {
		this.name = name;
		instructors = new HashMap<Integer, Instructor>();
		courses = new HashMap<Integer, Course>();
		students = new HashMap<Integer, Student>();
	}
	
	public void readData(String fileIn) {
		ArrayList<String> readInstructors = new ArrayList<String>();
		ArrayList<String> readCourses = new ArrayList<String>();
		ArrayList<String> readStudents = new ArrayList<String>();
		
		//int tempNum;
		//String tempString;
		
		//READ IN INTRUCTORS
		//READ IN COURSES
		//READ IN STUDENTS
		try {
			Scanner readIn = new Scanner(new FileInputStream(fileIn));
			
			StringTokenizer st1;
			String[] sTempArr;
			String sTemp;
			
			//--READ IN INSTRUCTORS--//
			int temp = Integer.parseInt(readIn.nextLine()); //nextLine() limiter
			for (int i = 0 ; i < temp; i++) {
				sTempArr = new String[4]; //Array to hold broken up string
				sTemp = readIn.nextLine(); //Holds line of unbroken string from file
				readInstructors.add(sTemp); //ArrayList to hold string
				st1 = new StringTokenizer(sTemp, ","); //Tokenizer to break up string at every ','
				
				int j = 0;
				String s = st1.nextToken(); //FIRST TOKEN IS ID OF INSTRUCTOR
				String s1 = s;
				int instructorId = Integer.parseInt(s);
				while (st1.hasMoreTokens()) { //create new instructor object to add to hashmap of instructors with key of int from String
					sTempArr[j] = s1;
					s1 = st1.nextToken();
					j++;
					
					if (j == 3) { //Makes sure phone number is read in before while loop breaks
						sTempArr[j] = s1;
					}
				} 
				if (instructors.containsKey(instructorId)) {
					System.out.println("Instructor info reading failed -- Employee ID " + instructorId + " already exists.");
				}
				else {
					//System.out.println(sTempArr[0] + "," + sTempArr[1] + ", " + sTempArr[2] + "," + sTempArr[3]); //Only reading in all values 
					instructors.put(instructorId, new Instructor(Integer.parseInt(sTempArr[0]), sTempArr[1], sTempArr[2], sTempArr[3]));
				}
			}
			
			//--READ IN COURSES--//
			temp = Integer.parseInt(readIn.nextLine());
			for (int i = 0; i < temp; i++) {
				sTempArr = new String[4]; //Array to hold broken up string for courses
				sTemp = readIn.nextLine();
				readCourses.add(sTemp);
				st1 = new StringTokenizer(sTemp, ",");
				
				int j = 0;
				String s = st1.nextToken();
				String s1 = s;
				int courseId = Integer.parseInt(s);
				while (st1.hasMoreTokens()) {
					sTempArr[j] = s1;
					s1 = st1.nextToken();
					j++;
					if (j == 3) {
						sTempArr[3] = s1;
					}
				}
				//System.out.println(sTempArr[0] + "," + sTempArr[1] + ", " + sTempArr[2] + "," + sTempArr[3]);
				if (courses.containsKey(courseId)){
					System.out.println("Course Number " + courseId + " already exists.");
				}
				else{
					courses.put(courseId,  new Course(Integer.parseInt(sTempArr[0]), sTempArr[1], Integer.parseInt(sTempArr[2]), sTempArr[3]));
				
				}
			}
			
			//--READ IN STUDENTS--//
			temp = Integer.parseInt(readIn.nextLine());
			for (int i = 0; i < temp; i++) {
				sTempArr = new String[4]; //Array to hold broken up string for courses
				sTemp = readIn.nextLine();
				readCourses.add(sTemp);
				st1 = new StringTokenizer(sTemp, ",");
				
				int j = 0;
				String s = st1.nextToken();
				String s1 = s;
				int studentId = Integer.parseInt(s);
				while (st1.hasMoreTokens()) {
					sTempArr[j] = s1;
					s1 = st1.nextToken();
					j++;
					if (j == 1) {
						sTempArr[1] = s1;
					}
				}
				//System.out.println(sTempArr[0] + "," + sTempArr[1]);
				if (students.containsKey(studentId)) {
					System.out.println("Student info reading failed -- Student ID " + studentId + " already exists.");
				}
				else {
					
					students.put(studentId,  new Student(Integer.parseInt(sTempArr[0]), sTempArr[1]));
				}
			}
			
			//CHECKING FOR END OF FILE -- DONE READING IN FILE
			if (!readIn.hasNextLine()) {
				//System.out.println("End of File Reached");
				System.out.println("Done.");
			}
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File open failed.");
		}
		catch (NoSuchElementException e) {
			System.out.println("Element not found.");
		}
	}
	
	public void schoolInfo() {
		System.out.println("School Name: " + name);
		System.out.println("Instructors Information");
		for (int e : instructors.keySet()) {
			System.out.println("\t" + instructors.get(e).getName());
		}
		System.out.println("Course Information");
		for (int e: courses.keySet()) {
			System.out.println("\t" + courses.get(e).getTitle());
		}
		System.out.println("Student Information");
		for (int e: students.keySet()) {
			System.out.println("\t" + students.get(e).getName());
		}
	}
	
	public boolean addInstructor(int id, String name, String email, String phone) {
		if(instructors.containsKey(id)){
			return false;
		}
		else
		{
			instructors.put(id, new Instructor(id, name, email, phone));
			return true;
		}
	}
	
	public boolean assignInstructor(int cId, int iId) {
		if (instructors.containsKey(iId)) {
			if (courses.containsKey(cId)) {
				instructors.get(iId).assignCourse(courses.get(cId));
				courses.get(cId).assignInstructor(instructors.get(iId));
				return true;
			}
			else {
				System.out.println("Course " + cId + " does not exist.");
				return false;
			}
		}
		else {
			System.out.println("Instructor " + iId + " does not exist.");
			return false;
		}
	}
	
	public boolean register(int cId, int sId) {
		if (!students.containsKey(sId)) {
			System.out.println("Student " + sId + " does not exist.");
			return false;
		}
		if (students.get(sId).currentCourses(cId)) {
			System.out.println("Student " + sId + " (" + students.get(sId).getName() + ") is already enrolled in " + cId);
			return false;
		}
		else {
			students.get(sId).registerNewCourse(cId, courses.get(cId));
			return true;
		}
	}
	
	public boolean putScore(int cId, int sId, double score) {
		if (!students.containsKey(sId)) {
			System.out.println("Student " + sId + " does not exist.");
			return false;
		}
		if (!students.get(sId).currentCourses(cId)) {
			System.out.println("Student " + sId + " (" + name + ") is not enrolled in " + cId);
			return false;
		}
		else {
			students.get(sId).inputScore(cId, score);
			return true;
		}
		
	}
	
	public boolean addCourse(int id, String title, int enrolled, String room) {
		if (courses.containsKey(id)) {
			System.out.println("Course addition failed – Course number " + id + " already used.");
			return false;
		}
		else {
			courses.put(id, new Course(id, title, enrolled, room));
			return true;
		}
	}
	
	public boolean unRegister(int cId, int sId) {
		if (!students.containsKey(sId)) {
			System.out.println("Student " + sId + " does not exist.");
			return false;
		}
		if (!courses.containsKey(cId)) {
			System.out.println("Course " + cId + "does not exist.");
			return false;
		}
		
		students.get(sId).unregisterCourse(cId);
		return true;
	}
	
	public boolean searchByEmail(String email) {
		System.out.println("Search Key: " + email);
		for (int e : instructors.keySet()) {
			if (instructors.get(e).getEmail().equals(email)) {
				instructors.get(e).toString(email); //Overloaded toString to print instructor information without email
				return true;
			}
		}
		return false;
	}
	
	public boolean searchByPhone(String lastFour) {
		System.out.println("Search Key: " + lastFour);
		for (int e : instructors.keySet()) {
			if (instructors.get(e).getLastFourPhone().equals(lastFour)) {
				System.out.println(instructors.get(e).toString()); //Prints all instructor information -- NOT PRINTING CORRECTLY
				return true;
			}
		}
		System.out.println(lastFour + " is not found.");
		return false;
	}
	
	public void courseInfo() {
		System.out.println("Number of Courses: " + courses.size());
		for (int e : courses.keySet()) {
			System.out.print("\t" + courses.get(e).getId() + ": " + courses.get(e).getEnrolled() + " enrolled. \n");
		}
	}
	
	public void courseInfo(int cId) {
		if (!courses.containsKey(cId)) {
			System.out.println("Course " + cId + " does not exist.");
			return;
		}
		
		System.out.println("Course Number: " + cId);
		System.out.println("Instructor: " + courses.get(cId).getInstructor());
		System.out.println("Course Title: " + courses.get(cId).getTitle());
		System.out.println("Total Enrolled: " + courses.get(cId).getEnrolled());
		System.out.print("Course Average: ");
		for (int e: students.keySet()) {
			// GET AVERAGE SCORE FOR THE GIVEN COURSE
		}
	}
	
	public Course getCourse(int cId) { 
		return courses.get(cId);
	}
	
	public boolean deleteCourse(int cId) {
		if (courses.containsKey(cId)) {
			for (int e : students.keySet())
			{
				if (students.get(e).currentCourses(cId)) {
					System.out.println("Course deletion failed -- Student(s) enrolled in course.");
					return false;
				}
			}
			
			courses.remove(cId);
			return true;
		}
		return false;
	}
}
