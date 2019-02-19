package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import edu.fcps.ab.MappingAssessment.Student;

public class MapAssessmentTest {

	private Student createStudent(String name, int zip) {
		Student s = new Student(name, zip);
		return s;
	}

	@Test
	public void mostCommonNameTest1() {
		Collection<String> names = new ArrayList<String>();
		names.add("Bob");
		names.add("Ralph");
		names.add("Theo");
		names.add("Bob");
		names.add("Theo");
		names.add("Frank");
		names.add("Bob");
		names.add("Bob");
		names.add("Frank");
		names.add("Theo");
		String res = MappingAssessment.mostCommonName(names);
		assertEquals("Bob", res);
	}

	@Test
	public void mostCommonNameTest2() {
		Collection<String> names = new ArrayList<String>();
		String res = MappingAssessment.mostCommonName(names);
		assertNull(res);
	}

	@Test
	public void mostCommonNameTest3() {
		Collection<String> names = new ArrayList<String>();
		names.add("Bob");
		names.add("Ralph");
		names.add("Theo");
		names.add("Bob");
		names.add("Theo");
		names.add("Frank");
		names.add("Bob");
		names.add("Bob");
		names.add("Frank");
		names.add("Theo");
		names.add("Theo");
		String res = MappingAssessment.mostCommonName(names);
		assertTrue(res.equals("Bob") || res.equals("Theo"));
	}

	@Test
	public void mostCommonNameTest4() {
		Collection<String> names = new ArrayList<String>();
		names.add("Bob");
		String res = MappingAssessment.mostCommonName(names);
		assertEquals("Bob", res);
	}

	@Test
	public void mostCommonZipCodesTest1() {
		List<Student> list = new ArrayList<Student>();
		List<Student> list2 = new ArrayList<Student>();
		Collection<Student> col = new ArrayList<Student>();
		col.add(createStudent("Bob", 12345));
		col.add(createStudent("Earl", 67890));
		col.add(createStudent("Roman", 12345));
		col.add(createStudent("Victor", 45678));
		col.add(createStudent("Nick", 67890));
		col.add(createStudent("Aaron", 12345));
		col.add(createStudent("Marissa", 45678));
		col.add(createStudent("Enoch", 12345));
		col.add(createStudent("Spencer", 12345));
		col.add(createStudent("Britt", 45678));
		col.add(createStudent("Justin", 67890));
		list2.add(createStudent("Bob", 12345));
		list2.add(createStudent("Roman", 12345));
		list2.add(createStudent("Aaron", 12345));
		list2.add(createStudent("Enoch", 12345));
		list2.add(createStudent("Spencer", 12345));
		int zip = MappingAssessment.mostCommonZipStudents(col, list);
		assertEquals(12345, zip);
		assertEquals(list2, list);
	}

	@Test
	public void mostCommonZipCodesTest2() {
		List<Student> list = new ArrayList<Student>();
		List<Student> list2 = new ArrayList<Student>();
		Collection<Student> col = new ArrayList<Student>();
		col.add(createStudent("Bob", 12345));
		;
		list2.add(createStudent("Bob", 12345));
		int zip = MappingAssessment.mostCommonZipStudents(col, list);
		assertEquals(12345, zip);
		assertEquals(list2, list);
	}

	@Test
	public void mostCommonZipCodesTest3() {
		List<Student> list = new ArrayList<Student>();
		List<Student> list2 = new ArrayList<Student>();
		Collection<Student> col = new ArrayList<Student>();
		int zip = MappingAssessment.mostCommonZipStudents(col, list);
		assertEquals(-1, zip);
		assertEquals(list2, list);
	}

	@Test
	public void highestGPATest1() {
		Collection<Student> col = new ArrayList<Student>();
		col.add(createStudent("Bob", 12345));
		col.add(createStudent("Earl", 67890));
		col.add(createStudent("Roman", 12345));
		col.add(createStudent("Victor", 45678));
		col.add(createStudent("Nick", 67890));
		col.add(createStudent("Aaron", 12345));
		col.add(createStudent("Marissa", 45678));
		col.add(createStudent("Enoch", 12345));
		col.add(createStudent("Spencer", 12345));
		col.add(createStudent("Britt", 45678));
		Student s1 = createStudent("Justin", 67890);
		col.add(s1);
		Map<String, Student> map1 = new HashMap<String, Student>();
		Random r = new Random();
		double max = 0.0;
		Student s2 = null;
		for (Student s : col) {
			map1.put(s.getName(), s);
			double total = 0;
			double g = r.nextDouble() * 4;
			s.addGrade("Geometry", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("Computer Science", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("History", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("Home Economics", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("Physics", g);
			total += g;
			if (total / 5 > max) {
				max = total / 5;
				s2 = s;
			}
		}

		Student highest = MappingAssessment.highestGPA(map1);
		assertEquals(max, s2.getOverAllGrade(), .01);
		assertEquals(s2, highest);
	}

	@Test
	public void highestGPATest2() {
		Map<String, Student> map = new HashMap<String, Student>();
		Student highest = MappingAssessment.highestGPA(map);
		assertNull(highest);
	}

	@Test
	public void organizeByClassTest1() {
		List<Student> col = new ArrayList<Student>();
		col.add(createStudent("Bob", 12345));
		col.add(createStudent("Earl", 67890));
		col.add(createStudent("Roman", 12345));
		col.add(createStudent("Victor", 45678));
		col.add(createStudent("Nick", 67890));
		col.add(createStudent("Aaron", 12345));
		col.add(createStudent("Marissa", 45678));
		col.add(createStudent("Enoch", 12345));
		col.add(createStudent("Spencer", 12345));
		col.add(createStudent("Britt", 45678));
		Student s1 = createStudent("Justin", 67890);
		col.add(s1);
		Map<String, List<Student>> map1 = new HashMap<String, List<Student>>();
		Random r = new Random();
		List<Student> g1 = new ArrayList<Student>();
		List<Student> h1 = new ArrayList<Student>();
		List<Student> he1 = new ArrayList<Student>();
		List<Student> cs1 = new ArrayList<Student>();
		List<Student> p1 = new ArrayList<Student>();
		
		map1.put("Geometry", g1);
		map1.put("History", h1);
		map1.put("Home Economics", he1);
		map1.put("Physics", p1);
		map1.put("Computer Science", cs1);
		for (Student s : col) {
			if (r.nextInt(5) > 0) {
				s.addGrade("Geometry", r.nextDouble() * 4);
				g1.add(s);
			}
			if (r.nextInt(5) > 0) {

				s.addGrade("Computer Science", r.nextDouble() * 4);
				cs1.add(s);
			}
			if (r.nextInt(5) > 0) {
				s.addGrade("History", r.nextDouble() * 4);
				h1.add(s);
			}
			if (r.nextInt(5) > 0) {
				s.addGrade("Home Economics", r.nextDouble() * 4);
				he1.add(s);
			}
			if (r.nextInt(5) > 0) {
				s.addGrade("Physics", r.nextDouble() * 4);
				p1.add(s);
			}
		}
		Comparator<Student> c = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return (int) (s1.getOverAllGrade()-s2.getOverAllGrade());
			}
		};
		Collections.sort(p1, c );
		Collections.sort(he1, c );
		Collections.sort(h1, c );
		Collections.sort(cs1, c );
		Collections.sort(g1, c );
		Map<String,List<Student>> result = MappingAssessment.organizeByClass(col);
		assertEquals(map1,result);
	}
	@Test
	public void organizeByClassTest2() {
		List<Student> col = new ArrayList<Student>();
		col.add(createStudent("Bob", 12345));
		col.add(createStudent("Earl", 67890));
		col.add(createStudent("Roman", 12345));
		col.add(createStudent("Victor", 45678));
		col.add(createStudent("Nick", 67890));
		col.add(createStudent("Aaron", 12345));
		col.add(createStudent("Marissa", 45678));
		col.add(createStudent("Enoch", 12345));
		col.add(createStudent("Spencer", 12345));
		col.add(createStudent("Britt", 45678));
		Student s1 = createStudent("Justin", 67890);
		col.add(s1);
		Map<String, List<Student>> map1 = new HashMap<String, List<Student>>();
		Random r = new Random();
		List<Student> g1 = new ArrayList<Student>();
		List<Student> h1 = new ArrayList<Student>();
		List<Student> he1 = new ArrayList<Student>();
		List<Student> cs1 = new ArrayList<Student>();
		List<Student> p1 = new ArrayList<Student>();
		
		map1.put("pre-calculus", g1);
		map1.put("government", h1);
		map1.put("shop", he1);
		map1.put("AP chemistry", p1);
		map1.put("Literature", cs1);
		for (Student s : col) {
			if (r.nextInt(5) > 0) {
				s.addGrade("pre-calculus", r.nextDouble() * 4);
				g1.add(s);
			}
			if (r.nextInt(5) > 0) {

				s.addGrade("government", r.nextDouble() * 4);
				h1.add(s);
			}
			if (r.nextInt(5) > 0) {
				s.addGrade("shop", r.nextDouble() * 4);
				he1.add(s);
			}
			if (r.nextInt(5) > 0) {
				s.addGrade("AP chemestry", r.nextDouble() * 4);
				p1.add(s);
			}
			if (r.nextInt(5) > 0) {
				s.addGrade("Literature", r.nextDouble() * 4);
				cs1.add(s);
			}
		}

		Comparator<Student> c = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return (int) (s1.getOverAllGrade()-s2.getOverAllGrade());
			}
		};
		Collections.sort(p1, c );
		Collections.sort(he1, c );
		Collections.sort(h1, c );
		Collections.sort(cs1, c );
		Collections.sort(g1, c );
		Map<String,List<Student>> result = MappingAssessment.organizeByClass(col);
		assertEquals(map1,result);
	}
	
	@Test
	public void zipCodeGPABreakdownTest1() {
		List<Student> col = new ArrayList<Student>();
		col.add(createStudent("Bob", 12345));
		col.add(createStudent("Earl", 67890));
		col.add(createStudent("Roman", 12345));
		col.add(createStudent("Victor", 45678));
		col.add(createStudent("Nick", 67890));
		col.add(createStudent("Aaron", 12345));
		col.add(createStudent("Marissa", 45678));
		col.add(createStudent("Enoch", 12345));
		col.add(createStudent("Spencer", 12345));
		col.add(createStudent("Britt", 45678));
		col.add(createStudent("Justin", 67890));
		Map<Integer, Double> map1 = new HashMap<Integer, Double>();
		Random r = new Random();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for (Student s : col) {
			double total = 0;
			double g = r.nextDouble() * 4;
			s.addGrade("Geometry", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("Computer Science", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("History", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("Home Economics", g);
			total += g;
			g = r.nextDouble() * 4;
			s.addGrade("Physics", g);
			total += g;
			if(map2.get(s.getZip()) == null) map2.put(s.getZip(),1);
			else map2.put(s.getZip(),map2.get(s.getZip())+1);
			if(map1.get(s.getZip())== null) map1.put(s.getZip(), total/5);
			else map1.put(s.getZip(), map1.get(s.getZip())+total/5);
		}
		
		Set<Integer> keys = map1.keySet();
		for(Integer i:keys) {
			double total = map1.get(i);
			map1.put(i, total/map2.get(i));
		}
		
		Map<Integer, Double> result = MappingAssessment.zipCodeGPABreakdown(col);
		assertEquals(map1,result);	
	}
	
}