package Bonus;

import java.util.*;

public class Neighbors {
	
   
	public static Map<String, char[]> map; 
	
	static{
		map = new TreeMap<String,char[]>(); 
		map.put("q", "aw".toCharArray());
	    map.put("w", "esaq".toCharArray());
	    map.put("e", "rdsw".toCharArray());
	    map.put("t", "ygfr".toCharArray());
	    map.put("y", "uhgt".toCharArray());
	    map.put("u", "ijhy".toCharArray());
	    map.put("i", "okju".toCharArray());
	    map.put("o", "plki".toCharArray());
	    map.put("p", "lo".toCharArray());
	    
	    map.put("a", "qwsz".toCharArray());
	    map.put("s", "wedxza".toCharArray());
	    map.put("d", "erfcxs".toCharArray());
	    map.put("f", "rtgvcd".toCharArray());
	    map.put("g", "tyhbvf".toCharArray());
	    map.put("h", "yujnbg".toCharArray());
	    map.put("j", "uikmnh".toCharArray());
	    map.put("l", "opk".toCharArray());
	    
	    map.put("z", "asx".toCharArray());
	    map.put("x", "sdcz".toCharArray());
	    map.put("c", "dfvx".toCharArray());
	    map.put("v", "fgbc".toCharArray());
	    map.put("b", "ghnv".toCharArray());
	    map.put("n", "hjmb".toCharArray());
	    map.put("m", "jkn".toCharArray());
	}
	
	public static char[] getValue(String a) {
		return map.get(a);
	}
	
	
	
	
}
