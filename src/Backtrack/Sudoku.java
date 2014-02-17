package Backtrack;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku extends Backtrack {
	
	public static final int DIMENSTION = 9;
	public static final int NCELLS = DIMENSTION * DIMENSTION;
	
	public static final List<Integer> ALL_POSSIBLES = Arrays.asList(1,2,3,4,5,6,7,8,9);

	public class Point {
		int x; int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return x + "," + y;
		}
	}
	
	public class Board {
		int[][] m;
		int freeCount;
		Point[] move;
		
		public Board(int[][] m) {
			this.m = m;
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					if (m[i][j] == 0) {
						freeCount++;
					}
				}
			}
			move = new Point[freeCount];
		}
		
		public Point nextMove() {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					if (m[i][j] == 0) {
						return new Point(i, j);
					}
				}
			}
			return null;
		}
		
		public Integer[] possibleMoves(Point p) {
			int x = p.x;
			int y = p.y;
			
			Set<Integer> rowPossibles = new HashSet<>(ALL_POSSIBLES);
			
			for (int i = 0; i < DIMENSTION; i++) {
				if (m[x][i] != 0) {
					rowPossibles.remove(m[x][i]);
				}
			}
			for (int i = 0; i < DIMENSTION; i++) {
				if (m[i][y] != 0) {
					rowPossibles.remove(m[i][y]);
				}
			}
			
			int squareX = (x / 3) * 3;
			int squareY = (y / 3) * 3;
			
			for (int i = squareX; i < squareX + 3; i++) {
				for (int j = squareY; j < squareY + 3; j++) {
					rowPossibles.remove(m[i][j]);
				}
			}
			
			return rowPossibles.toArray(new Integer[rowPossibles.size()]);
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < DIMENSTION; i++) {
				sb.append("\n");
				for (int j = 0; j < DIMENSTION; j++) {
					sb.append(m[i][j] + ",");
				}
			}
			return sb.toString();
		} 
	}
	
	public Sudoku(int[] a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isASolution(int k, Object input) {
		Board b = (Board) input;
		boolean isSolution = k == b.freeCount;
		return isSolution;
	}

	@Override
	public void processSolution(int k, Object input) {
		Board b = (Board) input;
		System.out.println(b);
	}

	@Override
	public int constructCandidates(int k, Object input, int[] c) {
		
		Board b = (Board) input;
		
		Point nextPoint = b.nextMove();
		if (nextPoint == null) throw new RuntimeException("There are no more moves");
		
		b.move[k - 1] = nextPoint;
		
		Integer[] possibles = b.possibleMoves(nextPoint);
		for (int i = 0; i < possibles.length; i++) {
			c[i] = possibles[i];
		}
		
		return possibles.length;
	}

	@Override
	public void makeMove(int k, Object input) {
		// TODO Auto-generated method stub
		
		Board b = (Board) input;
		
		Point move = b.move[k - 1];
		b.m[move.x][move.y] = a[k];
	}

	@Override
	public void unmakeMove(int k, Object input) {
		Board b = (Board) input;
		
		Point move = b.move[k - 1];
		b.m[move.x][move.y] = 0;
	}
	
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku(new int[DIMENSTION * DIMENSTION]);
		
		Board b = s.new Board(
				new int[][]{
						{0, 0, 0, 0, 0, 0, 0, 1, 2},
						{0, 0, 0, 0, 3, 5, 0, 0, 0},
						{0, 0, 0, 6, 0, 0, 0, 7, 0},
						
						{7, 0, 0, 0, 0, 0, 3, 0, 0},
						{0, 0, 0, 4, 0, 0, 8, 0, 0},
						{1, 0, 0, 0, 0, 0, 0, 0, 0},
						
						{0, 0, 0, 1, 2, 0, 0, 0, 0},
						{0, 8, 0, 0, 0, 0, 0, 4, 0},
						{0, 5, 0, 0, 0, 0, 6, 0, 0},
				}
				
				);
		System.out.println(b);
		
		System.out.println("");
		System.out.println("After process");
		
		s.backtract(0, b);
	}

}
