package gui;

import calculations.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ticSlot extends JPanel {
    private JLabel pic = new JLabel();
    public int idx, idy;

    public ticSlot(ticPanel parent, Board board) {
        setPreferredSize(new Dimension(200, 200));
        add(pic);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        idx = parent.idx;
        idy = parent.idy;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (board.checkValid(idx, idy)) {
                    board.getBoard()[idx][idy] = 2;
                    parent.setTurn(false);
                    pic.setIcon(new ImageIcon("resources/tictactrump.png"));
                    parent.repaint();
                } else {
                    System.out.println("Spot already taken");
                }
            }
        });
    }

    public void clearSlot() {
        pic.setIcon(null);
        repaint();
    }

    public Icon getLabelIcon() {
        return pic.getIcon();
    }

    public void setLabelIcon() {
        pic.setIcon(new ImageIcon("resources/poutictactoe.png"));
    }
}
