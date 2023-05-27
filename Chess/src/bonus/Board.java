package bonus;

//Сделайте классную доску и какой-нибудь 
//тестовый класс, чтобы полностью имитировать
//игру в шахматы. Подумайте о том,
//как вы будете сохранять текущее состояние игры, 
//принимать ходы
//от пользователя, рисовать доску на консоли, проверять наличие незаконных ходов и т.д.
public class Board {
  public static char[][] board = new char[9][9];
  
  public void fillBoard() {
    for(int i = 1; i <= 8; i++) {
      for(int j = 1; j <= 8; j++) {
        if(i == 5 && j == 5) {
          board[i][j] = '♛';
        }
        else if((i + j) % 2 == 0) {
          board[i][j] = '▭';
        }
        else {
          board[i][j] = '▬';
        }
        if(i == 2) {
          board[i][j] = '♙';
        }
        if(i == 7) {
          board[i][j] = '♙';
        }
      }
    }
    board[1][1] = '♜';
    board[1][2] = '♞';
    board[1][3] = '♝';
    board[1][4] = '♛';
    board[1][5] = '♚';
    board[1][6] = '♝';
    board[1][7] = '♞';
    board[1][8] = '♜';
    
    board[8][1] = '♖';
    board[8][2] = '♘';
    board[8][3] = '♗';
    board[8][4] = '♕';
    board[8][5] = '♔';
    board[8][6] = '♗';
    board[8][7] = '♘';
    board[8][8] = '♖';

  }
  
  public String toString() {
    String s = "";
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
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