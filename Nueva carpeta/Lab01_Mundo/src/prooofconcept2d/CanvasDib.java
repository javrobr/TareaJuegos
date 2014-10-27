/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prooofconcept2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author servkey
 */
public class CanvasDib extends Canvas{
    
    private int x = 0;
    private int y = 0;
    private int xi= 349;
    private int yi = 439;
    private BufferedImage sample;
    private BufferedImage fondo;
    
     public CanvasDib(){
    int x = 0;
    int y = 0;
    BufferedImage sample;
    BufferedImage fondo;
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
         if (sample == null) sample = cargarImagen("./images/xF8bit.gif");
         g.drawImage(sample, xi, yi, this);

    }   
    
    public void mover(int key){
    switch(key){
        case 37: System.out.println("Izquierda"+xi+""+yi); xi--;break;
        case 38: System.out.println("Arriba"+xi+""+yi); yi--;break;
        case 39: System.out.println("Derecha"+xi+""+yi);xi++;break;
        case 40: System.out.println("Abajo"+xi+""+yi);yi++;break;
    }
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
    
        
}
