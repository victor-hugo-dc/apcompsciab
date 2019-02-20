package edu.fcps.ab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FinalExam {

	/**
	 * returns the number of times str appears in the array strings. 
	 * str may be a substring of one of the strings. It also may appear 
	 * more than once in each string
	 * i.e. countSubStrings({"bobby","Bobby","robbery","Bobby committed robbery"},"bb")
	 * would return 5
	 * @param strings array of strings to search through, array may not be full
	 * @param str the substring to look for
	 * @return the number of times that str appears in the array
	 */
	public static int countSubStrings(String [] strings, String str) {
		int count = 0;
		for(String s : strings) {
			if(s != null && s.contains(str))
				for(int i = 0; i < s.length() - 1; i++) {
					if(s.substring(i, i + 2).equals(str))
						count++;
				}
		}
		return count;
	}
	
	/**
	 * returns a mapping of english to other, unless direction is false, 
	 * then the mapping should be other to english
	 * @param english array of english words, may not be full
	 * @param other array of other language's words, may not be full. Not guaranteed 
	 * 			to contain a translation of english words.
	 * @param direction indicates english to other or other to english
	 * @return Mapping that is the translation
	 */
	public static Map<String,String> makeTranslation(String [] english, String[] other, boolean direction){
		HashMap<String, String> map = new HashMap<String, String>();
		if(direction) {
			ArrayList<String> English = new ArrayList<String>();
			for(String s : english)
				if(s != null)
					English.add(s);
			Iterator<String> it = English.iterator();
			int i = 0;
			while(it.hasNext()) {
				if(i < other.length && other[i] != null)
					map.put(it.next(), other[i]);
				else
					it.next();
				i++;
			}
			if(english.length > other.length) {
				for(i = other.length; i < english.length; i++)
					map.put(english[i], "");
			}
		} else {
			ArrayList<String> Other = new ArrayList<String>();
			for(String s : other)
				if(s != null)
					Other.add(s);
			Iterator<String> it = Other.iterator();
			int i = 0;
			while(it.hasNext()) {
				if(i < english.length && english[i] != null)
					map.put(it.next(), english[i]);
				else
					it.next();
				i++;
			}
		}
		return map;
	}
	
	/**
	 * returns a translated phrase based on the translator map given. 
	 * Please note that not all words in the phrase are necessarily translatable.
	 * In these cases, insert the original word inside "<>"
	 * @param phrase  phrase to translate
	 * @param translator mapping of translations
	 * @return the phrase having been translated
	 */
	public static String translate(String phrase, Map<String, String> translator) {
		if(phrase == "")
			return "";	
		ArrayList<String> split = new ArrayList<String>();
		for(String s : phrase.split(" ")) {
			if(s.length() > 0)
				split.add(s);
		}
		String ret = "";
		while(!split.isEmpty()) {
			int len = split.size();
			for(Entry<String, String> entry : translator.entrySet()) {
				if(split.size() > 0 && entry.getKey().equals(split.get(0))) {
					ret += entry.getValue();
					split.remove(0);
					if(split.size() != 0)
						ret += " ";
				}
			}
			if(split.size() == len) {
				ret += "<" + split.remove(0) + ">";
				if(split.size() != 0)
					ret += " ";
			}
		}
		return ret;
	}
	
	/**
	 * Returns a mapping of double letters mapped to the words that they are located in
	 * Please note that some words may not contain double letters and some may contain
	 * more than one pair. In the case of more than one pair, the word should appear for both
	 * double letters
	 * @param list the words being sorted
	 * @return the mapping of double letters to list of words containing them
	 */
	public static Map<String, List<String>> sortThrough(List<String> list){
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		ArrayList<String> al;
		for(String s : list) {
			al = new ArrayList<String>();
			for(int i = 0; i < s.length()-1; i++) {
				if(s.charAt(i) == s.charAt(i + 1))
					al.add(s.substring(i, i+2));
			}
			if(!al.isEmpty()) {
				for(String pair : al)
					if(map.containsKey(pair)) {
						ArrayList<String> temp = (ArrayList<String>) map.get(pair);
						temp.add(s);
						map.replace(pair, temp);
					} else {
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(s);
						map.put(pair, temp);
					}		
				}
			}
		return map;
	}
}