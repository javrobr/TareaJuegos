/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame{
    private Thread t;
    private CanvasDib c;

    public FrmGame(final CanvasDib c){
        
            c.addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent e) {
       
       int x= e.getKeyCode();
        System.out.println("" + e.getKeyCode());
        c.mover(x);
     
      }

      public void keyReleased(KeyEvent e) {
      }

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    });    
        

        this.c = c;
        add(c);
        //Iniciar hilo
        t = new Thread(){
              public void run(){
                  updating();
              }
        };
        t.start();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    public void updating(){
        while (true){
            try {
                
                Thread.sleep(100);
                
                c.repaint();
               
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
}
