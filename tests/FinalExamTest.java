package edu.fcps.ab;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FinalExamTest {

	@Test
	public void countSubStringTest1() {
		String [] strings = {"bobby","robby","robbery","mobbery"};
		int result = FinalExam.countSubStrings(strings,  "bb");
		assertEquals(4, result);
	}
	
	@Test
	public void countSubStringTest2() {
		String [] strings = {"bobby","robby",null,"mobbery"};
		int result = FinalExam.countSubStrings(strings,  "bb");
		assertEquals(3, result);
	}
	
	@Test
	public void countSubStringTest3() {
		String [] strings = {};
		int result = FinalExam.countSubStrings(strings, "bb");
		assertEquals(0,result);
	}
	
	@Test
	public void countSubStringTest4() {
		String [] strings = {null,null,null};
		int result = FinalExam.countSubStrings(strings, "bb");
		assertEquals(0,result);
	}
	
	@Test
	public void countSubStringsTest5() {
		String [] strings = {"anna","banana","fan","stan", "anacanda"};
		int result = FinalExam.countSubStrings(strings, "an");
		assertEquals(7,result);
	}
	
	@Test
	public void countSubStringsTest6() {
		String [] strings = {null,"anna","banana","fan","stan", "anacanda"};
		int result = FinalExam.countSubStrings(strings, "an");
		assertEquals(7,result);
	}
	
	@Test
	public void makeTranslationTest1() {
		String [] english = {"farm","flee","people","run"};
		String [] other = {"beep","bop","pop","tot"};
		Map<String,String> result = FinalExam.makeTranslation(english, other, true);
		assertEquals(4,result.size());
		assertEquals("beep",result.get("farm"));
		assertEquals("bop",result.get("flee"));
		assertEquals("pop",result.get("people"));
		assertEquals("tot",result.get("run"));
	}
	
	@Test
	public void makeTranslationTest2() {
		String [] english = {"farm","flee","people","run"};
		String [] other = {"beep","bop","pop","tot"};
		Map<String,String> result = FinalExam.makeTranslation(english, other, false);
		assertEquals(4,result.size());
		assertEquals("farm",result.get("beep"));
		assertEquals("flee",result.get("bop"));
		assertEquals("people",result.get("pop"));
		assertEquals("run",result.get("tot"));
	}
	
	@Test
	public void makeTranslationTest3() {
		String [] english = {"farm","flee","people","run"};
		String [] other = {"beep","bop",null,"pop","tot"};
		Map<String,String> result = FinalExam.makeTranslation(english, other, true);
		assertEquals(3,result.size());
		assertEquals("beep",result.get("farm"));
		assertEquals("bop",result.get("flee"));
		assertNull(result.get("people"));
		assertEquals("pop",result.get("run"));
	}

	@Test
	public void makeTranslationTest4() {
		String [] english = {"farm","flee","people","run"};
		String [] other = {"beep","bop",null,"pop","tot"};
		Map<String,String> result = FinalExam.makeTranslation(english, other, false);
		assertEquals(4,result.size());
		assertEquals("farm",result.get("beep"));
		assertEquals("flee",result.get("bop"));
		assertEquals("people", result.get("pop"));
		assertEquals("run",result.get("tot"));
	}
	
	@Test
	public void makeTranslationTest5() {
		String [] english = {"farm","flee","people","run","something","done"};
		String [] other = {"beep","bop","pop","tot"};
		Map<String,String> result = FinalExam.makeTranslation(english, other, true);
		assertEquals(6,result.size());
		assertEquals("beep",result.get("farm"));
		assertEquals("bop",result.get("flee"));
		assertEquals("pop",result.get("people"));
		assertEquals("tot",result.get("run"));
		assertEquals("", result.get("something"));
		assertEquals("", result.get("done"));
	}
	
	@Test
	public void makeTranslationTest6() {
		String [] english = {"farm","flee","people","run"};
		String [] other = {"beep","bop","pop","tot", "blah","bloop"};
		Map<String,String> result = FinalExam.makeTranslation(english, other, true);
		assertEquals(4,result.size());
		assertEquals("beep",result.get("farm"));
		assertEquals("bop",result.get("flee"));
		assertEquals("pop",result.get("people"));
		assertEquals("tot",result.get("run"));
	}
	public void makeTranslationTest7() {
		String [] english = {};
		String [] other = {};
		Map<String,String> result = FinalExam.makeTranslation(english, other, true);
		assertEquals(0,result.size());

	}
	
	@Test
	public void translateTest1() {
		String phrase = "Run away fast";
		Map<String,String> trans = new HashMap<String,String>();
		trans.put("Run", "Boop");
		trans.put("fast", "blop");
		trans.put("away", "blah");
		String result = FinalExam.translate(phrase, trans);
		assertEquals("Boop blah blop",result);
	}
	
	@Test
	public void translateTest2() {
		String phrase = "Run away fast please";
		Map<String,String> trans = new HashMap<String,String>();
		trans.put("Run", "Boop");
		trans.put("fast", "blop");
		trans.put("away", "blah");
		String result = FinalExam.translate(phrase, trans);
		assertEquals("Boop blah blop <please>",result);
	}
	
	@Test
	public void translateTest3() {
		String phrase = "Run away really fast";
		Map<String,String> trans = new HashMap<String,String>();
		trans.put("Run", "Boop");
		trans.put("fast", "blop");
		trans.put("away", "blah");
		String result = FinalExam.translate(phrase, trans);
		assertEquals("Boop blah <really> blop",result);
	}
	
	@Test
	public void translateTest4() {
		String phrase = "Run    away fast";
		Map<String,String> trans = new HashMap<String,String>();
		trans.put("Run", "Boop");
		trans.put("fast", "blop");
		trans.put("away", "blah");
		String result = FinalExam.translate(phrase, trans);
		assertEquals("Boop blah blop",result);
	}
	
	@Test
	public void translateTest5() {
		String phrase = "";
		Map<String,String> trans = new HashMap<String,String>();
		trans.put("Run", "Boop");
		trans.put("fast", "blop");
		trans.put("away", "blah");
		String result = FinalExam.translate(phrase, trans);
		assertEquals("",result);
	}
	
	@Test
	public void translateTest6() {
		String phrase = "Please Run away fast";
		Map<String,String> trans = new HashMap<String,String>();
		trans.put("Run", "Boop");
		trans.put("fast", "blop");
		trans.put("away", "blah");
		String result = FinalExam.translate(phrase, trans);
		assertEquals("<Please> Boop blah blop",result);
	}
	
	@Test
	public void sortThroughTest1() {
		List<String> list = new ArrayList<String>();
		list.add("robby");
		list.add("bobby");
		list.add("snobby");
		list.add("nanny");
		list.add("parallel");
		Map<String, List<String>> result = FinalExam.sortThrough(list);
		Map<String, List<String>> answer = new HashMap<String,List<String>>();
		ArrayList<String> bb = new ArrayList<String>();
		bb.add("robby");
		bb.add("bobby");
		bb.add("snobby");
		
		answer.put("bb", bb);
		ArrayList<String> nn = new ArrayList<String>();
		nn.add("nanny");
		answer.put("nn", nn);
		ArrayList<String> ll = new ArrayList<String>();
		ll.add("parallel");
		answer.put("ll", ll);
		assertEquals(answer, result);
	}

	@Test
	public void sortThroughTest2() {
		List<String> list = new ArrayList<String>();
		list.add("robby");
		list.add("bobby");
		list.add("snobby");
		list.add("nanny");
		list.add("parallel");
		list.add("no double");
		Map<String, List<String>> result = FinalExam.sortThrough(list);
		Map<String, List<String>> answer = new HashMap<String,List<String>>();
		ArrayList<String> bb = new ArrayList<String>();
		bb.add("robby");
		bb.add("bobby");
		bb.add("snobby");
		
		answer.put("bb", bb);
		ArrayList<String> nn = new ArrayList<String>();
		nn.add("nanny");
		answer.put("nn", nn);
		ArrayList<String> ll = new ArrayList<String>();
		ll.add("parallel");
		answer.put("ll", ll);
		assertEquals(answer, result);
	}
	
	@Test
	public void sortThroughTest3() {
		List<String> list = new ArrayList<String>();
		list.add("robby");
		list.add("bobby");
		list.add("snobby");
		list.add("nanny");
		list.add("parallel");
		list.add("lollypopper");
		Map<String, List<String>> result = FinalExam.sortThrough(list);
		Map<String, List<String>> answer = new HashMap<String,List<String>>();
		ArrayList<String> bb = new ArrayList<String>();
		bb.add("robby");
		bb.add("bobby");
		bb.add("snobby");
		
		answer.put("bb", bb);
		ArrayList<String> nn = new ArrayList<String>();
		nn.add("nanny");
		answer.put("nn", nn);
		ArrayList<String> ll = new ArrayList<String>();
		ll.add("parallel");
		ll.add("lollypopper");
		answer.put("ll", ll);
		ArrayList<String> pp = new ArrayList<String>();
		pp.add("lollypopper");
		answer.put("pp", pp);
		assertEquals(answer, result);
		
	}
}
