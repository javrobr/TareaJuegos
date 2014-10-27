/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    private int x = 0;
    private int y = 0;
    private int xc = 0;

    private int yc = -600;
    private boolean spd=false;
    private int velR= 10;
    private int velNorm=10;
    private int xi= 349;
    private int yi = 439;
    private BufferedImage sample;
    private BufferedImage fondo;
    private BufferedImage fondoc;
    private int sampTAl;

 
    private int sampTAn;
    
     public CanvasDib(){
    int x = 0;
    int y = 0;
    BufferedImage sample;
    BufferedImage fondo;
    BufferedImage fondoc;
     }
    
    
    private BufferedImage cargarImagen(String file){
        BufferedImage img = null;
        try{
            URL image = getClass().getResource(file);
            img = ImageIO.read(image);
        }catch(Exception e){
        }
         return img;
    }
    
    @Override
    public void paint(Graphics g)
    {       
         //g.setColor(Color.BLUE);     //Activa el color azul
         //g.fillOval(getX(), getY(), 60, 60); //Dibuja un óvalo
                 if (fondo == null) fondo= cargarImagen("./images/space.png");
         g.drawImage(fondo,getX(), getY(), this);
         if (fondoc == null) fondoc= cargarImagen("./images/space.png");
         setYc();
         g.drawImage(fondoc,getX(), getYc(), this);
         if (sample == null) sample = cargarImagen("./images/xF8bit.gif");
         setSampTAn(sample.getHeight());
         setSampTAl(sample.getWidth());
         g.drawImage(sample, getXi(), getYi(), this);

    }   

    @Override
    public void update(Graphics g)
    {
        super.update(g);
        paint(g);
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the spd
     */
    public boolean isSpd() {
        return spd;
    }

    /**
     * @param spd the spd to set
     */
    public void setSpd(boolean spd) {
        this.spd = spd;
    }

    /**
     * @return the velR
     */
    public int getVelR() {
        return velR;
    }

    /**
     * @param velR the velR to set
     */
    public void setVelR(int velR) {
        this.velR = velR;
    }

    /**
     * @return the velNorm
     */
    public int getVelNorm() {
        return velNorm;
    }

    /**
     * @param velNorm the velNorm to set
     */
    public void setVelNorm(int velNorm) {
        this.velNorm = velNorm;
    }

    /**
     * @return the xi
     */
    public int getXi() {
        return xi;
    }

    /**
     * @param xi the xi to set
     */
    public void setXi(int xi) {
        this.xi = xi;
    }

    /**
     * @return the yi
     */
    public int getYi() {
        return yi;
    }

    /**
     * @param yi the yi to set
     */
    public void setYi(int yi) {
        this.yi = yi;
    }

    public void setXc(int xc) {
        this.xc = xc;
    }

    public void setYc(int yc) {
        this.yc = yc;
    }
    
    public void setYc() {
        this.yc = getY()-600;
    }
    
        
    public int getYc() {
        return yc;
    }
    
       public int getSampTAl() {
        return sampTAl;
    }

    public void setSampTAl(int sampTAl) {
        this.sampTAl = sampTAl;
    }

    public int getSampTAn() {
        return sampTAn;
    }

    public void setSampTAn(int sampTAn) {
        this.sampTAn = sampTAn;
    }
    
    
    
}
