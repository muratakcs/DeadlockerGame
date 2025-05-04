package players;

import game.*;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Player67890 extends Player {
    private final Random random;

    public Player67890(Board board) {
        super(board);
        this.random = new Random();
    }

    @Override
    public Move nextMove() {
        List<Move> possibleMoves = board.getPossibleMoves();
        if (possibleMoves.isEmpty()) return null;

        List<Move> trapMoves = new ArrayList<>();

        for (Move move : possibleMoves) {
            board.makeTemporaryMove(move);
            int future = board.getPossibleMoves().size();
            board.undoTemporaryMove();

            if (future <= 2) {
                trapMoves.add(move);
            }
        }

        if (!trapMoves.isEmpty()) {
            return trapMoves.get(random.nextInt(trapMoves.size()));
        }

        return possibleMoves.get(random.nextInt(possibleMoves.size()));
    }
}
