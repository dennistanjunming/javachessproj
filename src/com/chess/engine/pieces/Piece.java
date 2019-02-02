package com.chess.engine.pieces;

import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

/*
 * Piece will help us create different pieces
 * in a chess game
 */

public abstract class Piece {
	
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	Piece(final int piecePosition, final Alliance pieceAlliance){
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
	}
	
	//we need to calculate the legal moves of a piece which will return a collection/list of moves
	public abstract List<Move> calculateLegalMoves(final Board board);
	
	
}
