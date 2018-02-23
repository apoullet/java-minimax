package gui;

import calculations.Board;

import javax.swing.*;
import java.awt.*;

public class ticFrame extends JFrame {
    ticPanel ticP;
    public ticFrame(Board board) {
        initialise();

        ticP = new ticPanel(board);
        add(ticP);

        pack();
        setVisible(true);
    }

    private void initialise() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public ticPanel getPanel() {
        return ticP;
    }
}