package bonus;

public class Boardd {
	  public static char[][] board = new char[8][8];
	  
	  public void fillBoard() {
	    for(int i = 0; i < 8; i++) {
	      for(int j = 0; j < 8; j++) {
	        if((i + j) % 2 == 0) {
	          board[i][j] = '▭';
	        }
	        else {
		       board[i][j] = '▬';
		    }
	        if(i == 1) {
	            board[i][j] = '♙';
	        }
	        if(i == 6) {
	            board[i][j] = '♙';
	        }
	        
//	        if(i == 2) {
//	          board[i][j] = '♙';
//	        }
//	        if(i == 7) {
//	          board[i][j] = '♙';
//	        }
	      }
	    }
	    board[0][0] = '♜';
	    board[0][1] = '♞';
	    board[0][2] = '♝';
	    board[0][3] = '♛';
	    board[0][4] = '♚';
	    board[0][5] = '♝';
	    board[0][6] = '♞';
	    board[0][7] = '♜';
	    
	    board[7][0] = '♖';
	    board[7][1] = '♘';
	    board[7][2] = '♗';
	    board[7][3] = '♕';
	    board[7][4] = '♔';
	    board[7][5] = '♗';
	    board[7][6] = '♘';
	    board[7][7] = '♖';

	  }
	  
	  public String toString() {
	    String s = "";
	    for(int i = 0; i < 8; i++) {
	      for(int j = 0; j < 8; j++) {
	        if(board[i][j] == '■' || board[i][j] == '□') {
	          s += (Character.toString(board[i][j]));
	        }
	        else s += (Character.toString(board[i][j]) + " ").strip();
	      }
	      s += "\n";
	    }
	    return s;
	  }

	}