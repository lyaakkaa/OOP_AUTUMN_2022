package Bonus;

import java.util.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word w1 = new Word("сat", PartOfSpeech.ADJECTIVE);
		Word w2 = new Word("dat",  PartOfSpeech.ADJECTIVE);
		Word w3 = new Word("rat",  PartOfSpeech.ADJECTIVE);
		System.out.print(w1.distance(w2));
//		ArrayList<Word> words = new ArrayList<>();
//		words.add(w2);
//		words.add(w3);
//		
//		System.out.print(w1.findMostSimilar(words).getWord());

		
		

	}

}
