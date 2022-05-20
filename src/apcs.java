import java.util.*;
import java.util.Random;
public class apcs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p1= "player 1";
        String p2= "player 2";
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';

            }
        }
        boolean isPlayer1 = true;
        boolean gameEnded = false;
        while (!gameEnded) {
            drawBoard(board);

            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = 'O';
            }
            int row;
            int col;
            while (true) {
                System.out.println("Enter a row(0,1,2)");
                row = in.nextInt();
                System.out.println("Enter a col(0,1,2)");
                col = in.nextInt();

                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("out of bounds");
                } else if (board[row][col] != '-') {
                    System.out.println("aleady made a move");
                } else break;
            }


            board[row][col] = symbol;
            if (hasWon(board) == 'x') {
                System.out.println(p1 + "has won");
                break;

            } else if (hasWon(board) == 'o') {
                System.out.println(p2 + "has won");
                break;
            } else {
                if (Tied(board)) {
                    System.out.println("Tied");
                    break;

                }
            else{
                isPlayer1= !isPlayer1;
            }

        }
    }

}




 public static void drawBoard(char[][] board) {
     for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
             System.out.print(board[i][j]);
         }
         System.out.println();

     }
 }

public static char hasWon(char[][] board) {
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
            return board[i][0];
        }
    }
    for (int j = 0; j < 3; j++) {
        if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
            return board[0][j];
        }
    }
    if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
        return board[2][0];
    }
    if (board[0][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
        return board[2][0];
    }
        return '-';

    }

public static boolean Tied(char[][] board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
}
 }



