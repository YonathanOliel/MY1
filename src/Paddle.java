import java.awt.Rectangle;
public class Paddle extends Rectangle {
        private int speed;
        public Paddle(int x, int y, int width, int height, int speed) {
                super(x, y, width, height);
                this.speed = speed;
        }
        public void moveUp(int windowHeight) {
                if (this.y > 0) {
                        this.y -= this.speed;
                }
                if (this.y < 0) {
                        this.y = 0;
                }

        }
        public void moveDown(int windowHeight) {
                if (this.y + this.height < windowHeight) {
                        this.y += this.speed;
                }
                if (this.y + this.height > windowHeight) {
                        this.y = windowHeight - this.height;
                }
        }
}
