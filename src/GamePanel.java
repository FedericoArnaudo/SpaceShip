import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //  Screen Settings
    final int originalTileSize  = 19;   //  19x19
    final int scale = 3;
    public int tileSize = originalTileSize * scale;  //  57x57
    final int maxScreenCol = 16;
    final int maxScreenRow = 17;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyHandler = new KeyHandler();
    Player player = new Player(this, keyHandler);
    TileManager tileManager = new TileManager(this);
    Thread gameThread;

    //  FPS
    final int FPS = 60;
    double delta = 0;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;   //1ps/FPS   intervalo de refresh
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null){
            //System.out.println("The game ir running");

             // 1 UPDATE:   update information such as character positions
            upDate();
             // 2 DRAW:     draw the screen with the updated information
            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void upDate(){
        player.update();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D  graphics2D = (Graphics2D) graphics;

        try {
            tileManager.draw(graphics2D);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        player.draw(graphics2D);

        graphics2D.setFont(new Font("Arial", Font.PLAIN, 10));
        graphics2D.drawString("FPS", 750, 30);
        graphics2D.dispose();
    }
}
