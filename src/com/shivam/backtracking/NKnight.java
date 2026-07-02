package com.shivam.backtracking;

public class NKnight {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, n);
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board[0].length) { // when we 0
            return;
        }

        if (col == board[0].length) { // Go to next row as we reach till end of col for individual row
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) { // main - logic
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false; // backtracking
        }

        knight(board, row, col + 1, knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // in isSafe going to check those 4 - condition?
        if (isValid(board, row - 2, col - 1)) { // check, is this a valid Co-Ordinate
            if (board[row - 2][col - 1]) { // whether Knight is already available there or not?
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) { // check, is this a valid Co-Ordinate
            if (board[row - 1][col -2]) { // whether Knight is already available there or not?
                return false;
            }
        }

        if (isValid(board, row -2, col + 1)) { // check, is this a valid Co-Ordinate
            if (board[row - 2][col + 1]) { // whether Knight is already available there or not?
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) { // check, is this a valid Co-Ordinate
            if (board[row - 1][col + 2]) { // whether Knight is already available there or not?
                return false;
            }
        }

        return true;
    }


    // Creating a valid fun , if you give it like row n coln, it will check whether it's valid or not
    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;

    }

    // Display current board state (snapshot)
    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for(boolean element : row){
                if (element) { // if queen present
                    System.out.print("K ");
                } else {
                    System.out.print("X "); // empty cell
                }
            }
            System.out.println();
        }
    }
}
