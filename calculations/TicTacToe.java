package calculations;

import gui.ticFrame;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe tic = new TicTacToe();
        Board board = new Board();
        ticFrame frame = new ticFrame(board);

        while (true) {
            if (board.checkWin(true)) {
                System.out.println("You lose!");
                break;
            } else if (board.checkWin(false)) {
                System.out.println("You win");
                break;
            } else if (board.checkFull()) {
                System.out.println("It's a tie!");
                break;
            }

            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            if (!frame.getPanel().getTurn()) {
                tic.minimax(board, frame, 0, true);
                frame.getPanel().setTurn(true);
            }
        }
    }

    private int minimax(Board board, ticFrame frame, int depth, boolean player) {

        //Returns the according value depending on the end state.
        if (board.checkWin(player)) return -10 + depth;
        if (board.checkWin(!player)) return 10 - depth;
        if (board.checkFull()) return 0;

        //Assigns the starting values depending on who the player is.
        int bestVal = (player) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int value = (player) ? 1 : 2;
        int[] index = {-1, -1};

        if (player) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    //Makes a copy of the board and plays a move.
                    //Then calls minimax to know the value of that move.
                    if (board.getBoard()[x][y] == 0) {
                        Board copy = new Board(board);
                        copy.getBoard()[x][y] = value;

                        int moveVal = minimax(copy, frame, depth + 1, !player);

                        //If the value is bigger than the maximum value, set the max value to that value.
                        if (moveVal > bestVal) {
                            bestVal = moveVal;
                            index[0] = x;
                            index[1] = y;
                        }
                    }
                }
            }
        } else {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board.getBoard()[x][y] == 0) {
                        //Makes a copy of the board and plays a move.
                        //Then calls minimax to know the value of that move.
                        Board copy = new Board(board);
                        copy.getBoard()[x][y] = value;

                        int moveVal = minimax(copy, frame, depth + 1, player);

                        //If the value is smaller than the minimum value, set the min value to that value.
                        if (moveVal < bestVal) {
                            bestVal = moveVal;
                            index[0] = x;
                            index[1] = y;
                        }
                    }
                }
            }
        }

        //Play the best move that was calculated.
        if (depth == 0) {
            board.getBoard()[index[0]][index[1]] = 1;
            frame.getPanel().getSlots()[index[0]][index[1]].setLabelIcon();
        }

        return bestVal;
    }
}
