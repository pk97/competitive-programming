package lld.ticTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe('O','X');
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter chance of player 1");
            game.player1Turn(sc.nextInt(), sc.nextInt());
            if (game.isGameOver()) break;
            System.out.println("Enter chance of player 2");
            game.player2Turn(sc.nextInt(), sc.nextInt());
            if (game.isGameOver()) break;
        }

    }
}

class TicTacToe {
    char[][] board;
    private final char player_1_piece;
    private final char player_2_piece;
    private boolean gameOver;

    TicTacToe(char player1Piece, char player2Piece) {
        player_1_piece = player1Piece;
        player_2_piece = player2Piece;
        board = new char[3][3];
        gameOver=false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void player1Turn(int x, int y) {
        if (board[x][y] == 0) {
            board[x][y] = player_1_piece;
            if (checkWInner(x, y)) {
                System.out.println("plyaer1 is winner");
                gameOver = true;
            }
            displayBoard();
        }
        else {
            gameOver=true;
        }
    }

    public void player2Turn(int x,int y) {
        if (board[x][y] == 0) {
            board[x][y] = player_2_piece;
            if (checkWInner(x,y)) {
                System.out.println("plyaer2 is winner");
            }
            displayBoard();
        }
        else {
            gameOver=true;
        }
    }
    private boolean checkWInner(int x,int y) {
        return horizontalConnect(x) || veritcalConnect(y) || rightDigonal() || leftDigonal();
    }

    private boolean veritcalConnect( int y) {
        return board[0][y] == board[1][y] && board[1][y] == board[2][y];
    }
    private boolean horizontalConnect(int x) {
        return board[x][0] == board[x][1] && board[x][1] == board[x][2];
    }

    private boolean rightDigonal() {
        return board[1][1] == board[0][1] && board[1][1] == board[2][2];
    }
    private  boolean leftDigonal() {
        return board[1][1] == board[2][0] && board[1][1] == board[0][2];
    }

    private void displayBoard() {
        Arrays.stream(board)
                .forEach(x -> System.out.println(x));
    }
}
