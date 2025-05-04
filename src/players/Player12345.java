package players;

import game.*;

import java.util.List;

public class Player12345 extends Player {

    public Player12345(Board board) {
        super(board);
    }

    @Override
    public Move nextMove() {
        List<Move> possibleMoves = board.getPossibleMoves();
        if (possibleMoves.isEmpty()) return null;

        Move worstMove = null;
        int minFutureMoves = Integer.MAX_VALUE;

        for (Move move : possibleMoves) {
            board.makeTemporaryMove(move); // simulate move
            int futureMoves = board.getPossibleMoves().size();
            board.undoTemporaryMove();     // revert

            if (futureMoves < minFutureMoves) {
                minFutureMoves = futureMoves;
                worstMove = move;
            }
        }

        return worstMove;
    }
}
