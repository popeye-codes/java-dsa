package com.shivam.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0)); // prints total number of valid arrangements
    }

    static int queens(boolean[][] board, int row) {
        // Base case: all queens placed successfully
        if (row == board.length) {
            display(board); // snapshot of current valid board
            System.out.println();
            return 1; // count this arrangement
        }

        int count = 0;

        // Try placing queen in every column of the current row
        for (int col = 0; col < board[0].length; col ++) {
            // place the Queen if it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;  // place queen
                count += queens(board, row + 1); // recurse for next row
                board[row][col] = false; // backtrack: remove queen to explore other possibilities
            }
        }

        return count; // return total number of valid arrangements
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        // Check vertically above in the same column
        for (int i = 0; i < row; i ++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check diagonal - left
        int maxLeft = Math.min(row,col); // max steps can go left-up diagonally
        for (int i = 0; i <= maxLeft; i++) {
            if (board[row - i][col - i]) { // if cell has queen, cannot place here
                return false;
            }
        }

        // Check diagonal - right
        int maxRight = Math.min(row, board[0].length - col - 1); // max steps can go right-up diagonally
        for (int i = 0; i <= maxRight; i++) {
            if (board[row - i][col + i]) { // if cell has queen, cannot place here
                return false;
            }
        }

        return true; // safe to place queen here
    }

    // Display current board state (snapshot)
    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for(boolean element : row){
                if (element) { // if queen present
                    System.out.print("Q ");
                } else {
                    System.out.print("X "); // empty cell
                }
            }
            System.out.println();
        }
    }
}
