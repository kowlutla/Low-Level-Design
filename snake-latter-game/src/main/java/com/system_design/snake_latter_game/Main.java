package com.system_design.snake_latter_game;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Player> players = new ArrayList<>();
		players.add(new Player("Kowlutla"));
		players.add(new Player("Sudeepthi"));
		players.add(new Player("Deekshita"));
		players.add(new Player("Lokanksha"));
		players.add(new Player("Yakshith"));
		Game game = new Game(players, new Board());
		game.playGame();
	}
}
