package com.system_design.snake_latter_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

	private List<Player> players;
	private Board board;
	private int numberOfPlayers;
	private List<Player> results;

	public Game(List<Player> players, Board board) {
		this.players = players;
		this.board = board;
		this.numberOfPlayers = players.size();
		this.results = new ArrayList<>();
	}

	public void playGame() {
		int currentPlayer = 0;
		Random random = new Random();
		while (players.size() > 1) {
			Player player = players.get((currentPlayer) % numberOfPlayers);
			System.out.println(player.getName() + " is rolling the dice");
			int dice = random.nextInt(6) + 1;
			System.out.println("Dice value is : " + dice);
			makeMove(player, dice);
			displayBoard(players);
			if (isPlayerWin(player)) {
				System.out.println("\nWINNER IS " + player.getName());
				results.add(player);
				players.remove(currentPlayer % numberOfPlayers);
				currentPlayer--;
				numberOfPlayers--;
			}
			currentPlayer++;
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}

		results.add(players.get(0));
		displayResults();
	}

	private void displayResults() {
		System.out.println("*** RESULTS ***");
		for (int i = 0; i < results.size(); i++) {
			Player player = results.get(i);
			System.out.println("Rank " + (i + 1) + ": " + player.getName() + "\t" + player.getPosition());
		}
		System.out.println();
		System.out.println(results.get(results.size() - 1).getName() + " IS LOOOOOSER........!! :(");
	}

	private void displayBoard(List<Player> players) {

		System.out.println("**** CURRENT PLAYER STANDINGS ****");
		for (Player player : players) {
			System.out.println(player.getName() + "\t" + player.getPosition());
		}
		System.out.println("**********************************");
	}

	private boolean isPlayerWin(Player player) {
		return player.getPosition() == 100;
	}

	private void makeMove(Player player, int dice) {

		int initialPosition = player.getPosition();
		int newPosition = player.getPosition() + dice;
		if (newPosition > 100) {
			System.out.println("Hmmm...!" + player.getName() + " You don't enough grids to move");
			return;
		}
		System.out.println(player.getName() + " You moved from " + initialPosition + " to " + newPosition);
		if (board.getSnakes().containsKey(newPosition)) {
			newPosition = board.getSnakes().get(newPosition);
			System.out.println("OOPS..! Snake catched you and slipped to " + newPosition + " :(");
		} else if (board.getLadders().containsKey(newPosition)) {
			newPosition = board.getLadders().get(newPosition);
			System.out.println("HOHO..! You got ladder and you climbs to " + newPosition + " :)");
		}
		player.setPosition(newPosition);
	}

}
