import javax.swing.*;
import java.awt.*;
public class WindowGameInstructions extends JPanel {
    private static final int WINDOW_WIDTH = 601;
    private static final int WINDOW_HEIGHT = 852;
    private ImageIcon instructions;
    public WindowGameInstructions(){

        instructions = new ImageIcon("\u200F\u200Fpong.png");

        JFrame frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(this);
        frame.setVisible(true);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.instructions.paintIcon(this, g, 0, 0);
    }
}
