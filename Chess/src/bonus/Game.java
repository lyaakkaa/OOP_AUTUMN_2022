package bonus;

public class Game {
	private Cell[][] board;
	private Piece[] eatenWhite;
	private Piece[] eatenBlack;
	private int eatenWhiteCount;
	private int eatenBlackCount;
	private Player black;
	private Player white;
	private Player turn;
	private boolean blackInCheck;
	private boolean whiteInCheck;
	
	public Game() {
		board = new Cell[8][8];
		black = new Player(Color.BLACK);
		white = new Player(Color.WHITE);
		black.setEnemy(white);
		white.setEnemy(black);
		blackInCheck = false;
		whiteInCheck = false;
		eatenWhite = new ChessPiece[16];
		eatenBlack = new ChessPiece[16];
		turn = white;
		
		for (int i = 0; i < 8 ; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Cell(i, j);
			}
		}
	}
	
	private void placePiece(Player p) {
		int row = p.getColor() == Color.WHITE ? 7 : 0;
		Piece[] pieces = new Piece[]
				{ new Rook(), new Knight(), new Bishop(), new Queen(), new King(), new Bishop(), new Knight(), new Rook()};
	}

}
