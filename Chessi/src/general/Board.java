package general;

import java.util.Vector;

public class Board {
	private Piece[][] board = new Piecep[8][8];
	private Vector <Piece> pieces = new Vector <Piece> pieces(32);
	
	public Board() {
		initBoard();
	}
	
	public String coordinates(int x, int y) {
		int number = 0;
		char letter = 'z';
		String notation;
		
		switch(x) {
		case 0:
			number = 8;
			break;
		case 1:
			number=7;
			break;
		case 2:
			number=6;
			break;
		case 3:
			number=5;
			break;
		case 4:
			number=4;
			break;
		case 5:
			number=3;
			break;
		case 6:
			number=2;
			break;
		case 7:
			number=1;
			break;
		default:
			break;
		}
		
		
		switch(y) {
		case 0:
			letter='a';
			break;
		case 1:
			letter='b';
			break;
		case 2:
			letter='c';
			break;
		case 3:
			letter='d';
			break;
		case 4:
			letter='e';
			break;
		case 5:
			letter='f';
			break;
		case 6:
			letter='g';
			break;
		case 7:
			letter='h';
			break;
		default:
			break;
		}
		
		notation = letter + Integer.toString(number);
		
	}
	
	public Index notationToIndex(String notation) {
		char letter;
		char number;
		int x=0, y=0;
		letter = notation.charAt(0); //save 1st char from notation as a char
		number = notation.charAt(1); //save 2nd char from notation as an integer
		
		switch(letter) {
		case 'a':
			y=0;
			break;
		case 'b':
			y=1;
			break;
		case 'c':
			y=2;
			break;
		case 'd':
			y=3;
			break;
		case 'e':
			y=4;
			break;
		case 'f':
			y=5;
			break;
		case 'g':
			y=6;
			break;
		case 'h':
			y=7;
			break;
		default:
			break;
		}
		
		switch(number) {
		case '1':
			x=7;
			break;
		case '2':
			x=6;
			break;
		case '3':
			x=5;
			break;
		case '4':
			x=4;
			break;
		case '5':
			x=3;
			break;
		case '6':
			x=2;
			break;
		case '7':
			x=1;
			break;
		case '8':
			x=0;
			break;
		default:
			break;
		}
		
		Index index = new Index(x, y); 
		return index;
	}
	
	
}
