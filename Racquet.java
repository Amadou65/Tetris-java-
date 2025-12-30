
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.*;
public class Racquet {
    int x = 0;
	int xa = 0;
    public void paint(Graphics2D g){
        g.fillRect(30, 340, 55, 15);
        g.setColor(Color.BLACK);
    }

    public void  KeyReleased(KeyEvent e){
        xa = 0;
    }
    public void KeyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            xa = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = 1;
        }
    }
    public int getX(){
        return this.x;
    }   
    public void setX(int x){
        this.x = x;
    }
    public int getXa(){
        return this.xa;
    }
    public void setXa(int xa){
        this.xa = xa;
    }
}