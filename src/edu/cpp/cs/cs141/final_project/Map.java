/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Final Project
 *
 * This program is a text-based game which consists of a spy trapped in a dungeon grid of 9x9 squares.
 *  There are 9 rooms in the dungeon, one of which contain a Briefcase that contains the key to exit the dungeon.
 *  There are 6 Ninjas which randomly move around the dungeon that can kill the Spy if adjacent to the Spy.
 *  Also, there are 3 Power-ups which randomly spawn across the dungeon at the start of the game which can aid the
 *  Spy in finding the Briefcase, surviving the Ninjas, or killing the Ninjas.
 *
 * Team Wired
 *   Brandon Gastelo, Daniel Le, Shiying Li, Austin Morris, Anna Olshanskaya, Johnson Ton
 */

package edu.cpp.cs.cs141.final_project;

/**
 * This class
 * @author
 */

import java.lang.Math;
public class Map{
	public static boolean debugMode = false;
	private Tile[][] tiles;
	private int spyX, spyY;
	
	public Map(){
		tiles = new Tile[9][9];
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				tiles[i][j] = new Tile(i,j);
		}
	}
	public static boolean isDebug(){
		return debugMode;
	}
  	public void set(int x, int y, GamePiece g){
  		if(g instanceof Spy)
  		{
  			spyX = x;
  			spyY = y;
  		}
  		tiles[x][y].set(g);
  	}
  	public void set(int x, int y, PowerUp p){
  		tiles[x][y].set(p);
  	}
  	public char image(int x, int y){
  		if(!debugMode)
  		{
  			if(tiles[x][y].isNinja() || tiles[x][y].isPowerUp())
  			{
  				if((Math.abs(x-spyX)<=2 && y==spyY) || (x==spyX && Math.abs(y-spyY)<=2))
  					return tiles[x][y].image();
  				else
  					return ' ';
  			}
  		}
  		return tiles[x][y].image();
  	}
  	public boolean noActiveAgent(int x, int y){
  		return tiles[x][y].noActiveAgent();
  	}
  	public boolean noPowerUp(int x, int y){
  		return tiles[x][y].noPowerUp();
  	}
  	public boolean isRoom(int x, int y){
  		return tiles[x][y].isRoom();
  	}
  	public boolean isSpy(int x, int y){
  		return tiles[x][y].isSpy();
  	}
  	public boolean isNinja(int x, int y){
  		return tiles[x][y].isNinja();
  	}
  	public void clear(){
  		tiles = new Tile[9][9];
  	}
	public void toggleMode() {
		debugMode = !debugMode;
	}
}