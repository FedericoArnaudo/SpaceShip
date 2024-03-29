import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PLayer extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public ArrayList<BufferedImage> getBufferedImages() {
        return bufferedImages;
    }

    private ArrayList<BufferedImage> bufferedImages;
    private Random random;


    public PLayer(GamePanel gamePanel, KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        random = new Random();
        bufferedImages = new ArrayList<>();
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 400;
        y = 600;
        speed = 4;
        direction = "left";
    }

    public void getPlayerImage() {
        try {
            flame1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/MainShip194.png")));
            flame2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/MainShip195.png")));
            flame3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/MainShip196.png")));

            bufferedImages.add(flame1);
            bufferedImages.add(flame2);
            bufferedImages.add(flame3);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyHandler.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if (keyHandler.rightPressed) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D graphics2D){
        //  graphics2D.setColor(Color.white);
        //  graphics2D.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage bufferedImage = bufferedImages.get(random.nextInt(getBufferedImages().size()));

        graphics2D.drawImage(bufferedImage, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
