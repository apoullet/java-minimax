package gui;

import calculations.Board;

import javax.swing.*;
import java.awt.*;

public class ticPanel extends JPanel {
    private ticSlot[][] slots = new ticSlot[3][3];
    public int idx, idy;
    private boolean turn = true;

    public ticPanel(Board board) {
        setLayout(new GridLayout(3, 3));

        for (idx = 0; idx < 3; idx++) {
            for (idy = 0; idy < 3; idy++) {
                slots[idx][idy] = new ticSlot(this, board);
                add(slots[idx][idy]);
            }
        }
    }

    public void clearPanel() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (slots[x][y].getLabelIcon() != null)
                    slots[x][y].clearSlot();
            }
        }
    }

    public ticSlot[][] getSlots() {
        return slots;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (slots[x][y].getLabelIcon() != null)
                    slots[x][y].getLabelIcon().paintIcon(this, g2d, slots[x][y].getX(), slots[x][y].getY()  );
            }
        }
    }
}
