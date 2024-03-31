import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class TileManager {
    private Random random;
    GamePanel gamePanel;
    Tile[] tiles;

    public TileManager(GamePanel gamePanel){
        random = new Random();
        this.gamePanel = gamePanel;
        tiles = new Tile[10];

        getTileImage();
    }

    public void getTileImage(){
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/res/space1_1.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/res/space1_2.png"));
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/res/space1_3.png"));
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/res/space1_4.png"));
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/res/space1_5.png"));
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/res/space1_6.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(tiles[0].image, 0, (0), gamePanel.screenWidth, 114, null);
        graphics2D.drawImage(tiles[1].image, 0, (114), gamePanel.screenWidth, 114, null);
        graphics2D.drawImage(tiles[2].image, 0, (114 * 2), gamePanel.screenWidth, 114, null);
        graphics2D.drawImage(tiles[3].image, 0, (114 * 3), gamePanel.screenWidth, 114, null);
        graphics2D.drawImage(tiles[4].image, 0, (114 * 4), gamePanel.screenWidth, 114, null);
        graphics2D.drawImage(tiles[5].image, 0, (114 * 5), gamePanel.screenWidth, 114, null);
    }
}
