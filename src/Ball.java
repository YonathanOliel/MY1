import java.awt.geom.Ellipse2D;
public class Ball extends Ellipse2D.Double {
        private double speedX;
        private double speedY;
        public Ball(double centerX, double centerY, double radius, double speedX, double speedY) {
            super(centerX - radius, centerY - radius, radius * 2, radius * 2);
            this.speedX = speedX;
            this.speedY = speedY;
        }
        public void move() {
            this.x += this.speedX;
            this.y += this.speedY;
        }
        public void reverseX() {
            this.speedX *= -1;
        }
        public void reverseY() {
            this.speedY *= -1;
        }
        public void increaseSpeed() {
        this.speedX *= 1.1;
        this.speedY *= 1.1;
    }
}
