import javax.swing.*;
public class WindowScene extends JFrame {
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;
    private static final int SCENE_WINNING_SCORE = 11;
    private static final int WINDOW_SCENE_WIDTH = 813;
    private static final int WINDOW_SCENE_HEIGHT = 600;
    Scene scene = new Scene(SCENE_WIDTH,SCENE_HEIGHT,SCENE_WINNING_SCORE);
    public WindowScene(){

        this.setSize(WINDOW_SCENE_WIDTH,WINDOW_SCENE_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(this.scene);
        this.setVisible(true);
    }
}
