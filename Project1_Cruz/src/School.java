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
	private int numOfCourses;
	private HashMap<Integer, Course> courses;
	private int numOfInstructors;
	private HashMap<Integer, Instructor> instructors;
	private int numOfStudents;
	private HashMap<Integer, Student> students;
	
	public School(String name) {
		this.name = name;
		numOfInstructors = 0;
		numOfCourses = 0;
		numOfStudents = 0;
		instructors = new HashMap<Integer, Instructor>();
		courses = new HashMap<Integer, Course>();
		students = new HashMap<Integer, Student>();
	}
	
	public void readData(String fileIn) {
		ArrayList<String> readInstructors = new ArrayList<String>();
		ArrayList<String> readCourses = new ArrayList<String>();
		ArrayList<String> readStudents = new ArrayList<String>();
		
		int tempNum;
		String tempString;
		
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
					System.out.println(sTempArr[j]);
					s1 = st1.nextToken();
					j++;
					
					if (j == 3) { //Makes sure phone number is read in before while loop breaks
						sTempArr[j] = s1;
					}
				} 
				//System.out.println(sTempArr[0] + "," + sTempArr[1] + ", " + sTempArr[2] + "," + sTempArr[3]); //Only reading in all values 
				instructors.put(instructorId, new Instructor(sTempArr[0], sTempArr[1], sTempArr[2], sTempArr[3]));
				
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
				courses.put(courseId,  new Course(sTempArr[0], sTempArr[1], sTempArr[2], sTempArr[3]));
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
				students.put(studentId,  new Student(sTempArr[0], sTempArr[1]));
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
	
	public boolean addInstructor() {
		return false;
	}
	
	public boolean assignInstructor() {
		return false;
	}
	
	public boolean register() {
		return false;
	}
	
	public void putScore() {
		
	}
	
	public boolean addCourse() {
		return false;
	}
	
	public boolean deleteCourse() {
		return false;
	}
	
	public boolean unRegister() {
		return false;
	}
	
	public String searchByEmail(String email) {
		return "";
	}
	
	public String searchByPhone(String lastFour) {
		return "";
	}
}
