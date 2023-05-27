package Bonus;

import java.util.*;
import java.util.Map.Entry;

public class Word {
	
	private PartOfSpeech partspeech;
	private String word;
	
	public static Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();

	
	
	static{
		map.put('q', Arrays.asList('a', 'w'));
	    map.put('w',Arrays.asList('e', 's', 'a', 'q'));
	    map.put('e',Arrays.asList('r', 'd', 's', 'w'));
	    map.put('t',Arrays.asList('y', 'g', 'f', 'r'));
	    map.put('y',Arrays.asList('u', 'h', 'g', 't'));
	    map.put('u',Arrays.asList('i', 'j', 'h', 'y'));
	    map.put('i',Arrays.asList('o', 'k', 'j', 'u'));
	    map.put('o',Arrays.asList('p', 'l', 'k', 'i'));
	    map.put('p',Arrays.asList('o', 'l'));
	    
	    map.put('a',Arrays.asList('q', 'w', 's', 'z'));
	    map.put('s',Arrays.asList('e', 'w', 'd', 'x', 'z', 'a'));
	    map.put('d',Arrays.asList('e', 'r', 'f', 'c', 'x', 's'));
	    map.put('f',Arrays.asList('r', 't', 'g', 'v', 'c', 'd'));
	    map.put('g',Arrays.asList('t', 'y', 'h', 'b', 'v', 'd'));
	    map.put('h',Arrays.asList('y', 'u', 'j', 'n', 'b', 'g'));
	    map.put('j',Arrays.asList('u', 'i', 'k', 'm', 'n', 'h'));
	    map.put('l',Arrays.asList('o', 'p', 'k'));
	    
	    map.put('z',Arrays.asList('a', 's', 'x'));
	    map.put('x',Arrays.asList('s', 'd', 'c', 'z'));
	    map.put('c',Arrays.asList('d', 'f', 'v', 'x'));
	    map.put('v',Arrays.asList('f', 'g', 'b', 'c'));
	    map.put('b',Arrays.asList('g', 'h', 'n', 'v'));
	    map.put('n',Arrays.asList('h', 'j', 'm', 'b'));
	    map.put('m',Arrays.asList('j', 'k', 'n'));
	
	}
	
	public static boolean isNeighbour(char key1, char key2) {
	    List<Character> list = map.get(key1);
	    return list != null && list.contains(key2);
	}
	
//	public static boolean isNeighbour(char key1, char key2) {
//	    switch (key1) {
//	        case 'q':
//	            return key2 == 'w' || key2 == 's' || key2 == 'a';
//	        case 'w':
//	            return key2 == 'q' || key2 == 'e' || key2 == 's' || key2 == 'a';
//	        case 'e':
//	            return  key2 == 'w' || key2 == 'r' || key2 == 's' || key2 == 'd';
//	        case 'r':
//	            return key2 == 'e' || key2 == 't' || key2 == 'd'|| key2 == 'f';
//	        case 't':
//	            return key2 == 'r' || key2 == 'z' || key2 == 'f' || key2 == 'g';
//	        case 'z':
//	            return key2 == 't' || key2 == 'u' || key2 == 'g' || key2 == 'h';
//	        case 'u':
//	            return  key2 == 'z' || key2 == 'i' || key2 == 'h' || key2 == 'j';
//	        case 'i':
//	            return  key2 == 'u' || key2 == 'o' || key2 == 'j' || key2 == 'k';
//	        case 'o':
//	            return key2 == 'i' || key2 == 'p' || key2 == 'k' || key2 == 'l';
//	        case 'p':
//	            return key2 == 'o' || key2 == 'l';
//	        case 'a':
//	            return key2 == 'q' || key2 == 'w' || key2 == 's' || key2 == 'y';
//	        case 's':
//	            return key2 == 'w' || key2 == 'e' || key2 == 'a' || key2 == 'd' || key2 == 'y' || key2 == 'x';
//	        case 'd':
//	            return key2 == 'e' || key2 == 'r' || key2 == 's' || key2 == 'f' || key2 == 'x' || key2 == 'c';
//	        case 'f':
//	            return key2 == 'r' || key2 == 't' || key2 == 'd' || key2 == 'g' || key2 == 'c' || key2 == 'v';
//	        case 'g':
//	            return key2 == 't' || key2 == 'z' || key2 == 'f' || key2 == 'h' || key2 == 'v' || key2 == 'b';
//	        case 'h':
//	            return key2 == 'z' || key2 == 'u' || key2 == 'g' || key2 == 'j' || key2 == 'b' || key2 == 'n';
//	        case 'j':
//	            return key2 == 'u' || key2 == 'i' || key2 == 'h' || key2 == 'k' || key2 == 'n' || key2 == 'm';
//	        case 'k':
//	            return key2 == 'i' || key2 == 'o' || key2 == 'j' || key2 == 'l' || key2 == 'm';
//	        case 'l':
//	            return key2 == 'o' || key2 == 'p' || key2 == 'k';
//	     
//	        case 'y':
//	            return key2 == 'a' || key2 == 's'  || key2 == 'x';
//	        case 'x':
//	            return key2 == 's' || key2 == 'd' || key2 == 'y' || key2 == 'c';
//	        case 'c':
//	            return key2 == 'd' || key2 == 'f' || key2 == 'x' || key2 == 'v';
//	        case 'v':
//	            return key2 == 'f' || key2 == 'g' || key2 == 'c' || key2 == 'b';
//	        case 'b':
//	            return key2 == 'g' || key2 == 'h' || key2 == 'v' || key2 == 'n';
//	        case 'n':
//	            return key2 == 'h' || key2 == 'j' || key2 == 'b' || key2 == 'm';
//	        case 'm':
//	            return key2 == 'j' || key2 == 'k' || key2 == 'n' || key2 == '?';
//	        default:
//	            return false;
//	    }
//	}
	

	Word(String word, PartOfSpeech partspeech){
		this.word = word;
		this.partspeech = partspeech;
	}
	
//	public static boolean checkIsNeighbor(String s, char b) {
//		char[] list = map.get(s); 
//	    return list != null && 
//		
////		for(int i = 0; i <  Word.map.get(s).length; i++) {
////			if(Word.map.get(s)[i] == b) {
////				return true;
////			}
////		}
////		return false;
//	}
	
	public double distance(Word b) {
		return distance(this,b);
	}
	static double distance(Word a, Word b) {
		char[] s = a.word.toCharArray();
		char[] t = b.word.toCharArray();
		
		
		double [][] dp = new double[s.length + 1][t.length + 1];
		
		for(int i = 1; i < s.length + 1; i++) {
			dp[i][0] = i;
		}
		for(int j = 1; j < t.length + 1; j++) {
			dp[0][j] = j;
		}
		
		for(int i = 1; i < s.length + 1; i++) {
			for(int j = 1; j < t.length + 1; j++) {
				double rep, del, ins;
				if(s[i - 1] != t[j - 1]) {
					
					if(Word.isNeighbour(s[i-1], t[j-1])) {
						rep = dp[i - 1][j - 1] + 0.5;
						del = dp[i - 1][j] + 1;
						ins = dp[i][j - 1] + 1;
					}
					else {
						rep = dp[i - 1][j - 1] + 2;
						del = dp[i - 1][j] + 1;
						ins = dp[i][j - 1] + 1;
					}	
					dp[i][j] = Math.min(rep, Math.min(del, ins));
				}
				
				else {
					rep = dp[i - 1][j - 1];
					del = dp[i - 1][j] + 1;
					ins = dp[i][j - 1] + 1;
					dp[i][j] = Math.min(rep, Math.min(del, ins));
				}
			}
			
		}
		return dp[s.length][t.length];
	}
	
	static  int distancee(Word a, Word b) {
		char[] s = a.word.toCharArray();
		char[] t = b.word.toCharArray();
		
		
		
		int [][] dp = new int[s.length + 1][t.length + 1];
		
		for(int i = 1; i < s.length + 1; i++) {
			dp[i][0] = i;
		}
		for(int j = 1; j < t.length + 1; j++) {
			dp[0][j] = j;
		}
		
		for(int i = 1; i < s.length + 1; i++) {
			for(int j = 1; j < t.length + 1; j++) {
				if(s[i - 1] != t[j - 1]) {
					int rep = dp[i - 1][j - 1] + 2;
					int del = dp[i - 1][j] + 1;
					int ins = dp[i][j - 1] + 1;
					dp[i][j] = Math.min(rep, Math.min(del, ins));
				}
				else {
					int rep = dp[i - 1][j - 1];
					int del = dp[i - 1][j] + 1;
					int ins = dp[i][j - 1] + 1;
					dp[i][j] = Math.min(rep, Math.min(del, ins));
				}
			}
			
		}
		return dp[s.length][t.length];
		
	}
	
	public boolean similar(Word b) {
		return similar(this,b);
	}
	static boolean similar(Word a, Word b) {
		if(a.partspeech == b.partspeech) {
			if(a.distance(b) <= 2) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public Word findMostSimilar(ArrayList<Word> words) {
		double mini = 9999;
		Word w = null;
		for(int i = 0; i < words.size(); i++) {
			if(distancee(this, words.get(i)) < mini){
				mini = distancee(this, words.get(i));
				w = words.get(i);
			}
		}
		return w;
		
	}
	
	public String getWord() {
		return this.word;
	}
}
