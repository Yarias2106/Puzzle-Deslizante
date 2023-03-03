package ventanaprincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel{
   
    public static Casilla[][]tablero;
    private ArrayList<Casilla> lista = new ArrayList<Casilla>();
    private int dimension;
    private int x,y; // para recortar la imagen en pequeñas
    private int ImagenAncho, ImagenAlto;
    private JLabel vacio;
   
    public Tablero(int dimension, BufferedImage rompecabezas){ //buffered imagen original
        this.dimension = dimension;
        tablero = new Casilla[dimension][dimension];
        this.setBackground(Color.BLACK);
        x =0;
        y =0;
        ImagenAncho = rompecabezas.getWidth()/dimension;
        ImagenAlto= rompecabezas.getHeight()/dimension;
          
        this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
  

        for(int i =0; i<dimension;i++){
            for(int j=0 ; j<dimension; j++){
                if(i== dimension -1 && j== dimension-1){
                    continue;
                }
                lista.add(new Casilla(i,j,new Imagen(i,j, new ImageIcon(rompecabezas.getSubimage(x, y, ImagenAncho, ImagenAlto)),dimension)));
                x+= ImagenAncho;
            }  
            x=0;
            y+= ImagenAlto;
        }
           
        Desordenar();
           
        Remover();             
    }

   
    
    private void Desordenar(){
        Random generador=new Random();
        ArrayList<Casilla>copia = new ArrayList<Casilla>(lista);
        for(int i =0; i<dimension;i++){
            for(int j=0 ; j<dimension; j++){
                if(i==dimension -1 && j== dimension-1){
                    tablero[i][j]= new Casilla(i,j);
                    continue;
                }  
            int aleatorio =generador.nextInt(lista.size());
            lista.get(aleatorio).getImagen().setxActual(i);
            lista.get(aleatorio).getImagen().setyActual(j);
            tablero[i][j]=new Casilla(i,j, lista.get(aleatorio).getImagen());
            lista.remove(aleatorio);
            }
        }
        lista = copia;
        Remover();
    }
  
    private void Actualizar(){
      
        for(int i =0; i<dimension;i++){
            for(int j=0 ; j<dimension; j++){
                if(tablero[i][j].getImagen()==null){
                    vacio = new JLabel();
                    vacio.setPreferredSize(new Dimension(ImagenAncho, ImagenAlto));
                    this.add(vacio);
                    continue;
                }
                this.add(tablero[i][j].getImagen());
            }
        }   
        Puzzle.contenedor.validate();
    }
    
    public void Remover(){
        
        this.removeAll();
        Actualizar();
    }
}
