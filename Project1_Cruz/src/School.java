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
			
			int temp = Integer.parseInt(readIn.nextLine()); //nextLine() limiter
			StringTokenizer st1;
			String[] sTempArr;
			String sTemp;
			
			
			for (int i = 0 ; i < temp; i++) {
				sTempArr = new String[4]; //Array to hold broken up string
				sTemp = readIn.nextLine(); //Holds line of unbroken string from file
				readInstructors.add(sTemp); //ArrayList to hold string
				st1 = new StringTokenizer(sTemp, ","); //Tokenizer to break up string at every ','
				
				int j = 0;
				while (st1.hasMoreTokens()) { //create new instructor object to add to hashmap of instructors with key of int from String
					String s = st1.nextToken();
					sTempArr[j] = s;
					j++;
				}
			}
			
			
			temp = Integer.parseInt(readIn.nextLine());
			for (int i = 0; i < temp; i++) {
				sTempArr = new String[4]; //Array to hold broken up string for 
				readCourses.add(readIn.nextLine());
			}
			
			temp = Integer.parseInt(readIn.nextLine());
			for (int i = 0; i < temp; i++) {
				readStudents.add(readIn.nextLine());
			}
			
			//CHECKING FOR END OF FILE
			if (!readIn.hasNextLine()) {
				System.out.println("End of File Reached");
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
