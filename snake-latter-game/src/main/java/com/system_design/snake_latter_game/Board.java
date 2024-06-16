package com.system_design.snake_latter_game;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private Map<Integer, Integer> ladders;
	private Map<Integer, Integer> snakes;

	public Board() {
		ladders = new HashMap<>();
		snakes = new HashMap<>();

		ladders.put(1, 38);
		ladders.put(4, 14);
		ladders.put(9, 31);
		ladders.put(21, 42);
		ladders.put(28, 84);
		ladders.put(36, 44);
		ladders.put(51, 67);
		ladders.put(71, 91);
		ladders.put(80, 96);

		snakes.put(16, 6);
//		snakes.put(47, 26);
		snakes.put(49, 11);
		snakes.put(56, 53);
//		snakes.put(62, 19);
		snakes.put(64, 60);
		snakes.put(87, 24);
//		snakes.put(93, 73);
		snakes.put(95, 75);
		snakes.put(98, 78);
	}

	public Board(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
		this.ladders = ladders;
		this.snakes = snakes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}
}
