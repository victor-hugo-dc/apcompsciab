package edu.fcps.ab;

import java.util.*;

/**
 * Complete each of the following methods as described in the
 * descriptions provided. Ensure the methods work by using the
 * test case provided. Please note, it is not good enough to 
 * just make the code work. Efficiency will be part of the grade.
 * 
 * @author oasmall
 *
 */

public class MappingAssessment {

	public static class Student {
		private String name;
		private int zip;
		private Map<String, Double> grades;
		
		public Student(String name, int zip) {
			this.name = name;
			this.zip = zip;
			grades = new HashMap<String, Double>();
		}
		
		public void addGrade(String n, double d) {
			grades.put(n, d);
		}
		
		public double getGrade(String n) {
			return grades.get(n);
		}
		
		public Map<String, Double> getGrades(){
			return grades;
		}
		
		public double getOverAllGrade() {
			//To do as part of the test
			double x = 0, y = 0;
			for(double grade : grades.values()) {
				x += grade;
				y ++;
			}
			return x/y;
		}
		
		public int getZip() {
			return zip;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean equals(Object o) {
			Student s = (Student)o;
			return zip == s.zip && name.equals(s.name);
		}
		
		public String toString() {
			return name+" "+zip;
		}
		
	}
	/**
	 * Using a map compute the most commonly used name in the list
	 * provided. This algorithm must run in O(n) time. (This means 
	 * no loops in loops)
	 * @param names Collection of names to sort through.
	 * @return The most common name
	 */
	
	public static String mostCommonName(Collection<String> names) {
		if(names.isEmpty()) 
			return null;
		SortedMap<Integer, String> nameAppear = new TreeMap<Integer, String>();
		for(String s : names)
			nameAppear.put(Collections.frequency(names, s), s);
		int n = nameAppear.lastKey();
		String name = null;
		for(Map.Entry<Integer, String> entry : nameAppear.entrySet()) {
			if(entry.getKey() == n)
				name = entry.getValue();
		}
		return name;
	}
	
	/**
	 * Given a Collection of Student Objects, and an empty List of Students,
	 * return the zip code with the most students living in it. Populate 
	 * the given list with all the students in that zip code. This should run 
	 * in O(n) time.
	 * 
	 * @param students Collection of Students
	 * @param where List of Students to be populated with those from the
	 *        most common zip code
	 * @return the most common zip code (-1 if no common zip)
	 * 
	 */
	
	public static int mostCommonZipStudents(Collection<Student> students, List<Student> common) {
		if(students.isEmpty())
			return -1;
		ArrayList<Integer> studentZips = new ArrayList<Integer>();
		for(Student stud : students)
			studentZips.add(stud.getZip());
		SortedMap<Integer, Integer> appearZip = new TreeMap<Integer, Integer>();
		for(Student s : students)
			appearZip.put(Collections.frequency(studentZips, s.getZip()), s.getZip());
		
		int n = appearZip.lastKey();
		int zip = -1;
		for(Map.Entry<Integer, Integer> entry : appearZip.entrySet()) {
			if(entry.getKey() == n) 
				zip = entry.getValue();
		}
		for(Student stud : students) {
			if(stud.getZip() == zip)
				common.add(stud);
		}
		return zip;
	}
	
	/**
	 * Given a Map of Students keyed by name (Map<String, Student>), 
	 * return the Student with the highest GPA. In the case of a tie,
	 * return the Student with the first name alphabetically. Please 
	 * make as efficient as possible
	 * 
	 * @param students Map of students keyed by name
	 * 
	 * @return Student with the highest GPA
	 */
	public static Student highestGPA(Map<String, Student> students) {
		double highestGPA = 0.0;
		Student student = null;
		for(Map.Entry<String, Student> entry : students.entrySet()) {
			if(entry.getValue().getOverAllGrade() > highestGPA) {
				highestGPA = entry.getValue().getOverAllGrade();
				student = entry.getValue();
			}
			else if(entry.getValue().getOverAllGrade() >= highestGPA && entry.getValue().name.compareTo(student.getName()) < 0) 
				student = entry.getValue();
		}
		return student;
	}
	
	/**
	 * return a Map<String, List<Student>> of all the classes mapped
	 * to a List of Students in the order of their grades from lowest
	 * to highest
	 * 
	 * @param students List<Student> the students in the school
	 * @return Map<String, List<Student>> {"class name":{Student1, Student2}, "class 2":{Student3, Student4"}} 
	 */
	public static Map<String, List<Student>> organizeByClass(List<Student> students){
		ArrayList<String> list = new ArrayList<String>();
		for(Student s : students) {
			for(Map.Entry<String, Double> m : s.getGrades().entrySet()) {
				if(!list.contains(m.getKey()))
					list.add(m.getKey());
			}
		}
		Map<String, List<Student>> map = new TreeMap<String, List<Student>>();
		for(String course : list)
			map.put(course, getStudentsInClass(course, students));
		return map;
	}
	
	private static List<Student> getStudentsInClass(String course, List<Student> students){
		List<Student> list = new ArrayList<Student>();
		for(Student s : students) {
			if(s.getGrades().containsKey(course))
				list.add(s);
		}
		Comparator<Student> c = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return (int) (s1.getOverAllGrade()-s2.getOverAllGrade());
			}
		};
		
		Collections.sort(list, c);
		return list;
	}
	
	/**
	 * Returns a map by zip code, of average GPA. Return will have the
	 * pattern {zipcode:averageGPA,zipcode2: averageGPA} 
	 * 
	 * @param students List of students
	 * @return Map<Integer, Double> the map of zip codes and associated average gpas
	 * 
	 */
	
	public static Map<Integer, Double> zipCodeGPABreakdown(List<Student> students){
		Map<Integer, Double> map = new TreeMap<Integer, Double>();
		ArrayList<Integer> zipCodes = new ArrayList<Integer>();
		ArrayList<Double> avgGPA = new ArrayList<Double>();
		for(Student s : students) {
			int zip = s.getZip();
			if(!zipCodes.contains(zip))
				zipCodes.add(zip);
		}
		
		for(int i : zipCodes) {
			avgGPA.add(getAvg(i, students));
		}
		
		for(int i = 0; i < zipCodes.size(); i++) {
			map.put(zipCodes.get(i), avgGPA.get(i));
		}
		return map;
	}
	
	private static double getAvg(int zip, List<Student> students) {
		double num = 0.0;
		double denom = 0.0;
		for(Student s : students) {
			if(s.getZip() == zip) {
				num += s.getOverAllGrade();
				denom += 1.0;
			}
		}
		if(denom == 0.0)
			denom = 1.0;
		
		return num/denom;
	}
}
