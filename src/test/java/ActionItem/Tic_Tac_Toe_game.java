package ActionItem;

import java.util.Scanner;

public class Tic_Tac_Toe_game {

    public static void main(String[] args) {
        String[][] board1 = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to TocTacToe! Please decide who is player one(x) and player two(o).");
        int row;
        int column;
        String ps = "";
        String player = "";
        String s = "";
        for (int i = 1; i <= 9; i++) {
            System.out.println();
            if ((i % 2) != 0) {
                ps = "x";
                player = "Player one";
                System.out.println("Player one's turn!");
            } else if ((i % 2) == 0) {
                ps = "o";
                player = "Player two";
                System.out.println("Player two's turn!");
            }


        System.out.println("Please enter which row you would like to mark in(1, 2, or 3).");

        row = reader.nextInt();
        while ((row < 1) || (row > 3)) {
            System.out.println("Please enter 1, 2, or 3!");
            row = reader.nextInt();
        }
        row = row - 1;

        System.out.println("Please enter which column you would like to mark in(1, 2, or 3).");
        column = reader.nextInt();
        while ((column < 1) || (column > 3)) {
            System.out.println("Please enter 1, 2, or 3!");
            column = reader.nextInt();
        }
        column = column - 1;

        while (!(board1[row][column].equals(" "))) {
            System.out.println("Place already marked! Please choose another position.");
            System.out.println("Enter which row you would like to mark in(1, 2, or 3).");
            row = reader.nextInt();
            row = row - 1;
            System.out.println("Please enter which column you would like to mark in(1, 2, or 3).");
            column = reader.nextInt();
            column = column - 1;
        }

        board1[row][column] = ps;

        for (int j = 0; j < 3; j++) {

            if ((j == 1) || (j == 2)) {
                System.out.println("---------");
            }

            for (int k = 0; k < 3; k++) {
                if (k == 2) {
                    System.out.print(board1[j][k] + " ");
                } else {
                    System.out.print(board1[j][k] + " |");
                }
            }
            System.out.println();
        }
        if (((board1[0][0] == ps) && (board1[0][1] == ps) && (board1[0][2] == ps)) ||
                ((board1[1][0] == ps) && (board1[1][1] == ps) && (board1[1][2] == ps)) ||
                ((board1[2][0] == ps) && (board1[2][1] == ps) && (board1[2][2] == ps)) ||

                ((board1[0][0] == ps) && (board1[1][0] == ps) && (board1[2][0] == ps)) ||
                ((board1[0][1] == ps) && (board1[1][1] == ps) && (board1[2][1] == ps)) ||
                ((board1[0][2] == ps) && (board1[1][2] == ps) && (board1[2][2] == ps)) ||

                ((board1[0][0] == ps) && (board1[1][1] == ps) && (board1[2][2] == ps)) ||
                ((board1[0][2] == ps) && (board1[1][1] == ps) && (board1[2][0] == ps))) {
            System.out.println(player + " has won!");

        } else if (i == 9) {
            System.out.println("It's a tie!");
        }
      }
    }
}

