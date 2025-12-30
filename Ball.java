import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
public class Ball{
    private int x;
    private int y;
    private int width;
    private int height;
    //private Game game;
    private int xa;
    private int ya;
    public Ball(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //this.game = game;
        this.xa = 1;
        this.ya = 1;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(x, y, width, height);
        g2d.setColor(Color.BLACK);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;}
    public int getWidth(){
        return this.width;}
    public int getHeight(){
        return this.height;}    
    public int getXa(){
        return this.xa;}
    public int getYa(){
        return this.ya;}
    public void setXa(int xa){
        this.xa = xa;}
    public void setYa(int ya){
        this.ya = ya;}
    public void setX(int x){
        this.x = x;}
    public void setY(int y){
        this.y = y;}

}