import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tiles;

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new Tile[10];

        getTileImage();
    }

    public void getTileImage(){
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Space7657.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D){
        for(int i = 0; i < gamePanel.maxScreenCol; i++){
            graphics2D.drawImage(tiles[0].image, (gamePanel.tileSize * i), 0, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
