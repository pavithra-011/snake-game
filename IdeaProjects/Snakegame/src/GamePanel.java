import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 150;

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    int bodyParts = 3;

    int foodX;
    int foodY;

    char direction = 'R';

    Timer timer;

    GamePanel() {

        this.setPreferredSize(
                new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)
        );

        this.setBackground(Color.BLACK);

        this.setFocusable(true);

        this.addKeyListener(new MyKeyAdapter());

        startGame();
    }

    public void startGame() {

        x[0] = 100;
        y[0] = 100;

        x[1] = 75;
        y[1] = 100;

        x[2] = 50;
        y[2] = 100;

        foodX = 300;
        foodY = 300;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {

        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < SCREEN_WIDTH; i += UNIT_SIZE) {
            g.drawLine(i, 0, i, SCREEN_HEIGHT);
        }

        for (int i = 0; i < SCREEN_HEIGHT; i += UNIT_SIZE) {
            g.drawLine(0, i, SCREEN_WIDTH, i);
        }

        g.setColor(Color.RED);

        g.fillOval(
                foodX,
                foodY,
                UNIT_SIZE,
                UNIT_SIZE
        );

        for (int i = 0; i < bodyParts; i++) {

            if (i == 0) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(new Color(45, 180, 0));
            }

            g.fillRect(
                    x[i],
                    y[i],
                    UNIT_SIZE,
                    UNIT_SIZE
            );
        }
    }

    public void move() {

        for (int i = bodyParts; i > 0; i--) {

            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {

            case 'U':
                y[0] -= UNIT_SIZE;
                break;

            case 'D':
                y[0] += UNIT_SIZE;
                break;

            case 'L':
                x[0] -= UNIT_SIZE;
                break;

            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        move();

        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;

                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}