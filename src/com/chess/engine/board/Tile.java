package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;



/*
 * Define a class that represents a chess tile
 */


//cannot say New tile cause it is abstract
public abstract class Tile {
	/*
	 * can only be access by the subclasses and final
	 * means this member field can only be set once inside the construct
	*/
	protected final int tileCoordinate;
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();
	
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < 64; i++) {
			emptyTileMap.put(i,  new EmptyTile(i));
		}
		
		return ImmutableMap.copyOf(emptyTileMap);
	}
	
	/*constructor
	* allow us to create an individual tile
	* when we constructor a new instance of a tile
	* it will be assign a tile coordinate equal to
	* whatever is passed into the constructor
	*/
	
	public static Tile createTile(final int tileCoordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
	}
	
	private Tile(int tileCoordinate){
		this.tileCoordinate = tileCoordinate;
	}

	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();
	
	/* Subclasses that represent
	 * either an empty or occupied
	 * tile
	 */
	
	public static final class EmptyTile extends Tile{
		
		EmptyTile(int coordinate){
			super(coordinate);
		}
		
		@Override
		public boolean isTileOccupied() {
			return false;
		}

		@Override
		public Piece getPiece() {
			return null;
		}
	}
	
	public static final class OccupiedTile extends Tile{
		/* Class private
		 * means no way to reference Piece variable
		 * w/o calling getPiece
		 */
		private final Piece pieceOnTile;
		
		OccupiedTile(int tileCoordinate, Piece pieceOnTile){
			super(tileCoordinate);
			this.pieceOnTile = pieceOnTile;
		}
		
		@Override
		public boolean isTileOccupied() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return this.pieceOnTile;
		}
		
	}

}
