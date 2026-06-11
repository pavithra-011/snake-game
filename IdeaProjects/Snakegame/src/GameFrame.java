import javax.swing.JFrame;
public class GameFrame extends JFrame{
    GamePanel panel;
    GameFrame(){
        panel = new GamePanel();
        this.add(panel);

        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();
        this.setSize(600,600);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
