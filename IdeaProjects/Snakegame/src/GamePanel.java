import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;

    int[] x = {100, 75, 50};
    int[] y = {100, 100, 100};

    int bodyParts = 3;

    int foodX = 300;
    int foodY = 300;

    GamePanel() {

        this.setPreferredSize(
                new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)
        );

        this.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {

        drawGrid(g);

        // Draw Snake
        for (int i = 0; i < bodyParts; i++) {

            if (i == 0) {
                g.setColor(Color.GREEN);
            }
            else {
                g.setColor(new Color(45, 180, 0));
            }

            g.fillRect(
                    x[i],
                    y[i],
                    UNIT_SIZE,
                    UNIT_SIZE
            );
        }

        // Draw Food
        g.setColor(Color.RED);

        g.fillOval(
                foodX,
                foodY,
                UNIT_SIZE,
                UNIT_SIZE
        );
    }

    public void drawGrid(Graphics g) {

        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < SCREEN_WIDTH; i += UNIT_SIZE) {

            g.drawLine(
                    i,
                    0,
                    i,
                    SCREEN_HEIGHT
            );
        }

        for (int i = 0; i < SCREEN_HEIGHT; i += UNIT_SIZE) {

            g.drawLine(
                    0,
                    i,
                    SCREEN_WIDTH,
                    i
            );
        }
    }
}