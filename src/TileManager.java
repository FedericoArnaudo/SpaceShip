import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class TileManager {
    GamePanel gamePanel;
    private ArrayList<Tile> tiles;
    private int countDraw;

    public TileManager(GamePanel gamePanel){
        Random random = new Random();
        tiles = new ArrayList<>();
        countDraw = 0;
        this.gamePanel = gamePanel;
        //tiles = new Tile[12];

        getTileImage();
    }

    public void getTileImage(){
        try {
            for(int i = 0; i < 18; i ++){
                Tile tile = new Tile();
                tile.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/space1/space" + (i+1) + ".png")));
                tiles.add(tile);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) throws InterruptedException {
        for(int i = 0; i < 18; i ++){
            graphics2D.drawImage(tiles.get(i).image, 0, (gamePanel.tileSize * i), gamePanel.screenWidth, gamePanel.tileSize, null);

            if (countDraw == 4 && i == 17){
                Tile tile = tiles.get(i);
                ArrayList<Tile> tiles1 = new ArrayList<>();
                tiles1.add(tile);
                tiles1.addAll(tiles.subList(0,i));
                tiles.clear();
                tiles.addAll(tiles1);
                countDraw = -1;
            }
        }
        countDraw ++;
    }
}
