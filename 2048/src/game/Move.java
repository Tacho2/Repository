package game;

import java.util.ArrayList;
import java.util.Collections;

public class Move {

	public static Tile[][] up(Tile[][] array)
	{		
		Tile[] col;
		Tile[][] oldarr = new Tile[array.length][array[0].length];
		
		for(int i = 0; i < array.length; i++)
			for(int j = 0; j < array[0].length; j++)
				oldarr[i][j] = array[i][j];
		
		//shifting
		for(int j = 0; j < array[0].length; j++) {
			
			col = new Tile[array.length];
			
			for(int i = 0; i < col.length; i++) {
				col[i] = array[j][i];
			}
		
			col = shiftUp(col);
			
			for(int i = 0; i < col.length; i++)
				array[j][i] = col[i];
		}
		
		if(testEqualityOf(oldarr, array))
			return array;
		
		return addNewTile(array);
	}
	
	public static Tile[][] down(Tile[][] array)
	{
		Tile[] col;
		Tile[][] oldarr = new Tile[array.length][array[0].length];
		
		for(int i = 0; i < array.length; i++)
			for(int j = 0; j < array[0].length; j++)
				oldarr[i][j] = array[i][j];
		
		//shifting
		for(int j = 0; j < array[0].length; j++) {  //for every column in the gameboard
			
			col = new Tile[array.length];			//make a new array out of it
			
			for(int i = 0; i < col.length; i++) {
				col[i] = array[j][i];
			}
		
			col = shiftDown(col);						//shift it down
			
			for(int i = 0; i < col.length; i++) 	//replace actual matrix with values
				array[j][i] = col[i];
		}
		
		if(testEqualityOf(oldarr, array))
			return array;
		
		return addNewTile(array);
	}

	public static Tile[][] left(Tile[][] array)
	{
		Tile[] col;
		Tile[][] oldarr = new Tile[array.length][array[0].length];
		
		for(int i = 0; i < array.length; i++)
			for(int j = 0; j < array[0].length; j++)
				oldarr[i][j] = array[i][j];
		
		for(int j = 0; j < array[0].length; j++) {  //for every column in the gameboard
			
			col = new Tile[array.length];			//make a new array out of it
			
			for(int i = 0; i < col.length; i++) {
				col[i] = array[i][j];
			}
		
			col = shiftUp(col);						//shift it left
			
			for(int i = 0; i < col.length; i++) 	//replace actual matrix with values
				array[i][j] = col[i];
		}
		
		if(testEqualityOf(oldarr, array))
			return array;
		
		return addNewTile(array);
	}
	
	public static Tile[][] right(Tile[][] array)
	{
		Tile[] col;
		Tile[][] oldarr = new Tile[array.length][array[0].length];
		
		for(int i = 0; i < array.length; i++)
			for(int j = 0; j < array[0].length; j++)
				oldarr[i][j] = array[i][j];
		
		for(int j = 0; j < array[0].length; j++) {  //for every column in the gameboard
			
			col = new Tile[array.length];			//make a new array out of it
			
			for(int i = 0; i < col.length; i++) {
				col[i] = array[i][j];
			}
		
			col = shiftDown(col);						//shift it left
			
			for(int i = 0; i < col.length; i++) 	//replace actual matrix with values
				array[i][j] = col[i];
		}
		
		if(testEqualityOf(oldarr, array))
			return array;
		
		return addNewTile(array);
	}
	
	public static Tile[] shiftUp(Tile[] array) 
	{
		ArrayList<Tile> arr = new ArrayList<Tile>();
		
		//turn into array list
		for(Tile t: array) {
			arr.add(t);
		}
		
		//remove empty tiles from beginning
		for(int i = 0; i < arr.size(); i++) {
			if(!arr.get(i).getStatus())
			{
				arr.remove(i);
				i--;
			}
		}
		
		//fill the end with empty tiles
		for(int i = arr.size(); i < array.length ; i++) {
			arr.add(new EmptyTile());
		}
		
		//combine tiles
		for(int i = 0; i < arr.size() - 1; i++) {
			if(arr.get(i).getValue() == arr.get(i+1).getValue() && arr.get(i).getValue() != 0)
			{
				arr.remove(i+1);
				arr.add(new EmptyTile());
				arr.set(i, new FilledTile(arr.get(i).getValue() + 1));
			}	
		}
		
		//turn into array
		Tile[] newArr = new Tile[array.length];
		for(int i = 0; i < arr.size(); i++) {
			newArr[i] = arr.get(i);
		}
		
		return newArr;
	}
	
	public static Tile[] shiftDown(Tile[] array) 
	{
		ArrayList<Tile> arr = new ArrayList<Tile>();
		
		//turn into array list
		for(Tile t: array) {
			arr.add(t);
		}
		
		//reverse list
		Collections.reverse(arr);
		
		//remove empty tiles from beginning
		for(int i = 0; i < arr.size(); i++) {
			if(!arr.get(i).getStatus())
			{
				arr.remove(i);
				i--;
			}
		}
		
		//fill the end with empty tiles
		for(int i = arr.size(); i < array.length ; i++) {
			arr.add(new EmptyTile());
		}
		
		//combine tiles
		for(int i = 0; i < arr.size() - 1; i++) {
			if(arr.get(i).getValue() == arr.get(i+1).getValue() && arr.get(i).getValue() != 0)
			{
				arr.remove(i+1);
				arr.add(new EmptyTile());
				arr.set(i, new FilledTile(arr.get(i).getValue() + 1));
			}	
		}
		
		//flip list back
		Collections.reverse(arr);
		
		//turn into array
		Tile[] newArr = new Tile[array.length];
		for(int i = 0; i < arr.size(); i++) {
			newArr[i] = arr.get(i);
		}
		
		return newArr;
	}

	public static Tile[][] addNewTile(Tile[][] gameboard) {
		boolean started = false;
		
		while(!started) {
			int x = (int)(Math.random()*4);
			int y = (int)(Math.random()*4);
			int f = (int)(Math.random()*2) + 1;
			
			if(!gameboard[x][y].getStatus()) {
				gameboard[x][y] = new FilledTile(f);
				started = true;
			}
		}
		
		return gameboard;
	}
	
	public static void print(Tile[][] array) {
		for(int k = 0; k < array.length; k++)
			for(int i = 0; i < array[0].length; i++)
			{
				if(i < array[0].length - 1)
					System.out.print(array[i][k].getValue() + " ");
				else
					System.out.println(array[i][k].getValue() + " ");
			}
		System.out.println("");
	}

	public static boolean testEqualityOf(Tile[][] a, Tile[][] b) {
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < a[0].length; j++)
				if(a[i][j].getValue() != b[i][j].getValue())
					return false;
		return true;
	}
}
