import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
public class Scene extends JPanel {
    private Paddle player1Paddle;
    private Paddle player2Paddle;
    private Ball ball;
    private int player1Score;
    private int player2Score;
    private static final int WINNING_SCORE = 11;
    public Scene(int width, int height, int winningScore) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.player1Paddle = new Paddle(10, height / 2 - 40, 10, 80, 5);
        this.player2Paddle = new Paddle(width - 20, height / 2 - 40, 10, 80, 5);
        this.ball = new Ball(width / 2, height / 2, 10, 2, 2);

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        player1Paddle.moveUp(getHeight());
                        break;
                    case KeyEvent.VK_S:
                        player1Paddle.moveDown(getHeight());
                        break;
                    case KeyEvent.VK_UP:
                        player2Paddle.moveUp(getHeight());
                        break;
                    case KeyEvent.VK_DOWN:
                        player2Paddle.moveDown(getHeight());
                        break;
                }
            }
        });
        this.setFocusable(true);
        startGame();
    }
    public void startGame() {
        this.player1Score = -1;
        this.player2Score = -1;

        new Thread(()-> {
            while (true) {
                ball.move();

                if (ball.intersects(player1Paddle) || ball.intersects(player2Paddle)) {
                    ball.reverseX();
                }

                if (ball.getMinY() <= 0 || ball.getMaxY() >= getHeight()) {
                    ball.reverseY();
                }
                if (ball.getMinX() <= 0) {
                   this.player1Score++;
                    resetBall();
                } else if (ball.getMaxX() >= getWidth()) {
                   this.player2Score++;
                    resetBall();
                }
                if (player1Score >= WINNING_SCORE || player2Score >= WINNING_SCORE) {
                    break;
                }

                repaint();

                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}).start();
    }
    private void resetBall() {
        this.ball.setFrame(getWidth() / 2 - 10, getHeight() / 2 - 10, 20, 20);
        this.ball.reverseX();
        this.ball.increaseSpeed();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(player1Paddle.x, player1Paddle.y, player1Paddle.width, player1Paddle.height);
        g.fillRect(player2Paddle.x, player2Paddle.y, player2Paddle.width, player2Paddle.height);
        g.fillOval((int) ball.x, (int) ball.y, (int) ball.width, (int) ball.height);

        g.drawString("PLAYER 1 SCORE: " + player1Score, 20, 20);
        g.drawString("PLAYER 2 SCORE: " + player2Score, 20, 40);

        String pongText = "PONG";
        Font font = new Font("Arial", Font.BOLD, 40);
        FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(pongText);
        int textHeight = metrics.getHeight();
        int centerX = getWidth() / 2 - textWidth / 2;
        int centerY = getHeight() / 2 - textHeight / 2;
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString(pongText, centerX, centerY);
    }
}

