import javax.swing.*;
import java.awt.*;
public class FirstWindow extends JFrame  {
        private static final int WINDOW_WIDTH = 800;
        private static final int WINDOW_HEIGHT = 600;
        public FirstWindow() {

            this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.BLACK);

            JButton start = new JButton("START");
            start.setBounds(300, 350, 200, 50);
            start.setBackground(Color.WHITE);
            start.setForeground(Color.BLACK);
            this.add(start);

            JLabel pongGame = new JLabel("PONG GAME");
            pongGame.setBounds(270, 150, 400, 100);
            pongGame.setForeground(Color.WHITE);
            pongGame.setFont(new Font("Arial", Font.BOLD, 40));
            this.add(pongGame);

            start.addActionListener((e -> {
                    WindowScene windowScene = new WindowScene();
                    this.dispose();
            }));

            JButton gameInstructions = new JButton("GAME INSTRUCTIONS");
            gameInstructions.setBounds(300, 410, 200, 50);
            gameInstructions.setBackground(Color.WHITE);
            gameInstructions.setForeground(Color.BLACK);
            this.add(gameInstructions);

            gameInstructions.addActionListener((e -> {
                   WindowGameInstructions windowGameInstructions = new WindowGameInstructions();
                    this.dispose();
            }));
        }
}
