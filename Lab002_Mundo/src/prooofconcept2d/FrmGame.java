/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;

/**
 *
 * @author servkey
 */
public class FrmGame extends JFrame{
    private Thread t;
    private CanvasDib c;
    int tmp=0;
    
    public FrmGame(final CanvasDib c) throws IOException, MidiUnavailableException, FileNotFoundException, InvalidMidiDataException{
        
            c.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(KeyEvent e) {
      try {
       int x= e.getKeyCode();
       int x2=e.getExtendedKeyCode();
        System.out.println(x2+" " + e.getKeyCode());
       control(x);
      }
      catch (Exception ex){
          
      }
      
      
      // 
     
      }

      public void keyReleased(KeyEvent e) {
      }

            @Override
            public void keyTyped(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        audio();
     
        this.getContentPane().setBackground(Color.WHITE);
    }
    
        
    public void control(int key){
    switch(key){
        case 37: System.out.println( "Izquierda "+ c.getXi()+""+c.getY()); if (c.getXi()>0){c.setXi(c.getXi()-c.getVelNorm());} break;
        case 38: System.out.println("Arriba "+c.getXi()+""+c.getY()); if (c.getYi()>0){c.setYi(c.getYi()-c.getVelNorm());}break;
        case 39: System.out.println("Derecha "+c.getXi()+""+c.getY()); if (c.getXi()<(800-165)){c.setXi(c.getXi()+c.getVelNorm());}break;
        case 40: System.out.println("Abajo "+c.getXi()+""+c.getY()); if (c.getYi()<(600-165)){c.setYi(c.getYi()+c.getVelNorm());}break;
        case 32: System.out.println("disparo ");break;
    }
    }
    public void avanzar(int avn){
        c.setY(avn+1);
        System.out.println(avn);
    }
    
    public void audio() throws MidiUnavailableException, FileNotFoundException, IOException, InvalidMidiDataException{
    // Obtains the default Sequencer connected to a default device.

        Sequencer sequencer = MidiSystem.getSequencer();

 

        sequencer.open();

        InputStream is = new BufferedInputStream(new FileInputStream(new File("Battle.mid")));

        sequencer.setSequence(is);

        sequencer.start();

    }
    
    public void updating(){
       
        while (true){
            try {
                
                Thread.sleep(100);
                System.out.println(c.getSampTAl()+" "+c.getSampTAn());
                c.repaint();
               
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmGame.class.getName()).log(Level.SEVERE, null, ex);
            }       
            tmp ++;
            if (tmp==600){tmp=0;}
            avanzar(tmp);
             
        }
    }
}
