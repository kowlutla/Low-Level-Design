package com.system_design.snake_latter_game;

public class Player {

	private static int idCounter = 0;
	private int id;
	private String name;
	private int position;

	public Player(String name) {
		this.id = ++idCounter;
		this.name = name;
		this.position = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name);
		sb.append("\tCurrent Position: " + position);
		return sb.toString();
	}
}
