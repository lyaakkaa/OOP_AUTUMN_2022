package chess;

import view.CmdView;
import controller.Game;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {

		Game game = new Game();
		
		CmdView cmdView = new CmdView(game);
		
		cmdView.startGame();
		
	}

}