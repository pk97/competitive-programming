package lld.ticTacToe.v2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    private Deque<Player> players;
    private Piece[][] board;

    private GameStatus status;

    private Scanner sc;

    Game(String player1name, String player2name){
        players = new ArrayDeque<>();
        players.add(new Player(player1name, Piece.ZERO));
        players.add(new Player(player2name, Piece.CROSS));
        board = new Piece[3][3];
        status= GameStatus.IN_PROGRESS;
        sc = new Scanner(System.in);
    }

    void startGame() {
        while(status == GameStatus.IN_PROGRESS) {
            displayBoard();
            Player currentPlayer = players.poll();
            assert currentPlayer != null;
            System.out.println("Enter location for"+ currentPlayer.name);
            int a = sc.nextInt();
            int b = sc.nextInt();
            updateBoard(board, a, b, currentPlayer);
            if (findWinner(board, a, b)) {
                status = GameStatus.FINISHED;
            }
        }
    }

    void displayBoard() {
        for (Piece[] pieces : board) {
            Arrays.stream(pieces)
                    .forEach((p) -> System.out.print(p + " | "));
            System.out.println();
        }
    }

    boolean findWinner(Piece[][] board, int a, int b) {
        return true;
    }

    void updateBoard(Piece[][] board, int x, int y, Player player) {
        if (board[x][y] == null) {
            board[x][y] = player.piece;
            players.add(player);
        }
        else {
            players.addFirst(player);
            System.out.println("Not a valid location!");
        }
    }

}
