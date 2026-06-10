import javax.swing.JFrame;
public class GameFrame extends JFrame{
    GameFrame(){
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        this.setSize(600,600);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
