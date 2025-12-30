import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.List;
public class Game extends JPanel{
    
    private Racquet racquet;
    private List<Ball> list;
    public Game(){
        this.racquet = new Racquet();
        addKeyListener(new KeyListener() {
            
            public void keyTyped(KeyEvent e){ }
            
            public void keyPressed(KeyEvent e){
                racquet.KeyPressed(e);
            }
            
            public void keyReleased(KeyEvent e){
                racquet.KeyReleased(e);
            }
        });
        list = new ArrayList<>();
        }
        
    
    public void addBall(Ball b){
        list.add(b);
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            for (Ball ball : list){
            ball.paint(g2d);
        }
        racquet.paint(g2d);
        
    }
    /**
     * methods that move the racquet
     */
    public void moveRacquet(){
        if (racquet.getX() + racquet.getXa() > 0 && racquet.getX() + racquet.getXa() < this.getWidth()-60)
        racquet.setXa(1);            
    }
    public void moveBall() {
    for (Ball ball: list){

        // Utiliser ball avec son type Ball
        if (ball.getX() + ball.getXa() < 0)
            ball.setXa(1);
        
        if (ball.getX() + ball.getXa() > this.getWidth() - ball.getWidth())
            ball.setXa(-1);
        
        if (ball.getY() + ball.getYa() < 0)
            ball.setYa(1);
        
        if (ball.getY() + ball.getYa() > this.getHeight() - ball.getHeight())
            ball.setYa(-1);
        
        // Déplacer la balle
        ball.setX(ball.getX() + ball.getXa());
        ball.setY(ball.getY() + ball.getYa());
    }
}
    
    public static void main(String args []) throws InterruptedException{
        JFrame fenetre = new JFrame("Mini Tetris");
          Game game = new Game();  // UN seul Game
    
    // Ajouter plusieurs balles dans game
        game.addBall(new Ball(30, 30, 30, 30));
        game.addBall(new Ball(260, 360, 30, 30));
        game.addBall(new Ball(200, 300, 30, 30));
        game.addBall(new Ball(100, 150, 30, 30));
        game.addBall(new Ball(50, 200, 30, 30));
        game.addBall(new Ball(150, 250, 30, 30));
        game.addBall(new Ball(80, 120, 30, 30));
        game.addBall(new Ball(220, 80, 30, 30));
        System.out.println("game ajouté");
        fenetre.add(game);
        System.out.println("game2 ajouté (game est maintenant invisible !)");
        fenetre.setSize(300, 400);
        fenetre.setVisible(true);
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(fenetre.EXIT_ON_CLOSE);
        while (true){

            game.moveBall();
            game.repaint();
            Thread.sleep(2);
        }
    }
}
